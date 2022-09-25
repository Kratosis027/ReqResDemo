package tests.get;

import com.reqres.rest.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserWithInvalidIdTest {

    @Test(description = "Запрос данных по несуществующему ID, но в валидном формате")
    public void getUserWithInvalidIdTest() {
        Response response = RestClient.getUser("id");
        Assert.assertEquals(response.getBody().prettyPrint(), "{\n    \n}");

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
