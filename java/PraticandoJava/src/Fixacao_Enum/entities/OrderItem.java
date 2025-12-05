package Fixacao_Enum.entities;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product pdt;


    public OrderItem(){}

    public OrderItem(Integer quantity, Double price, Product pdt){
        this.quantity = quantity;
        this.price = price;
        this.pdt = pdt;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public Double getPrice(){
        return price;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Product getPdt() {
        return pdt;
    }

    public void setPdt(Product pdt) {
        this.pdt = pdt;
    }

    public Double subTotal(){
        return quantity * price;
    }

    @Override
    public String toString() {
        return pdt.getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity +
                ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}
