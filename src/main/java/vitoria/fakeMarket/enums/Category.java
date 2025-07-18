package vitoria.fakeMarket.enums;

public enum Category {
    MENS_CLOTHING("men's clothing"),
    WOMENS_CLOTHING("women's clothing"),
    JEWELERY("jewelery"),
    ELECTRONICS("electronics");

    private final String valorApi;

    Category(String valorApi) { //construtor
        this.valorApi = valorApi;
    }

    public String getValorApi() { //getter
        return valorApi;
    }

    public static Category fromApiValue(String valor) {
        for (Category category : values()){
            if (category.valorApi.equalsIgnoreCase(valor)){
                return category;
            }
        }
        throw new IllegalArgumentException("Categoria invalida " + valor);
    }
}
