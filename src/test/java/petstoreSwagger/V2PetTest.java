package petstoreSwagger;

import io.restassured.*;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.equalTo;

public class V2PetTest extends V2PetPage {

    @Test
    public void addPetWithAllParameters() {
        RestAssured.given()
                .body(body)
                .header("content-type", "application/json")
                .when()
                .post("/pet")
                .then().assertThat()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void addPetWithId() {
        String bodyId = "{\r\n  \"id\": 5\r\n  }";

        RestAssured.given()
                .body(bodyId)
                .header("content-type", "application/json")
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200).assertThat()
                .body("id", equalTo(5));
    }

    @Test
    public void addPetWithName() {
        String bodyName = "{\r\n  \"name\": \"ahmed\"\r\n}";

        RestAssured.given()
                .body(bodyName)
                .header("content-type", "application/json")
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void addPetWithStatus() {
        String bodyStatus = "{\r\n  \"status\": \"available\"\r\n}";

        RestAssured.given()
                .body(bodyStatus)
                .header("content-type", "application/json")
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void uppdatePetWithAllParameters() {
        RestAssured.given()
                .body(body)
                .header("content-type", "application/json")
                .when()
                .put("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePetWithName() {
        String bodyName = "{\\r\\n  \\\"id\\\": 5,\\r\\n    \\\"name\\\": \\\"ahmed1\\\"\\r\\n}";

        RestAssured.given()
                .body(bodyName)
                .header("content-type", "application/json")
                .when()
                .put("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePetWithStatus() {
        String bodyStatus = "{\\r\\n  \\\"status\\\": \\\"available\\\"\\r\\n}";

        RestAssured.given()
                .body(bodyStatus)
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .when()
                .put("/pet")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getPetById() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/pet/" + petId)
                .then().assertThat()
                .body("id", equalTo(5))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getPetByStatus() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/pet/findByStatus?status=sold")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deletePetById() {
        RestAssured.given()
                .header("api_key", "special-key")
                .header("accept", "application/json")
                .when()
                .delete("/pet/" + petId)
                .then()
                .log().all()
                .statusCode(200);
    }
}