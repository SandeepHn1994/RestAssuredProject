package RestAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Demo2_POST_Request {
    public static HashMap map = new HashMap();
    @BeforeClass
    public void postData() {
        map.put("FirstName", RestUtilities.getFirstName());
        map.put("LastName",RestUtilities.getLastName());

        RestAssured.baseURI = "http://restapi.demoqa/cutomer" ;
    }

    @Test
    public void testPost() {

    }
}
