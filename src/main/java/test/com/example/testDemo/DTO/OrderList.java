package test.com.example.testDemo.DTO;

import java.util.List;

import test.com.example.testDemo.Entity.Order;

public class OrderList {

    public List<OrderDto> orders;

    
    @Override
    public String toString() {
        String s = null;
        if(orders != null){
            for(int i=0;i<orders.size();i++){
                s+=orders.get(i).toString();
            }
        }
        return "OrderList [orders=" + s + "]";
    }

    public OrderList(){
        super();
    }
    public OrderList(List<OrderDto> orders) {
        super();
        this.orders = orders;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
    
    
}
