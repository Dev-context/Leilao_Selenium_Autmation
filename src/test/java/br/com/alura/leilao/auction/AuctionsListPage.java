package br.com.alura.leilao.auction;

import br.com.alura.leilao.BasePage;
import br.com.alura.leilao.IncludeAuction.IncludeNewAuctionPage;
import br.com.alura.leilao.bid.Bidpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AuctionsListPage extends BasePage {
    private static final String URL_INCLUDE_NEW_AUCTION = "http://localhost:8080/leiloes/new";
    private List<WebElement> rowList;

    public AuctionsListPage(WebDriver driver) {
        super(driver);

    }


    public IncludeNewAuctionPage EnterWithNewAuction() {
        this.driver.findElement(By.id("novo_leilao_link")).click();
        return new IncludeNewAuctionPage(this.driver);
    }

    public boolean isIncluded(String name, String initialValue, String openedAuctionDate) {
        WebElement rowList = this.driver.findElement(By.cssSelector(".table tbody tr:last-child"));
        WebElement columnname = rowList.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement columOpenedAuctionDate = rowList.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement columnValorinitialValue = rowList.findElement(By.cssSelector("td:nth-child(3)"));
        return columnname.getText().equals(name) && columOpenedAuctionDate.getText().equals(openedAuctionDate) && columnValorinitialValue.getText().equals(initialValue);
    }


    public Bidpage loadTable() {
        rowList = this.driver.findElements(By.cssSelector(".table tbody tr"));
        return new Bidpage(this.driver);
    }

    public void SearchAuctionBidItemNameAndClick(String Itemname) {
        rowList.stream().filter(webElement -> webElement.getText().contains(Itemname)
                        && webElement.getText().contains("dar lance")).
                forEach(e -> {
                    e.findElement(By.cssSelector("td a")).click();
                });

    }






}
