package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLanguageButtonEN() {
        this.driver.findElement(By.className("btnLocaleActivation")).click();
        return this.driver.findElement(By.id("list-item-73"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.linkText("LOGIN"));
    }

    public WebElement getLogoutButton() {
        return this.driver.findElement(By.className("btnLogout"));
    }

    public WebElement getSignupButton() {
        return this.driver.findElement(By.linkText("SIGN UP"));
    }

    public WebElement getAdminButton() {
        return this.driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesButton() {
        return this.driver.findElement(By.linkText("Cities"));
    }

    public void goToHomeUrl() {
        this.driver.navigate().to(driver.getCurrentUrl() + "home");
    }

    public void waitForLoginPageToLoadUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    public void goToProfileUrl() {
        this.driver.get(driver.getCurrentUrl() + "profile");
    }

    public void goToAdminCitiesUrl() {
        this.driver.get(driver.getCurrentUrl() + "admin/cities");
    }


}
