import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import utils.BaseTest;

public class ConstructionTest extends BaseTest {

    @Test
    @DisplayName("Select buns test")
    @Description("Проверь, что работают переход к разделу-Булки:")
    public void selectBunsCheck() {
        homePage.clickSauceOption()
                .clickBunOption();
        Assert.assertTrue(homePage.isBunMenuHeader());
    }

    @Test
    @DisplayName("Select Sauce test")
    @Description("Проверь, что работают переход к разделу-Соусы:")
    public void selectSauceCheck() {
        homePage.clickFillingOption()
                .clickSauceOption();
        Assert.assertTrue(homePage.isSauceMenuHeader());
    }

    @Test
    @DisplayName("Select Filling test")
    @Description("Проверь, что работают переход к разделу-Начинки")
    public void selectFillingCheck() {
        homePage.clickFillingOption();
        Assert.assertTrue(homePage.isFillingMenuHeader());
    }

}


