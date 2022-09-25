package tests.get;

import com.reqres.rest.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetResourcesWithNotExistingIdTest {

    @Test(description = "Запрос ресурсов с валидным, но не существующим ID")
    public void getResourcesWithNotExistingIdTest() {
        Response response = RestClient.getResources(45);

        Assert.assertEquals(response.getBody().prettyPrint(), "{\n    \n}");
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
