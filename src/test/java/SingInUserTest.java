import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.BaseTest;
import utils.UserTestUtilsAPI;

public class SingInUserTest extends BaseTest {

    @Before
    public void init() {
        user = UserTestUtilsAPI.makeRandomUser();
        UserTestUtilsAPI.createUser(user);

    }

    @Test
    @DisplayName("Sing in user test main button")
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void singInUserMainButton() {
        homePage.clickSignInButton()
                .inputUserData(user)
                .clickLoginButton();
        Assert.assertTrue(homePage.isCreateOrderButton());
    }

    @Test
    @DisplayName("Login via your personal account")
    @Description("вход через кнопку «Личный кабинет")
    public void singInUserPersonalAccButton() {
        homePage.clickAccountButton()
                .inputUserData(user)
                .clickLoginButton();
        Assert.assertTrue(homePage.isCreateOrderButton());
    }

    @Test
    @DisplayName("Login via registration form")
    @Description("вход через кнопку в форме регистрации")
    public void singInUserRegFormButton() {
        homePage.clickAccountButton()
                .clickRegisterLink()
                .clickSinInLink()
                .inputUserData(user)
                .clickLoginButton();
        Assert.assertTrue(homePage.isCreateOrderButton());
    }

    @Test
    @DisplayName("Login via password recovery link")
    @Description("вход через кнопку в форме восстановления пароля.")
    public void singInUserPasswordRecovery() {
        homePage.clickAccountButton()
                .clickRecoveryPasswordLink()
                .clickLoginLink()
                .inputUserData(user)
                .clickLoginButton();
        Assert.assertTrue(homePage.isCreateOrderButton());
    }


    @After
    public void deInit() {
        //Use API for delete test user
        UserTestUtilsAPI.cleanUser(user);
    }

}
