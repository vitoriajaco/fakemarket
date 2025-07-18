package vitoria.fakeMarket.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import vitoria.fakeMarket.enums.Category;
import vitoria.fakeMarket.response.ProductResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();



    public List<ProductResponse> getAllProducts(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://fakestoreapi.com/products"))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() != 200){
                throw new RuntimeException("Erro ao buscar endereço http" + response.statusCode());
            }

            String contentType = response.headers().firstValue("Content-Type").orElse("");
            if (!contentType.contains("application/json")){
                throw new RuntimeException("Resposta nao é json. Content type: " + contentType);
            }


            return objectMapper.readValue(response.body(), new TypeReference<List<ProductResponse>>() {});
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consumir API de produtos", e);

        }
    }


    public List<ProductResponse> buscarPorCategoria(Category categoria) {
       List<ProductResponse> todosProdutos = getAllProducts();
        return todosProdutos.stream().filter(produto -> produto.getCategory().equalsIgnoreCase
                (categoria.getValorApi())).collect(Collectors.toList());
    }


}
