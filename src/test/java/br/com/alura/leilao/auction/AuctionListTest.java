package br.com.alura.leilao.auction;

import JavaUtil.SeleniumJavautil;
import br.com.alura.leilao.IncludeAuction.IncludeNewAuctionPage;
import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuctionListTest {
    private AuctionsListPage auctionsListPage;
    private LoginPage loginPage;
    private IncludeNewAuctionPage includeNewAuctionPage;
    private SeleniumJavautil SeleniumJavautil =new SeleniumJavautil();


    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
        this.loginPage.fillformLogin("fulano", "pass");
        this.auctionsListPage = this.loginPage.clickLogin();


    }

    @AfterEach
    public void afterEach() {
        this.auctionsListPage.TearDown();

    }

    @Test
    public void mostIncludeAuctionsInList() {
        this.includeNewAuctionPage = this.auctionsListPage.EnterWithNewAuction();
        String initialValue = "500.00";
        String openedAuctionDate = SeleniumJavautil.getDateNowFormat();
        String name = "TEST" + openedAuctionDate+ " - "+ SeleniumJavautil.getTimeNowFormat();
        this.includeNewAuctionPage.fillAndSubmitAuctionForm(name, initialValue, openedAuctionDate);
        Assert.assertTrue(this.auctionsListPage.isIncluded(name, initialValue, openedAuctionDate));


    }
}
