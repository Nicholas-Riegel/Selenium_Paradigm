package com.selenium_paradigm.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.selenium_paradigm.pages.LoginPage;
import com.selenium_paradigm.pages.ProductsPage;

public class LoginPageTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void successfulLoginLandsOnProductsPage(){
        
        LoginPage loginPage = new LoginPage(getDriver());
        
        ProductsPage productsPage = loginPage.loginAs("standard_user", "secret_sauce");
        
        assertThat(productsPage.isLoaded()).isTrue();

    }

    @Test(groups = {"regression"})
    public void unsuccessfulLoginRaisesErrorMessage(){
        
        LoginPage loginPage = new LoginPage(getDriver());
        
        loginPage.loginAs("standard_user", "wrong_password");
        
        assertThat(loginPage.getErrorMessage()).contains("Epic sadface");

    }

}
