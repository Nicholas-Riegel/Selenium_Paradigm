package com.selenium_paradigm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class XpathTest extends BaseTest {
    

    // 1. Find the "Swag Labs" logo using an XPath that matches its visible text.
    // Assert that its text is "Swag Labs".
    @Test
    public void logoTest(){

        driver.get("https://www.saucedemo.com");

        WebElement logo = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
    
        assertThat(logo.getText()).isEqualTo("Swag Labs");
    }

    // 2. Find the Login button by starting from the password field and moving to a parent or sibling.
    // Assert that the element you found is displayed.
    // Hint: inspect the page in DevTools to see the structure around the password field.
    @Test
    public void passwordToLoginButtonTest(){

        driver.get("https://www.saucedemo.com");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='password']/../following-sibling::input"));
    
        assertThat(loginButton.getAttribute("value")).isEqualTo("Login");
    }

    // 3. Find the username field using an XPath that matches the id attribute.
    // Assert that it is displayed.
    @Test
    public void xpathUsernameTest(){

        driver.get("https://www.saucedemo.com");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='user-name']"));
    
        assertThat(loginButton.isDisplayed()).isTrue();
    }

    // 4. Find the password field using an XPath that matches the name attribute.
    // Assert that its type attribute is "password".
    @Test
    public void xpathPasswordTest(){

        driver.get("https://www.saucedemo.com");

        WebElement loginButton = driver.findElement(By.xpath("//input[@name='password']"));
    
        assertThat(loginButton.getAttribute("type")).isEqualTo("password");
    }

    // 5. Find the username field using an XPath with contains() on the id attribute.
    // Assert that it is displayed.
    @Test
    public void xpathUsernameContainsTest(){

        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.xpath("//input[contains(@id, 'user')]"));
    
        assertThat(username.isDisplayed()).isTrue();
    }

    // 6. Find the password field using an XPath with starts-with() on the id attribute.
    // Assert that it is displayed.
    @Test
    public void xpathStartsWithTest(){

        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.xpath("//input[starts-with(@id, 'pass')]"));
    
        assertThat(username.isDisplayed()).isTrue();
    }

    // 7. Find the username field using an XPath that combines two attributes with and.
    // Assert that it is displayed.
    @Test
    public void xpathTwoAttributesTest(){

        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name' and @type='text']"));
    
        assertThat(username.isDisplayed()).isTrue();
    }

    // 8. Find the "Swag Labs" logo using an XPath with contains() on its text.
    // Assert that its text is "Swag Labs".
    @Test
    public void xpathContainsTest(){

        driver.get("https://www.saucedemo.com");

        WebElement logo = driver.findElement(By.xpath("//div[contains(text(), 'Swag')]"));
    
        assertThat(logo.getText()).isEqualTo("Swag Labs");
    }

    // From #9 on, any test that names a page (/tables, /checkboxes, /dropdown, /login) or the home page uses https://the-internet.herokuapp.com.
    // Start those with driver.get(...). Tests that name no page (#18-#20, #24-#26) stay on saucedemo.

    // 9. Page /tables: find the first body row of "table1" using a positional index on a node set, e.g. (//xpath)[n].
    // Assert that its text contains "Smith".
    // Hint: the header row is also a tr. Check how many tr elements come before the first body row.
    // @Test
    @Test
    public void tablesTest(){

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.xpath("//table[@id='table1']/tbody/tr[1]")));
    
        assertThat(element.getText()).contains("Smith");
    }

    // 10. Page /tables: find the last body row of "table1" using last().
    // Assert that its text contains "Conway".
    @Test
    public void tablesLastTest(){

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.xpath("//table[@id='table1']/tbody/tr[last()]")));
    
        assertThat(element.getText()).contains("Conway");
    }

    // 11. Page /tables: in "table1" only, start at the cell with the text "jsmith@gmail.com" and use the preceding-sibling axis to reach the first name cell.
    // Assert that its text is "John".
    // Hint: the page has two tables with the same data, so an unscoped //td[...] matches 2 elements.
    @Test
    public void precedingSiblingTest(){

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.xpath("//table[@id='table1']//td[text()='jsmith@gmail.com']/preceding-sibling::td[1]")));
    
        assertThat(element.getText()).isEqualTo("John");
    }

    // 12. Page /tables: in "table1" only, start at the last name cell "Conway" and use following-sibling with a position number to reach the "Due" cell in the same row.
    // Assert that its text is "$50.00".
    // Hint: count the cells after the last name cell in DevTools.
    @Test
    public void followingSiblingTest(){

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.xpath("//table[@id='table1']//td[text()='Conway']/following-sibling::td[3]")));
    
        assertThat(element.getText()).isEqualTo("$50.00");
    }

    // 13. Page /tables: start at the cell with the text "Smith" in the SECOND table and use the ancestor axis to reach the table that contains it.
    // Assert that its id attribute is "table2".

    // 14. Page /tables: find the row that contains "Bach", then from that row element search for the links inside it with a relative path starting with .//
    // Assert that there are 2 links.
    // Hint: a path starting with // inside element.findElement searches the whole page again. Use .// to stay inside the row.

    // 15. Find the "Swag Labs" logo using an exact text() match, then again using normalize-space().
    // Assert that both XPaths find the same element.

    // 16. Find all inputs whose type is NOT "password" using not().
    // Assert that the count matches the number of such inputs you see in DevTools.

    // 17. Find the username field or the password field with a single XPath using or.
    // Assert that the XPath returns exactly 2 elements.

    // 18. Page /dropdown: find the option elements that are DIRECT children of the select using single-slash steps only (no //  after the select).
    // Assert that there are 3 of them.

    // 19. Page /checkboxes: find the checkbox that has the "checked" attribute using an attribute-existence test (no value compared).
    // Assert that it is selected.

    // 20. Home page: find the link whose text is "Checkboxes" and click it.
    // Assert that the URL ends with "/checkboxes".

    // 21. Find an element that does not exist on the page using XPath.
    // Assert that findElements returns an empty list (size 0), not an exception.

    // 22. LISTS: Find every input on the page and assert the list size matches what you see in DevTools.
    // Hint: this is findElements, not findElement.

    // 23. LISTS: Find every input on the page and collect each one's type attribute.
    // Assert that the collected values include "password".

    // 24. CHALLENGE: Page /login: click Login with empty fields, then find the error message using contains() on its class attribute, for both "flash" and "error".
    // Assert that its text contains "Your username is invalid!".
    // Hint: the element only exists after the click. Inspect it in DevTools after you trigger the error by hand.
    // @Test

}
