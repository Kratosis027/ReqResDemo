package tests.get;

import com.reqres.rest.RestClient;
import com.reqres.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.reqres.constants.Paths.PATH_TO_RESOURCES;
import static com.reqres.constants.Paths.PATH_TO_RESOURCES_LIST;

public class GetResourcesListTest {

    @Test(description = "Запрос списка ресурсов")
    public void getResourcesTest() {
        Response response = RestClient.getResourcesList();

        JsonUtils.validateResponse(response, PATH_TO_RESOURCES_LIST);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
