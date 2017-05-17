package com.fortegroup.utill;

/**
 *Constants for our project please add constants to this class
 */
public final class Constant {

    private  Constant() {
    }

    /**
     * This constant represent path to folder with resumes
     */
    public static final String pathToFolder = "/assets/resumes/";
    public static final String pathToROOT = "/home/alex/tomcat8/apache-tomcat-8.5.14/webapps/ROOT";

    /**
     * This constant represent path to folder with reports
     */
    public static final String pathToReportsFolder = "/home/alex/Documents/reports/";

    /**
     * This constant represent authentication token name from header
     */
    public static final String tokenHeader = "authorization";

    /**
     * All constants in this block represent form fields Name for add resume form
     */
    public static final String nameParam = "userName";
    public static final String telephoneParam = "phoneNumber";
    public static final String emailParam = "email";
    public static final String vacancyParam = "vacancy";


    /**
     * This constant represent email from
     */

    public static final String FROM_EMAIL = "veronika.bigroi@mail.ru";

    /**
     * This constant is template for refusal message
     */
    public static final String REFUSAL_MESSAGE_TEMPLATE = "%s Вам отказано!";


    /**
     * This constant is template for Approving message
     */

    public static final String APPROVING_MESSAGE_TEMPLATE = "%s Вы приняты!";

    /**
     * Constant for add Expired time for vacancy
     */
    public static final Long EXPIRED_ADITATION = 2592000000l;

}
