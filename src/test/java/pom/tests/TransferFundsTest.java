package pom.tests;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pages.CustomerLoginPage;
import pom.pages.HomePage;
import pom.pages.OpenAccountPage;
import pom.pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {
    HomePage homePage;

    TransferFundsPage transferFundsPage;

    public TransferFundsTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        browserSetup();
        homePage = new CustomerLoginPage()
                .login(getUsername(), getPassword());
    }

    @Test
    public void transferFundShouldSucceed(){
        transferFundsPage = homePage
                .clickTransferLink()
                .fillAmount(500)
                .clickTransferBtn();
        Assert.assertTrue(transferFundsPage.hasTransferAmount());
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
