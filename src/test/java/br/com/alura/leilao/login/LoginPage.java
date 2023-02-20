package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver browser;
    private final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.OpenUrl(URL_LOGIN);
    }

    public void OpenUrl(String url) {
        this.browser.get(url);
    }

    public void TearDown() {
        this.browser.quit();
    }

    public void fillformLogin(String user, String password) {
        browser.findElement(By.xpath("//a[text()='Entrar']")).click();
        browser.findElement(By.name("username")).sendKeys(user);
        browser.findElement(By.name("password")).sendKeys(password);

    }


    public void clickLogin() {
        browser.findElement(By.className("btn")).click();
    }

    public boolean IsLoginPage() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getUserNameLogged() {
        try {
            return browser.findElement(By.className("font-italic")).getText();
        } catch (NoSuchElementException error) {
            return null;
        }

    }


    public boolean getPageText(String text) {
        return browser.getPageSource().contains(text);
    }
}
