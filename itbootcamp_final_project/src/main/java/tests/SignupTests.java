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
}
