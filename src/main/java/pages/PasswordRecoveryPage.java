package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends CommonPageHeader {
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By loginLink = By.xpath(".//*[text()='Войти']");
    private final By recoveryButton = By.xpath("//button[contains(text(),'Восстановить')]");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

}
