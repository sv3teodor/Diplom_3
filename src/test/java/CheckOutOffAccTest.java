import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import utils.BaseTest;

public class CheckOutOffAccTest extends BaseTest {

    @Test
    @DisplayName("Click construction of personal acc")
    @Description("Переход из личного кабинета в конструктор .")
    public void returnFromAccToConstruction() {
        Assert.assertTrue(homePage
                .clickSignInButton()
                .clickConstructorButton()
                .isCreateBurgerLabel());
    }

    @Test
    @DisplayName("Click main logo of personal acc")
    @Description("Переход из личного кабинета на главную странице через логотип Stellar Burgers .")
    public void returnFromAccToHomePage() {
        Assert.assertTrue(homePage
                .clickSignInButton()
                .clickMainLogo()
                .isCreateBurgerLabel());
    }

}
