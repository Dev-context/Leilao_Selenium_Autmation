package br.com.alura.leilao.bid;

import JavaUtil.SeleniumJavautil;
import br.com.alura.leilao.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class Bidpage extends BasePage {
    private SeleniumJavautil seleniumJavautil = new SeleniumJavautil();

    public Bidpage(WebDriver driver) {
        super(driver);
    }


    public void GiveBid() {

    }

    public boolean IncludeANewBidMoreThanPresentValue(String value) {
        this.driver.findElement(By.id("valor")).sendKeys(value);
        this.driver.findElement(By.id("btnDarLance")).click();
        return false;
    }

    public boolean CurrentValueIsMorethanNewBidValue(String value) {
        WebElement presentValue = this.driver.findElement(By.cssSelector(".card-subtitle span"));
        if (seleniumJavautil.convertStrigToDouble(value)
                > seleniumJavautil.convertStrigToDouble(presentValue.getText())) {
            this.driver.getPageSource().contains("Lance invalido!");
            return true;
        }
        return false;
    }

}
