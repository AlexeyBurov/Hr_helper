function HRViewModel() {

    var self = this;
    self.complaintData = {from: ko.observable(), complaint: ko.observable()};
    self.searchData = {vacancy:ko.observable(),name:ko.observable()};
    self.commentData = {from: ko.observable(), comment: ko.observable()};
    self.complaintsData = ko.observableArray();
    self.commentsData = ko.observableArray();
    self.personsData = ko.observableArray();
    self.vacanciesData = ko.observableArray();
    self.userSignInData = {username: ko.observable(), password: ko.observable() , token:ko.observable('')};

    /**
     * Functions for operations with messages
     * @param message
     * @param status
     */
    self.doMessage = function (message, status) {
        $('#error-message').html(message);
        if(status === 'info'){
            $('#error-div').removeClass('hidden').addClass('info');
        }else if(status === 'error'){
            $('#error-div').removeClass('hidden').addClass('error');
        }else if(status === 'success'){
            $('#error-div').removeClass('hidden').addClass('success');
        }
    };

    self.closeMessage = function () {
        $('#error-div').addClass('hidden').removeClass('info').removeClass('error').removeClass('success');
    };

    /**
     * Login operations
     */
    self.autoLogin = function () {
        $.ajaxSetup({
            beforeSend: function(xhr) {
                xhr.setRequestHeader('authorization', self.userSignInData.token());
            }
        });
    };

    self.login = function () {
        $('#login-form').removeClass('hidden');
        return true;
    };


    self.logout = function () {
        self.hideElements();
        $('#login_href').removeClass('hidden');
        ko.userSignInData.token('');
    };

    self.signIn = function () {
        $.ajax('/account/signIn',{
            type: 'POST',
            data: ko.toJSON(self.userSignInData),
            contentType: 'application/json',
            success: function (data) {
                if(!data.error) {
                    self.userSignInData.token(data.token);
                    self.doMessage(data.message,'success');
                    $('#login-form').addClass('hidden');
                    $('#login_href').addClass('hidden');
                    self.unHideElements();
                    self.autoLogin();
                    self.getProtectedData();
                }else {
                    self.doMessage(data.message,'error');
                }
            }
        });
    };

    /**
     * Operation with comments and complaint
     */
    self.displayComplaints = function() {
        $.get('/rest/complaints/protected/complaint', self.complaintsData);
    };

    self.displayComments = function () {
        $.get('/rest/comments/comment',self.commentsData);
    };

    self.displayPersons = function () {
        $.get('/rest/persons/protected/allPersons',{vacancy: self.searchData.vacancy, name: self.searchData.name},self.personsData);
    };

    self.getVacancies = function () {
       $.get('/rest/vacancies/allVacancies',self.vacanciesData);
    };


    self.approveComplaint = function () {
        var complaint = this;
        $.ajax({
            url: '/rest/complaints/protected/complaint',
            type: 'PUT',
            data: ko.toJSON(complaint),
            contentType: 'application/json',
            success: function (data) {
                if (data === true) {
                    self.complaintsData.remove(complaint);
                    self.doMessage("Complaint approved",'success');
                }else{
                    self.doMessage("Something wrong",'error');
                }
            }
        });
    };


    self.sendComplaintsForm = function() {
        $.ajax('/rest/complaints/complaint', {
            type: 'POST',
            data: ko.toJSON(self.complaintData),
            contentType: "application/json",
            success: function (data) {
                if(data === true){
                    self.displayComplaints();
                    self.complaintData.from("");
                    self.complaintData.complaint("");
                    self.doMessage("Complaint successfully send",'success');
                }else {
                    self.doMessage("Something wrong",'error');
                }
            }
        });

    };

    self.like = function () {
        $.ajax({
            url: '/rest/comments/like',
            type: 'PUT',
            data: ko.toJSON(this),
            contentType: 'application/json',
            statusCode: {
                200: function() {
                    self.displayComments();
                },
                400: function () {
                    alert('Bad Request');
                }
            }
        });
    };

    self.dislike = function () {
        $.ajax({
            url: '/rest/comments/dislike',
            type: 'PUT',
            data: ko.toJSON(this),
            contentType: 'application/json',
            statusCode: {
                200: function() {
                    self.displayComments();
                },
                400: function () {
                    alert('Bad Request');
                }
            }
        });
    };


    self.sendCommentForm = function() {
        $.ajax('/rest/comments/comment', {
            type: 'POST',
            data: ko.toJSON(self.commentData),
            contentType: 'application/json',
            success: function (data) {
                if(data === true){
                    self.displayComments();
                    self.commentData.from('');
                    self.commentData.comment('');
                    self.doMessage('Comment added','success');
                }else{
                    self.doMessage('Something wrong','error');
                }
            }
        });

    };
    /**
     * Operations with persons
     * @param pForm
     */
    self.savePerson = function (pForm) {
        var formData = new FormData(pForm);
        $.ajax('/rest/persons/person',{
            type: 'POST',
            processData: false,
            contentType: false,
            data: formData,
            success: function (data) {
                if(data === true){
                    self.doMessage('You resume saved we calling you!','success');
                }else{
                    self.doMessage('Something wrong','error');
                }
            }
        });
    };

    self.searchFunction = function () {
        self.displayPersons();
    };

    self.deletePerson = function () {
        var person = this;
          $.ajax('/rest/persons/protected/person?id='+this.id,{
              type:'DELETE',
              processData: 'application/x-www-form-urlencoded',
              success: function (data) {
                  if(data === true){
                      self.doMessage('Person deleted!','success');
                  }else{
                      self.doMessage('Something wrong','error');
                  }
              }
          });
    };

    /**
     * Send email functions
     */
    self.sendApprovingEmail = function () {
        var formData = new FormData();
        formData.append('id',this.id);
        formData.append('flag',true);
        $.ajax('/rest/emails/protected/sendEmail',{
            type:'POST',
            processData: false,
            contentType: false,
            data: formData,
            success: function (data) {
                if(data === true){
                    self.doMessage('Email send!','success');
                }else{
                    self.doMessage('Something wrong','error');
                }
            }
        });
    };

    self.sendRefusalEmail = function () {
        var formData = new FormData();
        formData.append('id',this.id);
        formData.append('flag',false);
        $.ajax('/rest/emails/protected/sendEmail',{
            type:'POST',
            processData: false,
            contentType: false,
            data: formData,
            success: function (data) {
                if(data === true){
                    self.doMessage('Email send!','success');
                }else{
                    self.doMessage('Something wrong','error');
                }
            }
        });
    };

    /**
     * Functions for operations with menu
     * @returns {boolean}
     */
    self.main = function () {
        self.resetSelectedClass();
        $('#main_href').addClass('active');
        return true;
    };

    self.aboutUs = function () {
        self.resetSelectedClass();
        $('#aboutUs_href').addClass('active');
        return true;
    };

    self.aboutUs = function () {
        self.resetSelectedClass();
        $('#aboutUs_href').addClass('active');
        return true;
    };

    self.contacts = function () {
        self.resetSelectedClass();
        $('#contacts_href').addClass('active');
        return true;
    };

    self.resume = function () {
        self.resetSelectedClass();
        $('#resume_href').addClass('active');

        return true;
    };

    self.persons = function () {
        self.resetSelectedClass();
        $('#persons_href').addClass('active');

        return true;
    };

    self.complaints = function () {
        self.resetSelectedClass();
        $('#complaints_href').addClass('active');
        return true;
    };

    self.addComplaint = function () {
        self.resetSelectedClass();
        $('#add_complaint_href').addClass('active');
        return true;
    };

    self.comments = function () {
        self.resetSelectedClass();
        $('#comments_href').addClass('active');
        return true;
    };

    self.resetSelectedClass =  function (){
        $('.active').removeClass('active');
    };


    /**
     * Functions for operations with protected elements
     */
     self.hideElements = function () {
        $('#login-form').addClass('hidden');
        $('#logout_href').addClass('hidden');
        $(".protected").addClass('hidden');
    };

    self.unHideElements = function () {
        $('.protected').removeClass('hidden');
        $('#logout_href').removeClass('hidden');
    };

    self.getProtectedData = function () {
        self.displayComplaints();
        self.displayPersons();
    };

    /**
     * Initialization functions calling
     */
    self.hideElements();
    self.displayComments();
    self.getVacancies();
}

ko.applyBindings(new HRViewModel());
