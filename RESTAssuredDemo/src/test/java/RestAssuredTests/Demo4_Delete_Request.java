package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Demo4_Delete_Request {
    @Test
     public void deleteEmpRecord() {
         RestAssured.baseURI = "https://dummy.restapiexample.com/public/api/v1";
                 RestAssured.basePath = "/delete/11500";

                 Response response =
                         given()
                         .when()
                         .delete()
                         .then()
                         .statusCode(200)
                         .statusLine("HTTP/1.1 200 OK")
                         .log().all()
                         .extract().response();
                 String jsonResponse = response.asString();
                 Assert.assertEquals(jsonResponse.contains("Successfully! Record has been deleted"),true);

    }
}
