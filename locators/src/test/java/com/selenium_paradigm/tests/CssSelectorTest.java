package com.selenium_paradigm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CssSelectorTest extends BaseTest {
    
    // 1. Find the username field using By.id.
    // Assert that it is displayed.
    @Test 
    public void usernameTest(){
        
        driver.get("https://www.saucedemo.com");
        
        WebElement username = driver.findElement(By.id("user-name"));
        
        assertThat(username.isDisplayed()).isTrue();
    }

    // 2. Find the password field using By.name.
    // Assert that it is displayed.
    @Test
    public void passwordTest(){

        driver.get("https://www.saucedemo.com");
        
        WebElement password = driver.findElement(By.name("password"));

        assertThat(password.isDisplayed()).isTrue();
    }

    // 3. Find the Login button using a CSS selector that matches an attribute.
    // Assert that its value attribute is the text shown on the button.
    @Test
    public void loginButtonTest(){

        driver.get("https://www.saucedemo.com");

        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='login-button']"));
    
        assertThat(loginButton.getAttribute("value")).isEqualTo("Login");
    }

    // 4. Find the Login button using a CSS selector that matches its id (#).
    // Assert that it is enabled.
    @Test
    public void loginButtonIsEnabledTest(){

        driver.get("https://www.saucedemo.com");

        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
    
        assertThat(loginButton.isEnabled()).isTrue();
    }

    // 5. Find the "Swag Labs" logo using a CSS selector that matches its class (.).
    // Assert that its text is "Swag Labs".
    @Test
    public void logoTest(){

        driver.get("https://www.saucedemo.com");

        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_logo")));
    
        assertThat(logo.getText()).isEqualTo("Swag Labs");
    }

    // 6. Find the password field using a CSS selector with the tag name AND the type attribute.
    // Assert that its name attribute is "password".
    @Test
    public void passwordFieldTest(){

        driver.get("https://www.saucedemo.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
    
        assertThat(passwordField.getAttribute("name")).isEqualTo("password");
    }

    // 7. Find the username field using a CSS selector that matches its placeholder attribute.
    // Assert that its id attribute is "user-name".
    @Test
    public void usernameFieldTest(){

        driver.get("https://www.saucedemo.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
    
        assertThat(passwordField.getAttribute("id")).isEqualTo("user-name");
    }

    // 8. Find every element that HAS a data-test attribute, whatever its value, using an attribute-presence selector ([attr]).
    // Assert that the list has at least 3 elements.
    // Hint: findElements, not findElement.
    @Test
    public void dataTestTest(){

        driver.get("https://www.saucedemo.com");

        List<WebElement> dataTestElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[data-test]")));
    
        assertThat(dataTestElements.size()).isGreaterThan(3);
    }

    // 9. Find the username field using a CSS selector with contains (*=) on the id attribute.
    // Assert that its name attribute is "user-name".
    @Test
    public void usernameContainsTest(){

        driver.get("https://www.saucedemo.com");

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id*='user-na']")));
    
        assertThat(username.getAttribute("name")).isEqualTo("user-name");
    }

    // 10. Find the password field using a CSS selector with starts-with (^=) on the id attribute.
    // Assert that it is displayed.
    @Test
    public void passwordStartsWithTest(){

        driver.get("https://www.saucedemo.com");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id^='passw']")));
    
        assertThat(element.isDisplayed()).isTrue();
    }

    // 11. Find the Login button using a CSS selector with ends-with ($=) on the data-test attribute.
    // Assert that its value attribute is "Login".
    @Test
    public void loginEndsWithTest(){

        driver.get("https://www.saucedemo.com");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test$='in-button']")));
    
        assertThat(element.getAttribute("value")).isEqualTo("Login");
    }

    // 12. Find the username field using a CSS selector that chains TWO attribute conditions on the same element ([a='x'][b='y']).
    // Assert that it is displayed.
    @Test
    public void usernameTwoAttributesTest(){

        driver.get("https://www.saucedemo.com");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector("[placeholder='Username'][type='text']")));
    
        assertThat(element.isDisplayed()).isTrue();
    }

    // 13. Find the Login button using a CSS selector that matches TWO classes at once (.class1.class2).
    // Assert that it is displayed.
    @Test
    public void usernameTwoClassesTest(){

        driver.get("https://www.saucedemo.com");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector(".submit-button.btn_action")));
    
        assertThat(element.isDisplayed()).isTrue();
    }

    // From #14 on, any test that names a page (/tables, /checkboxes, /dynamic_controls, /login) uses https://the-internet.herokuapp.com.
    // Start those with driver.get(...). Tests that name no page (#24-#27) stay on saucedemo.

    // 14. Page /tables: find the first <td> inside the table with id "table1" using a descendant selector (a space between the two parts).
    // Assert that its text is "Smith".
    @Test
    public void tablesTest(){

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement element = wait.until(
            ExpectedConditions
            .visibilityOfElementLocated(
                By.cssSelector("#table1 td")));
    
        assertThat(element.getText()).isEqualTo("Smith");
    }

    // 15. Page /tables: find the body rows of "table1" using direct-child selectors only (parent > child > grandchild).
    // Assert that there are 4 rows.
    // Hint: try "#table1 > tr" first and work out why it finds nothing. Check the table's structure in DevTools.
    @Test
    public void tableDirectChildTest(){

        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> elements = wait.until(
            ExpectedConditions
            .visibilityOfAllElementsLocatedBy(
                By.cssSelector("#table1 > tbody > tr")));
    
        assertThat(elements.size()).isEqualTo(4);
    }

    // 16. Page /tables: in "table2", find the cell directly after the last-name cell using the adjacent-sibling (+) combinator.
    // Assert that its text is "John".
    // Hint: the cells in table2 have classes.

    // 17. Page /tables: in "table2", find the "action" cell by starting from the email cell and using the general-sibling (~) combinator.
    // Assert that its text contains "edit".

    // 18. Page /tables: find the third body row of "table1" using :nth-child().
    // Assert that its text contains "Doe".

    // 19. Page /tables: find the last body row of "table1" using :last-child.
    // Assert that its text contains "Conway".

    // 20. Page /checkboxes: find the checkbox that is NOT checked using :not() with an attribute inside it.
    // Assert that it is not selected.

    // 21. Page /checkboxes: find the checkbox that is checked using the :checked pseudo-class.
    // Assert that it is selected.

    // 22. Page /dynamic_controls: find the text input that is disabled using the :disabled pseudo-class.
    // Assert that it is not enabled.

    // 23. Page /login: find the username field or the password field with a single CSS selector using a comma.
    // Assert that findElements returns exactly 2 elements.

    // 24. Find the element that holds the error message BEFORE any error appears, using a div selector with the :empty pseudo-class.
    // Assert that its text is an empty string.
    // Hint: inspect the page in DevTools. This is the saucedemo login page.

    // 25. Find an element that does not exist on the page using a CSS selector.
    // Assert that findElements returns an empty list (size 0), not an exception.

    // 26. LISTS: Find every input on the page and assert the list size matches what you see in DevTools.
    // Hint: this is findElements, not findElement.

    // 27. LISTS: Find every input on the page and collect each one's type attribute.
    // Assert that the collected values include "password".

    // 28. SCOPED SEARCH: Page /tables: find "table1", then call findElements on that element for its body rows ("tbody tr").
    // Assert that the count is smaller than the count of all "tr" elements on the whole page.
    // Hint: element.findElements(...) searches only inside that element.

    // 29. CHALLENGE: Page /login: click Login with empty fields, then find the error message using a CSS selector that combines two classes.
    // Assert that its text contains "Your username is invalid!".
    // Hint: the element only exists after the click. Inspect it in DevTools after you trigger the error by hand.

}
