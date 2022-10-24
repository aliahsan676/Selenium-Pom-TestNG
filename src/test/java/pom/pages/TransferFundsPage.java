package pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.BaseTest;
import pom.util.GeneralUtil;

import java.util.List;

public class TransferFundsPage extends BaseTest {
    @FindBy(id = "amount")
    WebElement amountEl;

    @FindBy(css = "input.button")
    WebElement transferBtn;

    @FindBy(css = "span#amount")
    List<WebElement> transferAmount;

    @FindBy(id = "fromAccountId")
    WebElement fromAccountId;

    public TransferFundsPage(){
        PageFactory.initElements(driver, this);
    }

    public TransferFundsPage fillAmount(int amount){
        amountEl.isDisplayed();
        fromAccountId.isDisplayed();
        amountEl.sendKeys(String.valueOf(amount));
        GeneralUtil.domStable();
        return this;
    }

    public TransferFundsPage clickTransferBtn(){
        GeneralUtil.domStable();
        transferBtn.isDisplayed();
        transferBtn.click();
        return this;
    }

    public boolean hasTransferAmount(){
        return transferAmount.size() > 0;
    }

}
