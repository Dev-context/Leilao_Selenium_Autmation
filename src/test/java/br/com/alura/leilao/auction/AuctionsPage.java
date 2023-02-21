package br.com.alura.leilao.auction;

import br.com.alura.leilao.IncludeAuction.IncludeAuctionPage;
import org.openqa.selenium.WebDriver;

public class AuctionsPage {

    private static final String URL_INCLUDE_NEW_AUCTION = "http://localhost:8080/leiloes/new";
    private WebDriver browser;

    public AuctionsPage(WebDriver driver) {
        this.browser = driver;

    }

    public void OpenUrl(String url) {
        this.browser.get(url);
    }

    public void TearDown() {
        this.browser.quit();
    }

    public IncludeAuctionPage LoadForm(){
        this.browser.get(URL_INCLUDE_NEW_AUCTION);
        return new IncludeAuctionPage(browser);

    }





}
