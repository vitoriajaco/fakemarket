package vitoria.fakeMarket.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {

    @JsonProperty("rate")
    double rate;
    @JsonProperty("count")
    int count;
}
