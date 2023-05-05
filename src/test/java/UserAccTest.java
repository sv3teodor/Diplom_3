import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.BaseTest;
import utils.UserTestUtilsAPI;

public class UserAccTest extends BaseTest {

    @Before
    public void init() {
        user = UserTestUtilsAPI.makeRandomUser();
        UserTestUtilsAPI.createUser(user);
    }

    //Переход в личный кабинет
    @Test
    @DisplayName("Check the click-through to the Personal Account.")
    @Description("Проверь переход по клику на «Личный кабинет».")
    public void checkClickThroughPersonalAcc() {
        Assert.assertTrue(homePage.clickAccountButton()
                .isEnterLabel());
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
