package test.com.example.testDemo.Repository;

import test.com.example.testDemo.Entity.Medicine;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMed extends MongoRepository<Medicine, String>{

    Medicine findBycUniqueCode(String id);
    
}
