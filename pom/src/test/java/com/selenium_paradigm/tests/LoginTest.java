package com.selenium_paradigm.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.selenium_paradigm.pages.LoginPage;
import com.selenium_paradigm.pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void successfulLoginLandsOnProductsPage(){  
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        ProductsPage productsPage = new ProductsPage(getDriver());
        assertThat(productsPage.isLoaded()).isTrue();
    }

    @Test(groups = {"regression"})
    public void unsuccessfulLoginRaisesErrorMessage(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "wrong_password");
        assertThat(loginPage.getErrorMessage()).contains("Epic sadface");
    }
}
