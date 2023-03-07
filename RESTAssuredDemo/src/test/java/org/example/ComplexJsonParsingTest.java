package org.example;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParsingTest {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(payload.CoursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);

        int cntofdb= js.getInt("dashboard.purchaseAmount");
        System.out.println(cntofdb);

        String wbs = js.getString("dashboard.website");
        System.out.println(wbs);

    }




}
