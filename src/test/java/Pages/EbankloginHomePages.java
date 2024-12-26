package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EbankloginHomePages {

    WebDriver driver;
    WebDriverWait Wait;

    By usernameLocator=By.id("userIdInput");
    By passwordLocator=By.id("pinInput");
    By loginButtonLocator=By.className("login-button");
    By errorMessageLocator=By.className("error-message-text");

    public EbankloginHomePages (WebDriver driver){
        this.driver=driver;
        this.Wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);

    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);

    }
    public void enterClickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();

    }

    public void loginToApplication(String username,String password){
        enterUsername(username);
        enterPassword(password);
        enterClickOnLoginButton();

    }

    public String getErrorMessage(){
        Wait.until(ExpectedConditions.visibilityOfElementLocated( errorMessageLocator));
        WebElement errorMessageEl=driver.findElement( errorMessageLocator);
        return errorMessageEl.getText();
    }

}







