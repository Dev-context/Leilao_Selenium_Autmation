package br.com.alura.leilao.IncludeAuction;

import br.com.alura.leilao.BasePage;
import br.com.alura.leilao.auction.AuctionsListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncludeNewAuctionPage extends BasePage {
    private static final String URL_INCLUDE_NEW_AUCTION = "http://localhost:8080/leiloes/new";

    public IncludeNewAuctionPage(WebDriver driver) {
        super(driver);
    }


    public IncludeNewAuctionPage LoadAuctionForm() {
        this.driver.get(URL_INCLUDE_NEW_AUCTION);
        return new IncludeNewAuctionPage(driver);

    }


    public AuctionsListPage fillAndSubmitAuctionForm(String AuctionName, String InitialValue, String OpenedAuctionDate) {
        this.driver.findElement(By.id("nome")).sendKeys(AuctionName);
        this.driver.findElement(By.id("valorInicial")).sendKeys(InitialValue);
        this.driver.findElement(By.id("dataAbertura")).sendKeys(OpenedAuctionDate);
        this.driver.findElement(By.id("button-submit")).click();
        return new AuctionsListPage(driver);


    }



    public boolean ContainsMessages() {
        return
                this.driver.getPageSource().contains("não deve estar em branco") &&
                        this.driver.getPageSource().contains("minimo 3 caracteres") &&
                        this.driver.getPageSource().contains("deve ser um valor maior de 0.1") &&
                        this.driver.getPageSource().contains("deve ser uma data no formato dd/MM/yyyy");

    }
}
