package serenity.bdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class EnvironmentPropertyLoader {
    private static EnvironmentPropertyLoader ourInstance = new EnvironmentPropertyLoader();

    //Logger connection
    private static Logger log = LoggerFactory.getLogger(EnvironmentPropertyLoader.class);
    Properties prop = new Properties();

    public static EnvironmentPropertyLoader getInstance() {
        return ourInstance;
    }


    private EnvironmentPropertyLoader() {


        try {
            InputStream input = new FileInputStream("src/test/resources/envConfig/" + System.getProperty("environment.config"));

            prop.load(input);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(final String propertyName) {

        return ourInstance.prop.getProperty(propertyName);
    }
}




