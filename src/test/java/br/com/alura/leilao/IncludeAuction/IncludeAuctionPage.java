package br.com.alura.leilao.IncludeAuction;

import br.com.alura.leilao.auction.AuctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncludeAuctionPage {

    private WebDriver driver;

    public IncludeAuctionPage(WebDriver browser) {
        this.driver = browser;
    }


    public void OpenUrl(String url) {
        this.driver.get(url);
    }

    public void TearDown() {
        this.driver.quit();
    }

    public AuctionsPage fillAndSubmitAuctionForm(String AuctionName, String InitialValue, String OpenedAuctionDate) {
        this.driver.findElement(By.id("nome")).sendKeys(AuctionName);
        this.driver.findElement(By.id("valorInicial")).sendKeys(InitialValue);
        this.driver.findElement(By.id("dataAbertura")).sendKeys(OpenedAuctionDate);
        this.driver.findElement(By.id("button-submit")).click();
        return new AuctionsPage(driver);

    }


    public boolean isIncluded(String name, String initialValue, String openedAuctionDate) {
        WebElement rowList = this.driver.findElement(By.cssSelector(".table tbody tr:last-child"));
        WebElement columnname = rowList.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement columOpenedAuctionDate = rowList.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement columnValorinitialValue = rowList.findElement(By.cssSelector("td:nth-child(3)"));
        return columnname.getText().equals(name) && columOpenedAuctionDate.getText().equals(openedAuctionDate) && columnValorinitialValue.getText().equals(initialValue);


    }
}
