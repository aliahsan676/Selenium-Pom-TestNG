package pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pom.base.BaseTest;
import pom.util.GeneralUtil;

import java.util.List;

public class OpenAccountPage extends BaseTest {
    @FindBy(id = "type")
    WebElement accountType;

    @FindBy(id = "fromAccountId")
    WebElement fromAccountId;

    @FindBy(css = "input.button")
    WebElement openAccountBtn;

    @FindBy(id = "newAccountId")
    List<WebElement> newAccountId;

    public OpenAccountPage(){
        PageFactory.initElements(driver, this);
    }

    public OpenAccountPage selectAccountType(int index){
        new Select(accountType).selectByIndex(index);
        return this;
    }

    public OpenAccountPage selectAccountType(String value){
        new Select(accountType).selectByValue(value);
        return this;
    }

    public OpenAccountPage selectFromAccount(int index){
        GeneralUtil.domStable();
        Select select = new Select(fromAccountId);
        select.selectByIndex(index);
        return this;
    }

    public OpenAccountPage selectFromAccount(String txt){
        new Select(fromAccountId).selectByVisibleText(txt);
        return this;
    }

    public OpenAccountPage clickOpenAccountBtn(){
        openAccountBtn.isDisplayed();
        openAccountBtn.click();
        return this;
    }

    public boolean hasNewAccountId(){
        return newAccountId.size() > 0;
    }



}
