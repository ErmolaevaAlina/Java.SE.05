import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {



        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Livon\\Desktop\\HW5\\se05task2\\resources\\config.properties");
            Properties property = new Properties();
            property.load(fileInputStream);

            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");
            String log = property.getProperty("log");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password
                    + ", LOG: " + log);

        } catch (IOException e) {
            System.err.println("Config file is not found!");
        }

    }

}
