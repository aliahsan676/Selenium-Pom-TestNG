package pom.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pages.CustomerLoginPage;
import pom.pages.HomePage;

public class CustomerLoginTest extends BaseTest {

    HomePage homePage;
    CustomerLoginPage loginPage;
    public CustomerLoginTest(){
        super();
    }


    @BeforeMethod
    public void setup(){
        browserSetup();
        loginPage = new CustomerLoginPage();
    }

    @Test
    public void loginShouldSucceed(){
        homePage = loginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();

        Assert.assertTrue(homePage.isLogoutLink());

    }

    @AfterMethod
    public void tearDown(){

    }

}
