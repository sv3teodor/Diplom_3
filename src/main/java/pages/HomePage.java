package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.WebTestUtils.isElementDisplayed;

public class HomePage extends CommonPageHeader {

    private final By signInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By createBurgerLabel = By.xpath(".//*[text()='Соберите бургер']");

    private final By bunOption = By.xpath(".//div/span[text() ='Булки']");
    private final By bunMenuHeader = By.xpath("//main/section[1]/div[2]/h2[text()='Булки']");
    private final By sauceOption = By.xpath(".//div/span[text()='Соусы']");
    private final By sauceMenuHeader = By.xpath("//main/section[1]/div[2]/h2[text()='Соусы']");
    private final By fillingOption = By.xpath(".//div/span[text()='Начинки']");
    private final By fillingMenuHeader = By.xpath("//main/section[1]/div[2]/h2[text()='Начинки']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickBunOption() {
        driver.findElement(bunOption).click();
        return this;
    }

    public HomePage clickSauceOption() {
        driver.findElement(sauceOption).click();
        return this;
    }

    public HomePage clickFillingOption() {
        driver.findElement(fillingOption).click();
        return this;
    }

    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public boolean isCreateOrderButton() {
        return isElementDisplayed(driver, createOrderButton);
    }

    public boolean isCreateBurgerLabel() {
        return isElementDisplayed(driver, createBurgerLabel);
    }

    public boolean isBunMenuHeader() {
        return isElementDisplayed(driver, bunMenuHeader);
    }

    public boolean isSauceMenuHeader() {
        return isElementDisplayed(driver, sauceMenuHeader);
    }

    public boolean isFillingMenuHeader() {
        return isElementDisplayed(driver, fillingMenuHeader);
    }

}