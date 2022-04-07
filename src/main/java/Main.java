import clients.SwaggerClient;
import swagger_model.*;
import swagger_model.AutoCompleteProductResponse;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SwaggerClient client = new SwaggerClient();

        AutoCompleteProductResponse burger = client.autocomplete("burger", 3L);

        System.out.println(burger);

        SwaggerProductsResponse products = client.findAllProducts(
                SwaggerProductsRequest.builder()
                        .id(11)
                        .title("burger")
                        .prise(100)
                        .categoryTitle("food")
                        .build()
        );

        products.getTitle().forEach(System.out::println);
    }
}