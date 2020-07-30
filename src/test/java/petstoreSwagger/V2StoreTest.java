package petstoreSwagger;

import io.restassured.*;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.*;

public class V2StoreTest extends V2StorePage {

    @Test
    public void createOrderforAPet() {
        RestAssured.given()
                .body(body)
                .header("content-type", "application/json")
                .when()
                .post("/order")
                .then()
                .log().all()
                .statusCode(200).assertThat()
                .body("petId", equalTo(0));
    }

    @Test
    public void findOrderById() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/order/" + orderId)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getStoreInventory() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("/inventory")
                .then().assertThat()
                .body("1", equalTo(1))
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deleteOrderById() {
        RestAssured.given()
                .header("accept", "application/json")
                .when()
                .delete("/order/" + orderId)
                .then().assertThat()
                .body("message", equalTo("Order Not Found"))
                .log().all()
                .statusCode(404);
    }
}