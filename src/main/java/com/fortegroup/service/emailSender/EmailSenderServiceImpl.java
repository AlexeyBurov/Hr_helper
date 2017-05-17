package com.fortegroup.service.emailSender;

import com.fortegroup.model.peoples.Person;
import com.fortegroup.service.person.PersonService;
import com.fortegroup.utill.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alex on 5/3/17.
 */
public class EmailSenderServiceImpl implements EmailSenderService{
    private final Logger logger = LoggerFactory.getLogger(EmailSenderServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PersonService personService;

    @Override
    @Transactional
    public boolean sendApprovingEmails(Long...personsId) {
        try {
            for (Long id : personsId) {
                sendEmail(id,true);
            }
        }catch (MailException e){
            logger.error("Mails not sends",e);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean sendRefusalEmails(Long...personsId) {
        try {
            for (Long id : personsId) {
                sendEmail(id,false);
            }
        }catch (MailException e){
            logger.error("Mails not sends",e);
        }
        return true;
    }

    private void sendEmail(Long id,boolean flag) throws MailException {
        Person person = personService.getPersonById(id);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Constant.FROM_EMAIL);
        message.setTo(person.getEmail());
        if(flag) {
            message.setText(String.format(Constant.APPROVING_MESSAGE_TEMPLATE,person.getName()));
        }else {
            message.setText(String.format(Constant.REFUSAL_MESSAGE_TEMPLATE,person.getName()));
        }
        javaMailSender.send(message);
        logger.info(String.format("Message to are sending",person.getEmail()));
    }
}
