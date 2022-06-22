package tests;

import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        Assert.assertEquals(citiesPage.getNameInputField().getAttribute("type"), "text",
                "Name input field attribute type is not text");
    }

    @Test(priority = 30)
    public void createNewCity() {
        String city = "Zoran Milovanovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditDialogToBeVisible();
        citiesPage.getNameInputField().sendKeys(city);
        citiesPage.getSaveButton().click();
        citiesPage.waitSuccessfullyMessageToBeVisible();
        Assert.assertTrue(citiesPage.getMessageSuccessfullyText().getText().contains("Saved successfully"),
                "Saved successfully message is missing");
    }

    @Test(priority = 40)
    public void editCity() {
        String oldCityName = "Zoran Milovanovic's city";
        String newCityName = "Zoran Milovanovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getSearchInputField().sendKeys(oldCityName);
        citiesPage.waitForRowsToAppear(1);
        citiesPage.getEditButton(1).click();
        citiesPage.getNameInputField().click();
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(newCityName).perform();
        citiesPage.waitForSaveButtonToBeClicable();
        citiesPage.getSaveButton().click();
        citiesPage.waitSuccessfullyMessageToBeVisible();
        Assert.assertTrue(citiesPage.getMessageSuccessfullyText().getText().contains("Saved successfully"),
                "Saved successfully message is missing");
    }

}
