package tests.get;

import com.reqres.models.response.UserList;
import com.reqres.rest.RestClient;
import com.reqres.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.reqres.constants.Paths.PATH_TO_LIST_USER;

public class GetUserListOffsetTest {

    @Test(description = "Запрос списка юзеров")
    public void getUserListOffsetTest() {
        Response response = RestClient.getUserList();

        JsonUtils.validateResponse(response, PATH_TO_LIST_USER);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
