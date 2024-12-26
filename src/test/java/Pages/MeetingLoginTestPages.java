package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;



public class MeetingLoginTestPages {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="registerButton")
    WebElement registerNameEle;

    @FindBy(how= How.ID,using = "name")
    WebElement userNameEle;

    @FindBy(how = How.ID,using = "topic")
    WebElement topicsButtonEle;

    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/div/div[2]/form/button")
    WebElement registerNowButtonEle;

    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/div/div[2]/form/p")
    WebElement errorMessageEle;

    public MeetingLoginTestPages(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterregister( ){
        registerNameEle.click();

    }
    public void enterregister(String name){
        userNameEle.sendKeys(name);

    }
    public void enterTopics(String topic){
        topicsButtonEle.sendKeys(topic);

    }
    public void enterregisterNow(){
        registerNowButtonEle.click();

    }
    public void MeetingTOApplication(String name,String topic){
        registerNameEle.click();
        userNameEle.sendKeys(name);
        topicsButtonEle.sendKeys(topic);
        registerNowButtonEle.click();

    }
    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/p")));
        return errorMessageEle.getText();



    }





}
