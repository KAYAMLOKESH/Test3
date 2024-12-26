import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenuimExample {


    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\K Lokesh\\Downloads\\chromedriver-win32(1)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://rahulnxttrendz.ccbp.tech");
        WebElement usernameEl= driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");

        WebElement passwordEl= driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2021");

        WebElement loginButtonEl= driver.findElement(By.className("login-button"));
        loginButtonEl.click();

        Dimension elementSize=usernameEl.getSize();

        int Width=elementSize.getWidth();
        int height=elementSize.getHeight();

        System.out.println("Element Width and Height:"+ elementSize);

        System.out.println("Element Width:"+ Width);
        System.out.println("Element Height:" + height);


       // Dimension newDimension=new Dimension(1024,764);
       // driver.manage().window().setSize(newDimension);




       // driver.quit();





    }
}
