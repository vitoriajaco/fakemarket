package vitoria.fakeMarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitoria.fakeMarket.client.MarketService;
import vitoria.fakeMarket.enums.Category;
import vitoria.fakeMarket.response.ProductResponse;

import java.util.List;





@RestController
@RequestMapping("/teste")
public class MarketController {

    public final MarketService marketService;


    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/products")
    public List<ProductResponse> retornaProdutos() {
        var response = marketService.getAllProducts();
        return response;
    }

    @GetMapping("/categoria/{categoria}")
    public List<ProductResponse> buscarPorCategoria(@PathVariable Category categoria) {
        var response = marketService.buscarPorCategoria(categoria);
        return response;


    }
}

