package tests.delete;

import com.reqres.factory.UserFactory;
import com.reqres.models.post.BasicUser;
import com.reqres.rest.RestClient;
import com.reqres.utils.DataUtils;
import com.reqres.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteNotExistingUserTest {

    private static int id;

    @BeforeTest
    public void beforeDeleteNotExistingUserTest() {
        BasicUser user = UserFactory.getBasicUser();
        String response = RestClient.createUser(user).getBody().prettyPrint();
        BasicUser createdUser = JsonUtils.getJsonAsObject(response, BasicUser.class);
        id = DataUtils.parseStringToInt(createdUser.getId());

        RestClient.deleteUser(id);
    }

    @Test(description = "Удаление не существующего пользователя с валидным ID")
    public void deleteNotExistingUserTest() {
        Response response = RestClient.deleteUser(id);
        Assert.assertEquals(response.getBody().prettyPrint(), "");

        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
