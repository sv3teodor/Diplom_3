package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojo.User;

public class RegistrationPage extends CommonPageHeader {
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By submitButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By sinInLink = By.xpath(".//*[text()='Войти']");

    private final By passwordErrorMessage = By.xpath(".//*[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }


    public LoginPage clickSubmit() {
        driver.findElement(submitButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickSinInLink() {
        driver.findElement(sinInLink).click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickSubmitWOTransfer() {
        driver.findElement(submitButton).click();
        return this;
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordErrorMessage).getText().contains("Некорректный пароль");
    }

    public RegistrationPage inputNewUserData(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return this;
    }
}
