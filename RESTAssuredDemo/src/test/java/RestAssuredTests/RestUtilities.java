package RestAssuredTests;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilities {

    public static String getFirstName() {
        String generatedRandomString = RandomStringUtils.randomAlphabetic(1);
        return ("John" +generatedRandomString);
    }
    public static String getLastName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Kenedy" + generatedString);
    }

    public static String getUserName() {
        String generatedString = RandomStringUtils.randomAlphanumeric(3);
        return ("John"+generatedString);
    }
    public static String empName() {
        String generatedEmpName = RandomStringUtils.randomAlphabetic(1);
        return ("Johny"+generatedEmpName);
    }

    public static String empSal() {
        String generateRandomSal = RandomStringUtils.randomNumeric(5);
        return (generateRandomSal);
    }
    public static String empAge() {
        String generateAge = RandomStringUtils.randomNumeric(2);
        return (generateAge);
    }



}
