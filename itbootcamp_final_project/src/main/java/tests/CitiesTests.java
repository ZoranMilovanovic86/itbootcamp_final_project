package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CitiesTests extends BasicTest {

    @Test(priority = 10)
    public void visitAdminPanelAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Current site path do not contains /admin/cities in URL");
    }

    @Test(priority = 20)
    public void verifyInputTypes() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        Assert.assertEquals(citiesPage.getNameInput().getAttribute("type"), "text",
                "Name input field attribute type is not text");
    }

}