package manager;

public class DriverManagerFactory {

    public static DriverManager  getManager(String type){

    DriverManager driverManager=null;

    switch (type){
        case "chrome":
            driverManager = new ChromeDriverManager();
            break;
        case "firefox":
            driverManager = new FirefoxDriverManager();
            break;
            default:
            System.out.println("Navegador incorrecto");
            break;
    }
    return driverManager;

    }
}
