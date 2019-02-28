
import Classes.person;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.matching.UrlPattern;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 * Created by Gebruiker on 25-2-2019.
 */

public class personTest  {

    @Rule
    public WireMockRule wiremockRule = new WireMockRule(8888);

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
    //@RunWith(person.class)
    protected void GetPersonTest() {
        given()
        .when()
        .get("/HomeController/people")
        .then().body("number",equalTo(12));
    }

    @Test
    public void WireMockTest() {
        WireMock wiremock = new WireMock(8888);
        wiremock.register(post(urlEqualTo("/BigCompany"))
                .withRequestBody(containing("me"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("0")));

        Company ordina = new Company(new JavaDeveloper("me"));
        ordina.send(new Contractor("BigCompany"));
        wiremock.verifyThat(WireMock.postRequestedFor(urlEqualTo("/BigCompany")));
    }


}
