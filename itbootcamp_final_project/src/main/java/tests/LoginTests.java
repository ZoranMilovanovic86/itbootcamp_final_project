package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    public void visitLoginPage() {
        navPage.getLanguageButtonEN().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 20)
    public void verifyInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "Email input field attribute type is not email");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "Password input field attribute type is not password");
    }

}
