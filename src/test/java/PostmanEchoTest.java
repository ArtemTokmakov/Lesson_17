import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.nullValue;

public class PostmanEchoTest {

    @Test
    public void getTest(){
        given()
                .baseUri("https://postman-echo.com")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawTextTest(){
        Response response = given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("expected text")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("expected text"))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

    @Test
    public void postFormDataTest(){
        Response response = given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.foo1", nullValue())
                .body("form.foo2", nullValue())
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .body("json.foo1", nullValue())
                .body("json.foo2", nullValue())
                .extract().response();
    }

    @Test
    public void putTest(){
        Response response = given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

    @Test
    public void patchTest(){
        Response response = given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

    @Test
    public void deleteTest(){
        Response response = given()
                .log().all()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host",equalTo("postman-echo.com"))
                .body("headers.x-request-start",notNullValue())
                .body("headers.connect-lenght",nullValue())
                .body("headers.x-forwarded-proto",equalTo("https"))
                .body("headers.x-forwarded-port",equalTo("443"))
                .body("headers.x-amzn-trace-id",notNullValue())
                .body("headers.accept",equalTo("*/*"))
                .body("headers.postman-token",nullValue())
                .body("headers.accept-encoding",equalTo("gzip,deflate"))
                .body("headers.cookie",nullValue())
                .extract().response();
    }

}
