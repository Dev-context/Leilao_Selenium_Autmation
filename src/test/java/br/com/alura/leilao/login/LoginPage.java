package br.com.alura.leilao.login;

import br.com.alura.leilao.BasePage;
import br.com.alura.leilao.auction.AuctionsListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        this.driver.get(URL_LOGIN);
    }


    public void fillformLogin(String user, String password) {
        this.driver.findElement(By.xpath("//a[text()='Entrar']")).click();
        this.driver.findElement(By.name("username")).sendKeys(user);
        this.driver.findElement(By.name("password")).sendKeys(password);

    }


    public AuctionsListPage clickLogin() {
        this.driver.findElement(By.className("btn")).click();
        return new AuctionsListPage(this.driver);
    }

    public boolean IsLoginPage() {
        return this.driver.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getUserNameLogged() {
        try {
            return this.driver.findElement(By.className("font-italic")).getText();
        } catch (NoSuchElementException error) {
            return null;
        }

    }

    public boolean getPageText(String text) {
        return this.driver.getPageSource().contains(text);
    }
}
