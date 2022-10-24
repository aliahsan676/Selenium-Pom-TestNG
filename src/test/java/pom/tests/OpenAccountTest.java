package pom.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pages.CustomerLoginPage;
import pom.pages.HomePage;
import pom.pages.OpenAccountPage;

public class OpenAccountTest extends BaseTest {

    HomePage homePage;

    OpenAccountPage openAccountPage;

    public OpenAccountTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        browserSetup();
        homePage = new CustomerLoginPage()
                .login(getUsername(), getPassword());
    }

    @Test
    public void openAccountShouldSucceed(){
        openAccountPage = homePage
                .clickOpenAccountLink()
                .selectAccountType("0")
                .selectFromAccount(0)
                .clickOpenAccountBtn();
        Assert.assertTrue(openAccountPage.hasNewAccountId());
    }



    //For Taking ScreenShot of Test Cases
    @AfterMethod
    public void tearDown(ITestResult result){
        if (ITestResult.SUCCESS == result.getStatus()){
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();

    }





}
