package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 10)
    public void visitSignupPage() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Current site path do not contains /signup in URL");
    }

    @Test(priority = 20)
    public void verifyInputTypes() {
        navPage.getSignupButton().click();
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"), "email",
                "Email input field attribute type is not email");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"), "password",
                "Password input field attribute type is not password");
        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"), "password",
                "Confirm Password input field attribute type is not password");
    }
}
