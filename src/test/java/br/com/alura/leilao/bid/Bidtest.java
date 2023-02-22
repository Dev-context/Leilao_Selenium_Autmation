package br.com.alura.leilao.bid;

import br.com.alura.leilao.auction.AuctionsListPage;
import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Bidtest {
    private LoginPage loginPage;
    private AuctionsListPage auctionsListPage;
    private Bidpage bidpage;

    @BeforeEach
    public void beforeEach() {
        this.loginPage = new LoginPage();
        this.loginPage.fillformLogin("fulano", "pass");
        this.auctionsListPage = this.loginPage.clickLogin();
        this.bidpage = this.auctionsListPage.loadTable();
    }

    @AfterEach
    public void afterEach() {
//        this.bidpage.TearDown();
    }

    @Test
    public void IncludeNewBid() {
        this.auctionsListPage.SearchAuctionBidItemNameAndClick("Computador Z3");
        this.bidpage.IncludeANewBidMoreThanPresentValue("500.00");
        Assert.assertFalse(this.bidpage.CurrentValueIsMorethanNewBidValue("500.00"));
    }
    @Test
    public void DoNotIncludeNewBidLessThanCurrentValue() {
        this.auctionsListPage.SearchAuctionBidItemNameAndClick("Computador Z3");
        this.bidpage.IncludeANewBidMoreThanPresentValue("100");
        Assert.assertFalse(this.bidpage.CurrentValueIsMorethanNewBidValue("100.00"));
    }

}
