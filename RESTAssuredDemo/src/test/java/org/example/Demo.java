package org.example;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;


import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Demo {

    public static void main(String[] args) {
        //given
        //when
        //then
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope",equalTo("APP"))
                .header("server","Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();
        System.out.println("Below is the response -->   " +response);

        //Add place __. update place with new address --> Get place to validate if new address is present
        JsonPath js = new JsonPath(response);
        String placeId =  js.getString("place_id");
        System.out.println("The place id is:  " + placeId);

       //update place
        String newAddress = "Summer walk , Africa";
        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg" , equalTo("Address successfully updated"));
      //get place

                String getPlaceRes = given().log().all().queryParam("key","qaclick123")
                .queryParam("place_id",placeId)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

                JsonPath js2 = new JsonPath(getPlaceRes);
                String actualNewAddress = js2.getString("address");
                System.out.println(actualNewAddress);

                Assert.assertEquals(actualNewAddress,newAddress);
              // Assert.assertEquals(actualNewAddress,newAddress);
              // Junit and TestNG
    }
}