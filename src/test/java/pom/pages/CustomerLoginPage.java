package pom.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.BaseTest;

import java.util.List;

public class CustomerLoginPage extends BaseTest {

    @FindBy(name = "username")
    WebElement usernameEl;

    @FindBy(name = "password")
    WebElement passwordEl;

    @FindBy(css = "[type='submit']")
    WebElement loginBtn;

    @FindBy(css = ".error")
    List<WebElement> error;

    public CustomerLoginPage(){
        PageFactory.initElements(driver, this);
    }

    public CustomerLoginPage fillUsername(String username){
        usernameEl.isDisplayed();
        usernameEl.sendKeys(username);
        return this;
    }

    public CustomerLoginPage fillPassword(String password){
        passwordEl.isDisplayed();
        passwordEl.sendKeys(password);
        return this;


    }

    public HomePage clickLoginBtn(){
        loginBtn.isDisplayed();
        loginBtn.click();
        return new HomePage();

    }

    public CustomerLoginPage clickLogin(){
        loginBtn.isDisplayed();
        loginBtn.click();
        return this;

    }


    public boolean hasErrorMessage(){
        return error.size() > 0;
    }


}
