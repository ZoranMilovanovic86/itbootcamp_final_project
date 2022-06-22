package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNameInputField() {
        return driver.findElement(By.id("name"));
    }

    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-card")));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }

    public void waitSuccessfullyMessageToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getMessageSuccessfullyText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        return driver.findElement(By.className("success"));
    }

    public WebElement getSearchInputField() {
        return driver.findElement(By.id("search"));
    }

    public void waitForRowsToAppear(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum + 1));
    }

    public WebElement getEditButton(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex - 1);
    }

    public void waitForSaveButtonToBeClicable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getSaveButton()));
    }

}
