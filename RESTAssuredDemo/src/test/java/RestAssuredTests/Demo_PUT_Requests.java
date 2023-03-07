package RestAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Demo_PUT_Requests {
    public static HashMap mp = new HashMap();
    String empName = RestUtilities.empName();
    String empSal = RestUtilities.empSal();
    String empAge = RestUtilities.empAge();
    int empId = 1;

    @BeforeClass
    public void putData() {
        mp.put("name",empName);
        mp.put("salary",empSal);
        mp.put("age",empAge);

        RestAssured.baseURI = "https://dummy.restapiexample.com/public/api/v1";
        RestAssured.basePath = "/update/" +empId;

    }
    @Test
    public void testPut() {
         given()
                   .contentType("application/json")
                   .body(mp)
                 .when()
                   .put()
                 .then()
                   .statusCode(200)
                 .log().all();
    }
}
