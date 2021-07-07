package test.com.example.testDemo.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class OrderListE {

    @Id
    private String id;
    private List<Order> ordersList;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Order> getOrdersList() {
        return ordersList;
    }
    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }
    @Override
    public String toString() {
        return "OrderListE [id=" + id + "]";
    }
    
}
