package br.com.alura.leilao.auction;

import br.com.alura.leilao.IncludeAuction.IncludeAuctionPage;
import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuctionTest {
    private AuctionsPage leiloesPage;
    private LoginPage loginPage;
    private IncludeAuctionPage includeAuctionPage;


    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
        this.loginPage.fillformLogin("fulano", "pass");
        this.leiloesPage = this.loginPage.clickLogin();

    }

    @AfterEach
    public void afterEach() {
        this.leiloesPage.TearDown();
    }

    @Test
    public void mostIncludeAuctionsInList() {
        this.includeAuctionPage = this.leiloesPage.LoadForm();
        String initialValue = "500.00";
        String openedAuctionDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String name = "TEST" + openedAuctionDate;
        this.includeAuctionPage.fillAndSubmitAuctionForm(name, initialValue, openedAuctionDate);
        Assert.assertTrue(this.includeAuctionPage.isIncluded(name, initialValue, openedAuctionDate));


    }
}
