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

import static com.reqres.constants.Paths.PATH_TO_LIST_USER;
import static com.reqres.constants.Paths.PATH_TO_USER;

public class GetExistingUserTest {

    private static int id;
    private static String name;

    @BeforeTest
    public void beforeGetExistingUserTest() {
        BasicUser user = UserFactory.getBasicUser();
        Response response = RestClient.createUser(user);
        BasicUser createdUser = JsonUtils.getJsonAsObject(response.getBody().prettyPrint(), BasicUser.class);
        id = DataUtils.parseStringToInt(createdUser.getId());
        name = createdUser.getName();
    }

    @Test(description = "Запрос данных по валидному ID, проверка возвращения корректных данных")
    public void getExistingUserTest() {
        Response response = RestClient.getUser(id);
        User user = JsonUtils.getJsonAsObject(response.getBody().prettyPrint(), User.class);
        Assert.assertEquals(user.getData().getId(), id);
        Assert.assertEquals(user.getData().getFirstName(), name);

        JsonUtils.validateResponse(response, PATH_TO_USER);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
