import api.SwaggerApi;
import clients.SwaggerClient;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.ConfigurationWhen;
import org.junit.jupiter.api.Test;
import swagger_model.SwaggerProductsRequest;
import swagger_model.SwaggerProductsResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.lessThan;
public class SwaggerTest {
    private static final String BASE_URL = "https://minimarket1.herokuapp.com/market/swagger-ui.html#/";
    private SwaggerClient client;

    @Test
    void testProductSearchGrocery() throws IOException {

        SwaggerProductsResponse products = client.findAllProducts(
                SwaggerProductsRequest.builder()
                        .id(11)
                        .title("burger")
                        .prise(100)
                        .categoryTitle("food")
                        .build()
        );

        String expected = getResourceAsString("products.json");

        JsonAssert.assertJsonEquals(
                expected,
                products,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );

    }
}
