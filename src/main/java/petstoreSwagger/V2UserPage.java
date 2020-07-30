package petstoreSwagger;

import io.restassured.RestAssured;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;

public class V2UserPage {

    String user = "No";
    String password = "nocco123";
    // Formaterade strängen till JSon format: https://www.freeformatter.com/json-escape.html#ad-output
    String stringBody = "{\\r\\n  \\\"id\\\": 2,\\r\\n  \\\"username\\\": \\\"No\\\",\\r\\n  \\\"firstName\\\": \\\"Noc\\\",\\r\\n  \\\"lastName\\\": \\\"Comp\\\",\\r\\n  \\\"email\\\": \\\"nocco@gmail.com\\\",\\r\\n  \\\"password\\\": \\\"nocco123\\\",\\r\\n  \\\"phone\\\": \\\"019283\\\",\\r\\n  \\\"userStatus\\\": 1\\r\\n}";
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
