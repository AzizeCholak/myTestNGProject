package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id ="account-menu")
    public WebElement loginDropDown;

    @FindBy(xpath = "(//*[.='Sign in'])[1]")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Sign out']")
    public WebElement signOut;

    public void loginApplication(String user, String pass){
        loginDropDown.click();
        signInButton.click();
        userName.sendKeys(user);
        passWord.sendKeys(pass);
        loginButton.click();


    }

}