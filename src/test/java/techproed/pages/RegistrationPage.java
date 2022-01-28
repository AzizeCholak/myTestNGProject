package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class RegistrationPage {
    public RegistrationPage(){
        // to instantiate the page objects
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //WebElement ssn = findElement(By.id("ssn"));
    // we use this instead ===== > @FindBy(id = "ssn")
    //public WebElement ssn;
    @FindBy(id = "ssn")
    public WebElement ssn;



}
