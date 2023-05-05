import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BaseTest;
import utils.UserTestUtilsAPI;

public class ExitAccountTest extends BaseTest {
    @Before
    public void init() {
        //Регистрируем пользователя через API
        user = UserTestUtilsAPI.makeRandomUser();
        UserTestUtilsAPI.createUser(user);
    }

    @Test
    @DisplayName("Checking logout button")
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете.")
    public void singInUserPasswordRecovery() {
        homePage.clickAccountButton()
                .inputUserData(user)
                .clickLoginButton()
                /* Пришлось добавить несколько нажатий на ссылку перехода в ЛК.
                   Без этого браузер иногда не переходил в него.
                   При ручной тестировании проблема повторить не удалось т.е. видимо это баг
                   тестовой система, а не сайта.
                 */
                .clickAccountButton()
                .clickAccountButton()
                .clickAccountButton()
                .clickAccountButtonWithLogin()
                .clickExitButton();
    }

    @After
    public void deInit() {
        //Use API for delete test user
        UserTestUtilsAPI.cleanUser(user);
    }
}
