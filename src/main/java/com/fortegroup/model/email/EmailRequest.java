package com.fortegroup.model.email;

/**
 * Created by alex on 5/3/17.
 */
public class EmailRequest {
    private Long[] personsId;
    private boolean flag;


    public EmailRequest() {
    }

    public EmailRequest(Long[] personsId, boolean flag) {
        this.personsId = personsId;
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Long[] getPersonsId() {
        return personsId;
    }

    public void setPersonsId(Long[] personsId) {
        this.personsId = personsId;
    }
}
