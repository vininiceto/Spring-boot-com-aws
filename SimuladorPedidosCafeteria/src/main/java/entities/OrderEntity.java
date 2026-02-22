package entities;

public class OrderEntity {

    private final Double discount = 0.1;

    private String productName;
    private Double price;
    private Boolean clientRegistered;


    public OrderEntity() {
    }

    public OrderEntity(String productName, Double price, Boolean clientRegistered) {
        this.productName = productName;
        this.price = price;
        this.clientRegistered = clientRegistered;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setClientRegistered(Boolean clientRegistered) {
        this.clientRegistered = clientRegistered;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getClientRegistered() {
        return clientRegistered;
    }



    public Double totalOrder(Double price) {
        if (clientRegistered) {
            Double valueWithDiscount = (price * discount);
            return price - valueWithDiscount;

        }
        return price;

    }


}
