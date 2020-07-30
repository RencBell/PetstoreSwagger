package petstoreSwagger;

import io.restassured.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;

public class V2UserTest extends V2UserPage {

    @Test
    public void createUserWithAllParameters() {
        RestAssured.given()
                .body(body)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .when()
                .post("/user")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createUserWithArray() {
        Map<String, Object> createUser = new HashMap<String, Object>();
        createUser.put("username", "No");
        createUser.put("firstName", "Noc");
        createUser.put("lastName", "Comp");
        createUser.put("email", "nocco@gmail.com");
        createUser.put("password", "nocco123");
        createUser.put("phone", "019283");
        createUser.put("userStatus", "1");

        List<Map<String, Object>> jsonArrayPayload = new ArrayList<>();
        jsonArrayPayload.add(createUser);

        RestAssured.given()
                .body(jsonArrayPayload)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .when()
                .post("/user/createWithArray")
                .then().assertThat()
                .body("code", equalTo(200))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createUserWithArrayList() {

        Map<String, Object> createUser = new HashMap<>();
        createUser.put("username", "No");
        createUser.put("firstName", "Noc");
        createUser.put("lastName", "Comp");
        createUser.put("email", "nocco@gmail.com");
        createUser.put("password", "nocco123");
        createUser.put("phone", "019283");
        createUser.put("userStatus", "1");

        List<Map<String, Object>> jsonArrayPayload = new ArrayList<>();
        jsonArrayPayload.add(createUser);

        RestAssured.given()
                .body(jsonArrayPayload)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .when()
                .post("/user/createWithList")
                .then().assertThat()
                .body("code", equalTo(200))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getUserByUsername() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/user/" + user)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateUserByUsername() {
        RestAssured.given()
                .body(body)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .when()
                .put("/user/" + user)
                .then().assertThat()
                .body("code", equalTo(200))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void userLoginByUsernameAndPassword() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/user/login?username=No&password=nocco123")
                .then().assertThat()
                .body("code", equalTo(200))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void userLoggout() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/user/logout")
                .then().assertThat()
                .body("code", equalTo(200))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deleteUserByUsername() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .delete("/user/" + user)
                .then()
                .log().all().assertThat()
                .body("code", equalTo(200))
                .statusCode(200);
    }
}