package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pojo.User;

import static utils.WebTestUtils.isElementDisplayed;

public class LoginPage extends CommonPageHeader {
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerLink = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private final By recoveryPasswordLink = By.xpath("//a[contains(text(),'Восстановить пароль')]");
    private final By enterLabel = By.xpath("//*[contains(text(),'Вход')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public RegistrationPage clickRegisterLink() {
        driver.findElement(registerLink).click();
        return new RegistrationPage(driver);
    }

    public PasswordRecoveryPage clickRecoveryPasswordLink() {
        driver.findElement(recoveryPasswordLink).click();
        return new PasswordRecoveryPage(driver);
    }

    public LoginPage inputUserData(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return this;
    }

    public boolean isEnterLabel() {
        return isElementDisplayed(driver, enterLabel);
    }

}
