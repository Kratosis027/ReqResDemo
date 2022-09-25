package tests.post;

import com.reqres.factory.UserFactory;
import com.reqres.models.post.BasicUser;
import com.reqres.models.response.User;
import com.reqres.rest.RestClient;
import com.reqres.utils.DataUtils;
import com.reqres.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.reqres.constants.Paths.PATH_TO_USER;

public class PostNewUserTest {

    @Test(description = "Создание нового пользователя")
    public void getExistingUserTest() {
        BasicUser user = UserFactory.getBasicUser();
        Response response = RestClient.createUser(user);
        BasicUser userToCreate = JsonUtils.getJsonAsObject(response.getBody().prettyPrint(), BasicUser.class);
        int id = DataUtils.parseStringToInt(userToCreate.getId());
        String name = userToCreate.getName();

        response = RestClient.getUser(id);
        User createdUser = JsonUtils.getJsonAsObject(response.getBody().prettyPrint(), User.class);
        Assert.assertEquals(createdUser.getData().getId(), id);
        Assert.assertEquals(createdUser.getData().getFirstName(), name);

        JsonUtils.validateResponse(response, PATH_TO_USER);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
