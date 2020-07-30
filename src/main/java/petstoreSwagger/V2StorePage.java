package petstoreSwagger;

import io.restassured.RestAssured;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;

public class V2StorePage {

    int orderId = 4;
    // Formaterade strängen till JSon format: https://www.freeformatter.com/json-escape.html#ad-output
    String stringBody = "{\\r\\n  \\\"id\\\": 3,\\r\\n  \\\"petId\\\": 4,\\r\\n  \\\"quantity\\\": 5,\\r\\n  \\\"shipDate\\\": \\\"2020-05-27T08:19:39.944Z\\\",\\r\\n  \\\"status\\\": \\\"placed\\\",\\r\\n  \\\"complete\\\": true\\r\\n}";
    JSONObject body;

    {
        try {
            body = (JSONObject) new JSONParser().parse(stringBody);
        } catch (ParseException a) {
            a.printStackTrace();
        }
    }

    @BeforeEach
    public void beforeEach() {
        RestAssured.baseURI = ("https://petstore.swagger.io/v2/store");
    }
}