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

public class DeleteExistingUserTest {

    private static int id;

    @BeforeTest
    public void beforeDeleteExistingUserTest() {
        BasicUser user = UserFactory.getBasicUser();
        String response = RestClient.createUser(user).getBody().prettyPrint();
        BasicUser createdUser = JsonUtils.getJsonAsObject(response, BasicUser.class);
        id = DataUtils.parseStringToInt(createdUser.getId());
    }

    @Test(description = "Удаление существующего пользователя с валидным ID")
    public void deleteExistingUserTest() {
        Response response = RestClient.deleteUser(id);
        Assert.assertEquals(response.getBody().prettyPrint(), "");

        Assert.assertEquals(response.getStatusCode(), 204);

        response = RestClient.getUser(id);
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
