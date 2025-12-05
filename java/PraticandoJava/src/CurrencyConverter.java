public class CurrencyConverter {

    private final Double IOF = 0.06;
    private Double dollarPrice;
    private Double quantity;

    public CurrencyConverter(Double dollarPrice, Double quantity){
        this.dollarPrice = dollarPrice;
        this.quantity = quantity;
    }

    public Double getDollarPrice(){
        return dollarPrice;
    }

    public void setDollarPrice(Double dollarPrice){
        this.dollarPrice = dollarPrice;
    }

    public Double getQuantity(){
        return quantity;
    }

    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }

    public void converter(){
        double result = dollarPrice * quantity * (1 + IOF);
            System.out.println("Amount to be paid in reais = " + result);
    }



}
