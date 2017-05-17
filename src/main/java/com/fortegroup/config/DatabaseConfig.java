package com.fortegroup.config;

import com.fortegroup.dao.accounts.UserDao;
import com.fortegroup.dao.accounts.UserDaoImpl;

import com.fortegroup.dao.comments.CommentsDao;
import com.fortegroup.dao.comments.CommentsDaoImpl;
import com.fortegroup.dao.complaints.ComplaintDAO;
import com.fortegroup.dao.complaints.ComplaintDAOImpl;
import com.fortegroup.dao.people.PersonDAO;
import com.fortegroup.dao.people.PersonDAOImpl;
import com.fortegroup.dao.people.VacancyDAO;
import com.fortegroup.dao.people.VacancyDaoImpl;
import com.fortegroup.service.accounts.UserService;
import com.fortegroup.service.accounts.UserServiceImpl;

import com.fortegroup.service.comments.CommentsService;
import com.fortegroup.service.comments.CommentsServiceImpl;
import com.fortegroup.service.complaints.ComplaintService;
import com.fortegroup.service.complaints.ComplaintServiceImpl;
import com.fortegroup.service.emailSender.EmailSenderService;
import com.fortegroup.service.emailSender.EmailSenderServiceImpl;
import com.fortegroup.service.person.PersonService;
import com.fortegroup.service.person.PersonServiceImpl;
import com.fortegroup.service.person.VacancyService;
import com.fortegroup.service.person.VacancyServiceImpl;
import com.fortegroup.service.reports.ReportService;
import com.fortegroup.service.reports.ReportServiceImpl;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * DB config for this project
 * @author Alexey Burov
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private ApplicationContext appContext;



    @Bean
    public HikariDataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("databaseName", "hr_helper");
        dataSource.addDataSourceProperty("useUnicode","yes");
        dataSource.addDataSourceProperty("characterEncoding","UTF-8");
        dataSource.addDataSourceProperty("portNumber", "3306");
        dataSource.addDataSourceProperty("serverName", "localhost");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "root");
        return dataSource;
    }


    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("dataSource"));
        localSessionFactoryBean.setPackagesToScan("com.fortegroup.model");
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.current_session_context_class","thread");
//        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    @Bean
    public PersonDAO personDAO(){
        return new PersonDAOImpl();
    }

    @Bean
    public PersonService personService(){
        return new PersonServiceImpl();
    }

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.put("mail.smtps.auth",true);
        sender.setJavaMailProperties(properties);
        sender.setHost("smtp.mail.ru");
        sender.setPort(465);
        sender.setUsername("veronika.bigroi@mail.ru");
        sender.setPassword("kzkzrf23");
        sender.setProtocol("smtps");
        return sender;
    }

    @Bean
    public EmailSenderService emailSenderService(){
        return new EmailSenderServiceImpl();
    }

    @Bean
    public ReportService reportService(){
        return  new ReportServiceImpl();
    }

    @Bean
    public CommentsService commentsService(){
        return new CommentsServiceImpl();
    }

    @Bean
    public CommentsDao commentsDao(){
        return new CommentsDaoImpl();
    }

    @Bean
    public VacancyDAO vacancyDAO(){
        return new VacancyDaoImpl();
    }

    @Bean
    public VacancyService vacancyService(){
        return new VacancyServiceImpl();
    }

    @Bean
    public ComplaintDAO complaintDAO(){
        return new ComplaintDAOImpl();
    }

    @Bean
    public ComplaintService complaintService(){
        return new ComplaintServiceImpl();
    }

}
