package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test
    public void VisitLoginPage() {
        navPage.getLanguageButtonEN().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

}
