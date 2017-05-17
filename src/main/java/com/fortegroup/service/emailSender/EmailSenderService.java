package com.fortegroup.service.emailSender;

/**
 * Created by alex on 5/3/17.
 */
public interface EmailSenderService {

    boolean sendApprovingEmails(Long...personsId);

    boolean sendRefusalEmails(Long...personsId);
}
