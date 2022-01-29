package techproed.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;

public class Day13_FirstDriverClass {

    @Test
    public void firstDriverTest(){
//      driver =>>>>> Driver.getDriver()
//        Driver.getDriver().get("https://www.amazon.com");
//        Driver.getDriver().navigate().to("https://www.google.com");

//        We are using configuration file to get the urls
//        We do it because of reusability and making the code more dynamic
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("google_url"));

        System.out.println("Google Title : "+Driver.getDriver().getTitle());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}