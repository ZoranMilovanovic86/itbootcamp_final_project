package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 10)
    public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.getHomeLink();
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        navPage.getProfileLink();
        navPage.waitForProfilePageToLoadUp();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "Current site path do not contains /login in URL");
    }

}
