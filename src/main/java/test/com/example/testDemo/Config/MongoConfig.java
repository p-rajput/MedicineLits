package test.com.example.testDemo.Config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    public static MongoClient mongoClient;
    public static MongoTemplate mongoTemplate;

    public static @Bean MongoClient mongoClient() {
        System.out.println("Connecting to DB");
        if(mongoClient==null){
        mongoClient = MongoClients.create("mongodb+srv://admin:Prabhat@buildout-qa.ef4zv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        System.out.println("Connected to DB");}
        return mongoClient;
    }
  
    public static @Bean MongoTemplate mongoTemplate() {
        if(mongoTemplate==null){
        mongoTemplate = new MongoTemplate(mongoClient(), "test");
        System.out.println("Connected to MongoTemplate");}
        return mongoTemplate;
    }
    
}
