package br.com.alura.leilao;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        if (driver != null) {
            this.driver = driver;
        } else {
            ChromeOptions chomeOptions = new ChromeOptions();
            chomeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            this.driver = new ChromeDriver();
        }

    }


    public void TearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
