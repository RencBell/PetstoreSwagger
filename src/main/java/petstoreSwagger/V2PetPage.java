package petstoreSwagger;

import io.restassured.RestAssured;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;

public class V2PetPage {

    int petId = 5;
    // Formaterade strängen till JSon format: https://www.freeformatter.com/json-escape.html#ad-output
    String stringBody = "{\\r\\n  \\\"id\\\": 5,\\r\\n  \\\"category\\\": {\\r\\n    \\\"id\\\": 6,\\r\\n    \\\"name\\\": \\\"ahmed1\\\"\\r\\n  },\\r\\n  \\\"name\\\": \\\"ahmed2\\\",\\r\\n  \\\"photoUrls\\\": [\\r\\n    \\\"jpg\\\"\\r\\n  ],\\r\\n  \\\"tags\\\": [\\r\\n    {\\r\\n      \\\"id\\\": 7,\\r\\n      \\\"name\\\": \\\"ahmed3\\\"\\r\\n    }\\r\\n  ],\\r\\n  \\\"status\\\": \\\"available\\\"\\r\\n}\\r\\n";
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
        RestAssured.baseURI = ("https://petstore.swagger.io/v2");
    }
}