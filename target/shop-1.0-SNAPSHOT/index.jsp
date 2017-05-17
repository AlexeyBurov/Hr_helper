<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
    <head>
        <meta charset="utf-8">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Course work</title>
        <!--<link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">-->

        <!-- Bootstrap -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/MyStyles.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
  <nav class="navbar navbar-default navbar-fixed-top header navbar-inverse">
   <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <img class="header-img" src = "assets/img/header-logo.jpg">
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <!-- /.navbar-collapse -->
    <div style = "text-align: right;" class="my-header" id="header">
      <ul class="nav navbar-nav navbar-right" id="menu">
          <li id="main_href"><a href="#top" data-bind="click: $root.main">Главная</a></li>
          <li id="aboutUs_href"><a href="#aboutUs" data-bind="click: $root.aboutUs">О нас</a></li>
          <li id="contacts_href"><a href="#contacts" data-bind="click: $root.contacts">Контакты</a></li>
          <li id="resume_href"><a href="#resume" data-bind="click: $root.resume">Отправить резюме</a></li>
          <li id="persons_href" class="protected"><a href="#persons" data-bind="click: $root.persons">Люди</a></li>
          <li id="add_complaint_href"><a href="#add_complaint" data-bind="click: $root.addComplaint">Добавить Жалобу</a></li>
          <li id="complaints_href" class="protected"><a href="#complaints" data-bind="click: $root.complaints">Жалобы</a></li>
          <li id="comments_href"><a href="#comments" data-bind="click: $root.comments">Коментарии</a></li>
          <li id="login_href"><a href="#login-form" data-bind="click: $root.login" id="login">Вход</a></li>
          <li id="logout_href"><a href="#top" data-bind="click: $root.logout" id="logout">Выход</a></li>
      </ul>
    </div>
   </div><!-- /.container-fluid -->
  </nav>
    <div class="content">
        <div class="alert hidden navbar-fixed-top" id="error-div">
            <span class="closebtn" data-bind="click: closeMessage">&times;</span>
            <span id="error-message">This is an alert box.</span>
        </div>
    <a name="#top"></a>
    <div class="container">
        <div id="captioned-gallery">
            <figure class="slider">
                <figure>
                    <img src="assets/img/1.jpg" alt>
                    <figcaption>Вас ждёт работа в интересных коллективах!</figcaption>
                </figure>
                <figure>
                    <img src="assets/img/2.jpg" alt>
                    <figcaption>Интересные проекты!</figcaption>
                </figure>
                <figure>
                    <img src="assets/img/3.jpg" alt>
                    <figcaption>Комфортные условия труда!</figcaption>
                </figure>
                <figure>
                    <img src="assets/img/5.jpg" alt>
                    <figcaption>Вы обязательно расскроете свой потенциал!</figcaption>
                </figure>
            </figure>
        </div>
    </div>
    </div>
    <div  class="hidden" id="login-form">
        <section>
            <div class="form main-text">
                <form  id="signIn-form" data-bind="submit: signIn">
                    <div class="form-group">
                        <label for="comment_from">Email</label>
                        <input type="text" class="form-control" id="email-input" name="form" data-bind="value: userSignInData.username">
                    </div>
                    <div class="form-group">
                        <label for="comment_text">Пароль</label>
                        <input type="password" class="form-control" id="password-input" name="comment" data-bind="value: userSignInData.password">
                    </div>
                    <div class="form-group">
                        <input  type="submit" class="btn btn-primary" id="submit-login">
                    </div>
                </form>
            </div>
        </section>
    </div>
        <section id="aboutUs">
                <div class="main-text">
                    <h1>О компании</h1>
                    <h4>Мы это</h4>
                    <p>Рекламно-кадровое агентство «HeVer». Коктейль молодых талантов. Креатив, прекрасное чувство юмора, безупречный вкус
                        и отличные организаторские способности.Личные качества — всегда выполняем свои обещания, верим в успех, надежны, стрессоустойчивы,
                        ответственны за результат.Профессиональные качества — клиентоориентированность, высокий профессионализм, четкое соблюдение сроков.
                    </p>
                    <p>Агентство HeVer предлагает высококлассный сервис по подбору квалифицированного персонала в престижные офисы Минска.
                        Подбор персонала для работы в офисах– это трудоемкий, эмоциональный и длительный процесс, требующий от кадровых сотрудников глубоких знаний, колоссального опыта и затрат огромного количества времени и усилий.
                        Наши специалисты обладают солидным практическим опытом работы в сфере поиска квалифицированных работников. Мы знаем, как определить потенциал каждого специалиста, проверить его надежность и соответствие пожеланиям и потребностям конкретного клиента.
                        Практикуя в своей работе индивидуальный подход, мы закрепляем за каждым клиентом персонального менеджера – высококлассного специалиста, обладающего глубокими знаниями и практическими навыками в области рекрутинга. Владея всеми тонкостями работы по подбору работников, наши специалисты оперативно и умело справятся с любой, поставленной перед ними задачей.
                    </p>

                    <ul>
                        <li>Проведение основательной и тщательной проверки каждого специалиста (проверка документов и достоверности рекомендаций).</li>
                        <li>Использование в работе эффективных методик тестирования соискателей.</li>
                        <li>Индивидуальный подход, каждый заказ закреплен за персональным менеджером.</li>
                        <li>Абсолютная конфиденциальность.</li>
                        <li>Обширная база соискателей.</li>
                    </ul>
                    <p>Агентство HeVer заинтересовано в быстром и положительном решении Ваших проблем с поиском домашнего персонала. Наши сотрудники приложат все усилия для того, чтобы в Вашем офисе работали настоящие профессионалы. </p>
                    <label>Сотрудничество с нашим агентством «HeVer» позволит Вам: </label>
                    <dl>
                        <dt>Сэкономить время.</dt>
                        <dd>Мы экономим Ваше время, обладая большим опытом в сферах рекрутинга, BTL, event и PR мы снимаем с Вас головную боль о том, что нужно для запуска проекта, и где это можно найти. Мы сами потратим время на поиск персонала, организацию мероприятий, проведение PR и BTL акций. Мы собираем всю аналитику по проекту, консультируем и рекомендуем лучшие варианты исполнения, подготавливаем и предоставляем полную отчетность.Организуем, проведем и проконтролируем любое промо- и пресс- мероприятие.
                            Проведем тренинги для тайных покупателей, аудиторов и блогеров. Составим и проверим отчеты.
                            Мы готовы осуществить профессиональную подготовку к проекту качественно и в срок.
                        </dd>
                        <dt>Сэкономить деньги.</dt>
                        <dd>Рекламно-кадровое агентство «HeVer» имеет собственную базукандидатов и журналистов, постоянно пополняемую,
                            а также доступ ко всем необходимым Интернет-ресурсам для работы. В процессе поиска кандидатов, в зависимости
                            от профиля позиции и сегмента рынка, используем как стандартные, так и нестандартные методы поиска и подбора кадров.
                            За счет гибкой ценовой политики мы оптимизируем Ваш бюджет, обеспечивая максимальный приток потенциальных кандидатов и потребителей.
                        </dd>

                        <dt>Сэкономить человеческий ресурс .</dt>
                        <dd>В Вашей компании нет квалифицированных специалистов по персоналу,
                            BTL и пиару или Ваши внутренние службы перегружены? Если Вы не готовы нанимать дополнительного
                            квалифицированного специалиста для выполнения задач – это актуально как для малых и средних,
                            так и для крупных компаний, – воспользуйтесь возможностью привлечь профессиональных специалистов агентства «HeVer»
                            (Минск и регионы), которые понимают Ваши бизнес процессы и позицию в целом.
                        </dd>
                        <dt>Возможность выбора из лучших.</dt>
                        <dd>Наша цель – помочь Вам достичь успеха. Мы уверены, что добросовестность, честность и профессионализм –
                            это залог взаимовыгодного сотрудничества.Потому что наши клиенты – это наши Партнеры!
                            Мы всегда готовы не только выполнить заказ в установленные сроки, но и заботимся о качестве выполненной работы.
                            Наше кредо – это индивидуальный подход к каждому клиенту, креативное решение поставленных перед нами задач,
                            стремление, чтобы каждая рекламная акция имела свой неповторимый стиль, а каждый сотрудник, подобранный нашим агентством,
                            работал продуктивно и качественно. Мы стараемся достигнуть лучшего результата в работе и надеемся стать для вас надежным
                            и постоянным деловым партнером.Мы выражаем глубокую признательность тем компаниям, которые оценили преимущества сотрудничества с нами
                            и являются нашими постоянными партнерами на протяжении нескольких лет.
                        </dd>
                    </dl>
                </div>
            </div>
        </section>

        <section id="contacts">
          <div class="main-text">
              <h2>Контакты</h2>
              <h3>Здравствуйте меня зовут Вероника и HR-менеджер в данной компании для связи со мной используйте контакты приведённые ниже</h3>
              <p>Вероника Майстранкова</p>
              <div class="contacts">
                  <p>email: *******@gmail.com</p>
                  <p>Телефон: +37525*******</p>
              </div>
          </div>
        </section>

        <section id="resume">
            <div class="main-text">
                <div>
                    <h2>Отправить резюме</h2>
                    <p>Отправте нам своё резюме и мы порекомендуем вас нашим партнёрам!</p>
                </div>
                <div id = "personSave">
                    <form  enctype="multipart/form-data" id="data" data-bind="submit: savePerson">
                    <div class="form-group">
                        <label for="fio">ФИО</label>
                        <input type="text" class="form-control" name="userName" id="fio" placeholder="ФИО">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="Введите адрес электронной почты">
                    </div>
                    <div class="form-group">
                        <label for="telephone">Телефон</label>
                        <input type="text" class="form-control" name="phoneNumber" id="telephone" placeholder="Телефон">
                    </div>
                    <div class="form-group">
                        <label for="vacancy">Вакансия</label>
                        <select  class="form-control" name="vacancy" data-bind="foreach: vacanciesData" id="vacancy">
                            <option data-bind="text: vacancyName"></option>
                        </select>
                        <!--<input type="text" class="form-control" name="vacancy" id="vacancy" placeholder="Вакансия">-->
                    </div>
                    <div>
                        <label class="btn btn-default btn-primary btn-file file-btn">Резюме
                            <input type="file" id="exampleInputFile" name="resume">
                        </label>
                        <p class="help-block">Прикрепите сюда своё резюме в форматах : .doc, docx, .pdf</p>
                    </div>
                    <button type="submit" class="btn btn-primary">Отправить Заявку</button>
                    </form>
                </div>
            </div>
        </section>

        <section id="persons" class="protected">
            <div class="main-text">
                <h2>Люди</h2>

                <div class="input-group search-input">
                    <label for="vacancySearch">Вакансия</label>
                    <input type="text" class="form-control" id="vacancySearch" data-bind="textInput: searchData.vacancy, event:{ change: $root.searchFunction}">
                </div>
                <div class="input-group search-input">
                    <label for="nameSearch">Имя</label>
                    <input type="text" id="nameSearch" class="form-control" data-bind="textInput: searchData.name, event:{ change: $root.searchFunction}">
                </div>

                <table class="table borderless">
                    <thead><tr><th>ФИО</th><th>Email</th><th>Telephone</th><th>Vacancy</th></tr></thead>
                    <tbody data-bind="foreach: personsData">
                        <tr>
                            <td data-bind="text: name"></td>
                            <td data-bind="text: email"></td>
                            <td data-bind="text: telephone"></td>
                            <td data-bind="text: vacancy"></td>
                            <td>
                                <a class="btn btn-sm btn-primary" data-bind="attr:{href: pathToResume}">Резюме</a>
                                <button data-bind="click: $root.sendApprovingEmail" class="btn btn-sm btn-success">Принять</button>
                                <button data-bind="click: $root.sendRefusalEmail" class="btn btn-sm btn-warning">Отказать</button>
                                <button data-bind="click: $root.deletePerson" class="btn btn-sm btn-danger">Удалить</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>

        <section id="complaints" class="protected">
            <div class="main-text">
                <h2>Жалобы</h2>
                <table class="table">
                    <thead><tr><th>From</th><th>Complaint</th><th>Stage</th><th>Date</th></tr></thead>
                    <tbody data-bind="foreach: complaintsData">
                    <tr>
                        <td data-bind="text: from"></td>
                        <td data-bind="text: complaint"></td>
                        <td data-bind="text: stage"></td>
                        <td data-bind="text: date"></td>
                        <td><button class="btn btn-success" data-bind="click: $root.approveComplaint">Approve</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </section>

        <section id="add_complaint">
            <div class="main-text">
                <h2>Добавить жалобу</h2>
                <form  id="complaint_form" data-bind="submit: sendComplaintsForm">
                        <div class="form-group">
                            <label for="complaint_from">Email</label>
                            <input type="text" class="form-control" id="complaint_from" name="form" data-bind="textInput: complaintData.from">
                        </div>
                        <div class="form-group">
                            <label for="complaint_text">Жалоба</label>
                            <textarea  rows="5" class="form-control" id="complaint_text" name="complaint" data-bind="textInput: complaintData.complaint"></textarea>
                        </div>
                        <div class="form-group">
                            <input  type="submit" class="btn btn-primary" id="submit_complaint">
                        </div>
                </form>
            </div>
        </section>

        <section id="comments">
            <div class="main-text">
                <h2>Коментарии</h2>
                <table class="table">
                    <thead><tr><th>From</th><th>Comment</th><th>Date</th><th>Likes</th><th>Dislikes</th></tr></thead>
                    <tbody data-bind="foreach: commentsData">
                    <tr>
                        <td data-bind="text: from"></td>
                        <td data-bind="text: comment"></td>
                        <td data-bind="text: date"></td>
                        <td>
                            <button data-bind="click: $root.like" class="btn btn-success">
                                <span class="glyphicon glyphicon-thumbs-up"></span> <span data-bind="text: likes"></span>
                            </button>
                        </td>
                        <td>
                            <button data-bind="click: $root.dislike" class="btn btn-danger">
                                <span class="glyphicon glyphicon-thumbs-down"></span> <span data-bind="text: dislikes"></span>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <h3>Добавить комментарий</h3>
                <form  id="comments_form" data-bind="submit: sendCommentForm">
                    <div class="form-group">
                        <label for="comment_from">Email</label>
                        <input type="text" class="form-control" id="comment_from" name="form" data-bind="textInput: commentData.from">
                    </div>
                    <div class="form-group">
                        <label for="comment_text">Комментарий</label>
                        <textarea rows="5" class="form-control" id="comment_text" name="comment" data-bind="textInput: commentData.comment"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" id="submit_comment">
                    </div>
                </form>
            </div>
        </section>

        <div class="footer">
            <p class="footer-text">(c) BSUIR 2017</p>
        </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) if you need download libs from cloud please swap this rows-->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
    <script src="assets/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- if you need download libs from cloud please swap this rows-->
    <!--<script src="https://ajax.aspnetcdn.com/ajax/knockout/knockout-3.4.0.js"></script> -->
    <script src="assets/js/knockout-3.4.0.js"></script>

    <script src="assets/js/functional.js"></script>
  </body>
</html>