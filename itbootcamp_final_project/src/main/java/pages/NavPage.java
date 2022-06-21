package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
