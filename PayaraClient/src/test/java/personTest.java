
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 * Created by Gebruiker on 25-2-2019.
 */

public class personTest  {

    @BeforeClass
    public static void setup() {

        RestAssured.port = Integer.valueOf(8080);

        String basePath;
            basePath = "/PayaraClient_war/";
        RestAssured.basePath = basePath;

        String baseHost;
            baseHost = "http://localhost";
        RestAssured.baseURI = baseHost;
    }


    @Test
    public void homeController() {
        given()
        .when()
        .get("/HomeController")
        .then().statusCode(200);
    }

    //these test dont work
    @Test
    public void GetPersonTest() {
        given()
        .when()
        .get("/HomeController/people")
        .then().body("number",equalTo(12));
    }
}
