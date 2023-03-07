package RestAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Demo_GET_Request {

    @Test
    public void getWeatherDetails() {
        given()
                .when()
                .get("https://rahulshettyacademy.com")
                .then()
                .statusCode(200);

    }
}
