package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPersonalAccountPage extends CommonPageHeader {

    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public UserPersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickExitButton() {
        driver.findElement(exitButton).click();
        return new LoginPage(driver);
    }
}
