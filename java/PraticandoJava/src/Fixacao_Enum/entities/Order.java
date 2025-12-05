package Fixacao_Enum.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private List<OrderItem> ot = new ArrayList<>();
    private Client ct = new Client();

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Date moment, OrderStatus status, Client ct ){
        this.moment = moment;
        this.status = status;
        this.ct = ct;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOt() {
        return ot;
    }

    public Client getCt() {
        return ct;
    }

    public void setCt(Client ct) {
        this.ct = ct;
    }

    public void addItem(OrderItem item){
        ot.add(item);
    }

    public void removeItem(OrderItem item){
        ot.remove(item);
    }

    public Double total(){
        Double total = 0.0;
        for(OrderItem x : ot){
            total += x.subTotal();
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order amount: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(ct + "\n");
        sb.append("Order Items: ");
        for(OrderItem x : ot){
            sb.append(x + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();

    }



}
