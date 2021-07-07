package test.com.example.testDemo.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.com.example.testDemo.DTO.OrderList;
import test.com.example.testDemo.Entity.Medicine;
import test.com.example.testDemo.Entity.Order;
import test.com.example.testDemo.Entity.OrderListE;
import test.com.example.testDemo.Repository.OrderRep;
import test.com.example.testDemo.Repository.RepositoryMed;
import test.com.example.testDemo.Service.MedService;
import test.com.example.testDemo.Trie.TrieNode;
import test.com.example.testDemo.Trie.TrieStruct;

@RequestMapping("/v1/test")
@RestController
@CrossOrigin("*")
@Validated
public class Controller {

    @Autowired
    private MedService service;

    @Autowired
    private RepositoryMed repo;

    @Autowired
    private OrderRep orderRepo;

    @GetMapping("/uploadCSV")
    public void SaveInDb(@RequestParam("filePath")String filePath) throws IOException{
        service.SaveMed(filePath);


    }

    @GetMapping("/getMedicineDetail")
    public Medicine GetMed(@RequestParam("id")String id) throws IOException{
        Medicine md = repo.findBycUniqueCode(id);
        System.out.println("Id "+id);
        if(md != null)
        System.out.println("Md "+md.toString());
        return md;
    }

    @PostMapping(path = "/placeorder", consumes = "application/json")
    public String SaveOrder(@RequestBody Map<String,Object> orders){

        ObjectMapper oMapper = new ObjectMapper();
        OrderList oL = oMapper.convertValue(orders, OrderList.class);
        List<Order> orderList = new ArrayList<Order>();
        System.out.println("Order "+ oL.toString());

        for(int i=0;i<oL.getOrders().size();i++){
            Order order = oMapper.convertValue(oL.getOrders().get(i), Order.class);
            System.out.println("od "+order.toString());
            orderList.add(order);
        }
        OrderListE orderListE = new OrderListE();
        OrderListE orderListE1 = null;
        orderListE.setOrdersList(orderList);
        orderListE1 = orderRepo.save(orderListE);

        System.out.println("oe1 "+orderListE1.toString());
        return "OrderId "+orderListE1.getId();
    }

    @GetMapping("/searchMedicine")
    public Set<String>  getMedicine(@RequestParam("medicine") String medicine){
        List<String> medicines = null;
        System.out.println("MeS "+medicine);
        List<Medicine> allMedicine = repo.findAll();
        TrieStruct root = new TrieStruct();
        Set<String> ex = null;
        for(int i=0;i<allMedicine.size();i++){
            root.insert(allMedicine.get(i).getC_name());
        }
        ex = root.find(medicine);
        ex.forEach(s->System.out.println("Med "+s));
        return ex;
    }
    
}
