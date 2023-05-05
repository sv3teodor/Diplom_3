package utils;

import configs.ApiRequests;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.User;
import pojo.UserSession;

import static configs.TestConfig.PASSWORD_MAX_LENGTH;
import static configs.TestConfig.PASSWORD_MIN_LENGTH;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.BaseTest.faker;

public class UserTestUtilsAPI {
    @Step("Create user")
    public static Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(ApiRequests.USER_CREATE);
    }

    @Step("User delete")
    public static Response deleteUser(UserSession user) {

        return given()
                .header("Authorization", user.getAccessToken())
                .delete(ApiRequests.USER_DELETE);

    }

    @Step("User login")
    public static Response loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(ApiRequests.USER_LOGIN);
    }


    @Step("Delete date after tests")
    public static void cleanUser(User user) {
        Response response = UserTestUtilsAPI.loginUser(user);

        if (response.statusCode() == SC_OK) {
            UserTestUtilsAPI.deleteUser(response.as(UserSession.class));
        }

    }

    public static User makeRandomUser() {
        return
                new User(faker.internet().emailAddress(),
                        faker.internet().password(PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH),
                        faker.name().name());
    }

}
