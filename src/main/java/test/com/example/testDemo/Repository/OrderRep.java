package test.com.example.testDemo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import test.com.example.testDemo.DTO.OrderList;
import test.com.example.testDemo.Entity.Order;
import test.com.example.testDemo.Entity.OrderListE;

@Repository
public interface OrderRep extends MongoRepository<OrderListE, String>{
    
}
