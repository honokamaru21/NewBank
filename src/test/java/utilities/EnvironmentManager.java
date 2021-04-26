package utilities;

public class EnvironmentManager {

    public static String baseUrl;
    public static String username;
    public static String password;

    public static void setUpEnvironment() throws Exception {
        switch (ConfigReader.getProperty ("environment").toLowerCase ()) {
            case "dev":
                DEV ();
                break;
            case "qa":
                QA ();
                break;
            case "prod":
                PROD ();
                break;
            default:
                throw new Exception ("Invalid environment in configuration.properties.\nPlease select from: Dev, Qa, Prod");
        }
    }

    private static void DEV() {
        //to set up dev variables
        baseUrl = "https://www.dev-meetup.com/";
        username = "TestUserDev";
        password = "test123";
    }

    private static void QA() {
        //to set up qa vars
        baseUrl = "http://3.131.35.165:8080/bank/login";
        username = "frodo@shire.com";
        password = "Frodo01@";
        //username = "bilbo@shire.com";
        //password = "Bilbo01@";
    }

    private static void PROD() {
        //set prod vars
        baseUrl = "https://www.meetup.com/";
        username = "ProdUser";
        password = "test123";
    }
}
