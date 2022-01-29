package techproed.test.dateprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.EmployeeDefaultPage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

/*/
The difference between try catch and throws in exception handling ?
If a method is re-usable (if you will call the method again) and we don't use try catch for exception handle
We will have to handle the exception whenever we call the method.
But if we used try catch and then whenever we call the method it will not throw an exception.
 */

public class Day16_DataProvider2 {
    @DataProvider(name = "employeeInfo")
    public Object [][] getData() {
        Object[][] employeeCredentials = {
                {"gino.wintheiser", "%B6B*q1!TH"},
                {"dallas.batz", "dOWjuXz8*es6"},
                {"leonel.skiles", "x3uvY0f8hw1T"}
        };
        return employeeCredentials;
    }



    LoginPage loginPage;
    EmployeeDefaultPage employeeDefaultPage;
    @Test
    public void logIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage=new LoginPage();
        employeeDefaultPage=new EmployeeDefaultPage();
        ReusableMethods.waitFor(1);
        loginPage.loginDropDown.click();
        ReusableMethods.waitFor(1);;
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropDown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
//            System.out.println("Sign out link is not exist");
        }
        loginPage.signInButton.click();
//        loginPage.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
//        loginPage.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
//        loginPage.loginButton.click();
    }

    @Test(dataProvider ="employeeInfo")
    public void setEmployeeDefaultPage (String username, String password) throws InterruptedException {
        logIn();
        loginPage.userName.sendKeys(username);
        loginPage.passWord.sendKeys(password);
        loginPage.loginButton.click();
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
