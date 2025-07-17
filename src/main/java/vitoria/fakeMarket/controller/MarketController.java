package vitoria.fakeMarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitoria.fakeMarket.client.MarketService;
import vitoria.fakeMarket.response.ProductResponse;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class MarketController {

    public final MarketService marketService;


    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/{products}")
    List<ProductResponse> retornaProdutos(){
       var response =  marketService.getAllProducts();
        System.out.println(response + "Controller");
        return response;
    }
}
