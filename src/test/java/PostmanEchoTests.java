import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.goose.Lesson_17.Config.*;

public class PostmanEchoTests {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = BASE_PORT;
    }

    @Test
    public void getRequest() {
        Response response =
                given()
                        .queryParam("foo1", "bar1")
                        .queryParam("foo2", "bar2")
                        .when()
                        .get("/get")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String foo1 = response.jsonPath().getString("args.foo1");
        String foo2 = response.jsonPath().getString("args.foo2");
        assert (foo1.equals("bar1"));
        assert (foo2.equals("bar2"));
    }

    @Test
    public void postRawText() {
        String requestBody = "1 2 3 4 5 6 7 8 9 0";
        Response response =
                given()
                        .contentType(ContentType.TEXT)
                        .body(requestBody)
                        .when()
                        .post("/post")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String responseBody = response.jsonPath().getString("data");
        System.out.println("Response body: " + responseBody);
        assert (responseBody.equals(requestBody));
    }

    @Test
    public void postFormData() {
        Response response =
                given()
                        .multiPart("key1", "value1")
                        .multiPart("key2", "value2")
                        .when()
                        .post("/post")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String key1 = response.jsonPath().getString("form.key1");
        String key2 = response.jsonPath().getString("form.key2");
        assert (key1.equals("value1"));
        assert (key2.equals("value2"));
    }

    @Test
    public void putRequest() {
        String requestBody = "{ hello: there, general: kenobi }";
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put("/put")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String responseBody = response.jsonPath().getString("data");
        System.out.println("Response body: " + responseBody);
        assert (responseBody.equals(requestBody));
    }

    @Test
    public void patchRequest() {
        String requestBody = "{ key1: value1, key2: value2 }";
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .patch("/patch")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String responseBody = response.jsonPath().getString("data");
        System.out.println("Response body: " + responseBody);
        assert (responseBody.equals(requestBody));
    }

    @Test
    public void deleteRequest() {
        Response response =
                given()
                        .when()
                        .delete("/delete")
                        .then()
                        .statusCode(200)
                        .extract().response();
        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);
    }
}