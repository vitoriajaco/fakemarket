package vitoria.fakeMarket.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {
    @JsonProperty("id")
    Long id;
    @JsonProperty("title")
    String title;
    @JsonProperty("price")
    Double price;
/*    @JsonProperty("description")
    String description;*/
    @JsonProperty("category")
    String category;
/*    @JsonProperty("image")
    String image;*/
    @JsonProperty("rating")
     Rating rating;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Rating getRating() {
        return rating;
    }
}
