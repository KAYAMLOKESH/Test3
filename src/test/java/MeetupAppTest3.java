import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import Pages.MeetingLoginTestPages;


public class MeetupAppTest3 {
    public WebDriver driver;
    MeetingLoginTestPages meetingLoginTestPages;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\K Lokesh\\Downloads\\chromedriver-win32(1)\\chromedriver-win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qameetup.ccbp.tech/");
        meetingLoginTestPages=new MeetingLoginTestPages(driver);

    }

    @DataProvider
    public Object[][] loginData(){
        return new Object[][]{
                {"lokesh","ARTS_AND_CULTURE"},
                {"karthik","EDUCATION_AND_LEARNING"}

        };
    }

    @Test(priority = 1,dataProvider = "loginData")
    public void loginWithValidCredentials(String name,String topic){
        meetingLoginTestPages.MeetingTOApplication(name,topic);
        String expectedUrl="https://qameetup.ccbp.tech/";

        WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String CurrentUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,CurrentUrl,"URLs to be matchs");

    }

    @Test(priority = 2)
    public void loginWithInValidCredentials(){
        meetingLoginTestPages.MeetingTOApplication("name","topic");
        String errorMessage=meetingLoginTestPages.getErrorMessage();
        Assert.assertEquals(errorMessage,"Please enter your name");
    }

    @AfterMethod
    public void tearDown(){

        //driver.quit();
    }




}
