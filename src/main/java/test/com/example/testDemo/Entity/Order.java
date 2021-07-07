package test.com.example.testDemo.Entity;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order")
public class Order {

    @NonNull
    private String c_name;
    @NonNull
    private String quantity;
    @NonNull
    private String cUniqueCode;

    @Override
    public String toString() {
        return "Order [cUniqueCode=" + cUniqueCode + ", c_name=" + c_name + ", quantity=" + quantity + "]";
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getcUniqueCode() {
        return cUniqueCode;
    }

    public void setcUniqueCode(String cUniqueCode) {
        this.cUniqueCode = cUniqueCode;
    }


}
