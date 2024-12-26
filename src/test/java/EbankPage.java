import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pages.EbankloginHomePages;

import java.time.Duration;

public class EbankPage{
    public WebDriver driver;
    EbankloginHomePages ebankloginHomePages;

    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\K Lokesh\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/");
        ebankloginHomePages=new EbankloginHomePages(driver);

    }


    @DataProvider
    Object[][]loginData(){
        return new Object[][]{
                {"142421","231224"} ,
                {"142422","232225"}
        };

    }


    @Test(priority = 1)
    public void loginWithValidCredentials() {
        ebankloginHomePages.loginToApplication("142420","231225");

        String expectedUrl="https://qaebank.ccbp.tech/";

        WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"URLs to be matches");


    }
    @Test(priority = 2,dataProvider = "loginData")
    public void loginWithInValidCredentials(String username,String password){
        ebankloginHomePages.loginToApplication(username,password);

        String errorMessage=ebankloginHomePages.getErrorMessage();

        Assert.assertEquals(errorMessage,"Invalid user ID");

    }

    @AfterMethod
    void tearDown(){

        driver.quit();
    }


}


