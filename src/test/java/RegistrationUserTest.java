import configs.TestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.BaseTest;
import utils.UserTestUtilsAPI;

public class RegistrationUserTest extends BaseTest {

    @Before
    public void init() {
        user = UserTestUtilsAPI.makeRandomUser();
    }

    @Test
    @DisplayName("New registration check")
    @Description("Проверь: Успешную регистрацию.")
    public void newRegisterCheck() {
        homePage.clickSignInButton()
                .clickRegisterLink()
                .inputNewUserData(user)
                .clickSubmit();
    }

    @Test
    @DisplayName("New registration with incorrect password")
    @Description("Проверь: Ошибку для некорректного пароля.")
    public void newRegisterWithIncorrectPassword() {

        user.setPassword(faker.internet().password(1, TestConfig.PASSWORD_MIN_LENGTH - 1));
        Assert.assertTrue(homePage.clickSignInButton()
                .clickRegisterLink()
                .inputNewUserData(user)
                .clickSubmitWOTransfer()
                .isPasswordErrorDisplayed());
    }

    @After
    //Удаляем пользователя через API если он был заведен
    public void cleanUserData() {
        UserTestUtilsAPI.cleanUser(user);
    }

}
