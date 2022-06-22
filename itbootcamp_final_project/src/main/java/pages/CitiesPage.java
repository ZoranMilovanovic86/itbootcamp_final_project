package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return this.driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNameInputField() {
        return this.driver.findElement(By.id("name"));
    }

    public void waitForEditDialogToBeVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-card")));
    }

    public WebElement getSaveButton() {
        return this.driver.findElement(By.className("btnSave"));
    }

    public void waitSuccessfullyMessageToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getMessageSuccessfullyText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        return this.driver.findElement(By.className("success"));
    }

    public WebElement getSearchInputField() {
        return this.driver.findElement(By.id("search"));
    }

    public void waitForRowsToAppear(int rowNum) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum + 1));
    }

    public WebElement getEditButton(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex - 1);
    }

    public void waitForSaveButtonToBeClicable() {
        wait.until(ExpectedConditions.elementToBeClickable(getSaveButton()));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return this.driver.findElement(By.xpath("//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }

}
