package org.example;

import static io.restassured.RestAssured.given;
public class oAuthTest {

    public static void main(String[] args) {
        given().queryParam("code","")
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("");

        String response = given().queryParam("access_token","")
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .asString();
                System.out.println(response);




    }
}
