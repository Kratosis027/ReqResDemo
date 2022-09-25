package tests.get;

import com.reqres.factory.UserFactory;
import com.reqres.models.post.BasicUser;
import com.reqres.models.response.User;
import com.reqres.rest.RestClient;
import com.reqres.utils.DataUtils;
import com.reqres.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetNotExistingUserTest {

    private static int id;

    @BeforeTest
    public void beforeGetNotExistingUserTest() {
        BasicUser user = UserFactory.getBasicUser();
        String response = RestClient.createUser(user).getBody().prettyPrint();
        BasicUser createdUser = JsonUtils.getJsonAsObject(response, BasicUser.class);
        id = DataUtils.parseStringToInt(createdUser.getId());

        RestClient.deleteUser(id);
    }

    @Test(description = "Запрос данных по несуществующему ID, но в валидном формате")
    public void getNotExistingUserTest() {
        Response response = RestClient.getUser(id);
        Assert.assertEquals(response.getBody().prettyPrint(), "{\n    \n}");

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
