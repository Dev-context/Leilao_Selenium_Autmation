package br.com.alura.leilao.IncludeAuction;

import JavaUtil.SeleniumJavautil;
import br.com.alura.leilao.auction.AuctionsListPage;
import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IncludeNewAuctionTest {

    private IncludeNewAuctionPage includeNewAuctionPage;
    private LoginPage loginPage;
    private AuctionsListPage auctionsListPage;
    private SeleniumJavautil SeleniumJavautil =new SeleniumJavautil();


    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
        this.loginPage.fillformLogin("fulano", "pass");
        this.auctionsListPage = this.loginPage.clickLogin();
        this.includeNewAuctionPage = this.auctionsListPage.EnterWithNewAuction();


    }

    @AfterEach
    public void afterEach() {
        this.includeNewAuctionPage.TearDown();
    }


   @Test
   public void IncludeNewAuctionWithSucess(){
       String initialValue = "500.00";
       String openedAuctionDate = SeleniumJavautil.getDateNowFormat();
       String name = "TEST" + openedAuctionDate+ " - "+ SeleniumJavautil.getTimeNowFormat();
       this.includeNewAuctionPage.fillAndSubmitAuctionForm(name, initialValue, openedAuctionDate);
   }
    @Test
    public void DontAllowToFillEmptyFields() {
        this.includeNewAuctionPage.fillAndSubmitAuctionForm("", "", "");
        Assert.assertTrue(this.includeNewAuctionPage.ContainsMessages());
    }


}
