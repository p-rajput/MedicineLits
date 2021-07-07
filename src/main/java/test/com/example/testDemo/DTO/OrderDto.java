package test.com.example.testDemo.DTO;

public class OrderDto {
    
    private String c_name;
    
    private String quantity;
  
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
