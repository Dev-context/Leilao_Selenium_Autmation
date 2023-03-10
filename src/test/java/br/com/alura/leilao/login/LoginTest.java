package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.net.URL;

public class LoginTest {
    private  LoginPage loginPage;



    @BeforeEach
    public void beforeEach() {
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
//      this.loginPage.TearDown();
    }


    @Test
    public void ShouldBeLogin() {
        this.loginPage.fillformLogin("fulano","pass");
        this.loginPage.clickLogin();
        Assert.assertFalse(this.loginPage.IsLoginPage());
        Assert.assertEquals("fulano", this.loginPage.getUserNameLogged());
    }


    @Test
    public void ShouldntBeLogin() {
        this.loginPage.fillformLogin("Invalido","123123");
        this.loginPage.clickLogin();
        Assert.assertTrue(this.loginPage.getPageText("Usuário e senha inválidos."));
        Assert.assertNull(this.loginPage.getUserNameLogged());
    }

    @Test
    public void ShouldntAcessRetrictURL() {
//        this.loginPage.openUrl("http://localhost:8080/leiloes/2");
        Assert.assertTrue(this.loginPage.IsLoginPage());
        Assert.assertFalse(this.loginPage.getPageText("Dados do Leilão"));
    }
}
