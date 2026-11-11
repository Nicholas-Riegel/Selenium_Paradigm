package com.selenium_paradigm.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.assertj.core.api.SoftAssertions;

import com.selenium_paradigm.pages.ProductsPage;
import com.selenium_paradigm.pages.CartPage;

public class CartTest extends BaseTest {
    
    @DataProvider(name = "itemsToCart", parallel = true)
    public Object[][] itemsToCart() {
        return new Object[][] {
            {"Sauce Labs Backpack"},
            {"Sauce Labs Bike Light"},
            {"Sauce Labs Bolt T-Shirt"}
        };
    }
    
    @Test(dataProvider = "itemsToCart", groups = {"cart"})
    public void itemIsAddedToCart(String itemForCart){
        SoftAssertions soft = new SoftAssertions();
        loginViaCookie("standard_user");
        getDriver().get("https://www.saucedemo.com/inventory.html");
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.addItemToCart(itemForCart);
        soft.assertThat(productsPage.getCartBadgeCount()).isEqualTo(1);
        productsPage.goToCart();
        CartPage cartPage = new CartPage(getDriver());
        soft.assertThat(cartPage.itemIsInCart(itemForCart)).isTrue();
        soft.assertAll();
    }
}
