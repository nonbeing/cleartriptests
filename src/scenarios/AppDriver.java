package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppDriver {

    WebDriver driver;

    public AppDriver(){
        driver = new FirefoxDriver();
    }


    public WebDriver getDriver(){
        return driver;
    }

}
