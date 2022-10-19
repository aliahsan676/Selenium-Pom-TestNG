package pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.BaseTest;

import javax.swing.text.html.CSS;
import java.util.List;

public class HomePage extends BaseTest {
    @FindBy(css = "a[href$='logout.htm']")
    List<WebElement> logoutLink;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutLink(){
        return logoutLink.size() > 0;
    }

}
