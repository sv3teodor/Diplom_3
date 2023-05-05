package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Общий класс для все страниц т.к. на всех страницах доступен одинаковый заголовой
public class CommonPageHeader {
    protected final By accountButton = By.xpath("//p[text()='Личный Кабинет']");
    protected final By constructorButton = By.xpath("//p[text()='Конструктор']");
    protected final By orderFeedButton = By.xpath("//p[text()='Лента Заказов']");
    protected final By logoButton = By.cssSelector(".AppHeader_header__logo__2D0X2");

    protected final WebDriver driver;

    public CommonPageHeader(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickAccountButton() {
        driver.findElement(accountButton).click();
        return new LoginPage(driver);
    }

    public UserPersonalAccountPage clickAccountButtonWithLogin() {
        driver.findElement(accountButton).click();
        return new UserPersonalAccountPage(driver);
    }

    public HomePage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new HomePage(driver);

    }

    public HomePage clickMainLogo() {
        driver.findElement(logoButton).click();
        return new HomePage(driver);
    }
}

