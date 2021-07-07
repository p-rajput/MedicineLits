package test.com.example.testDemo.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface MedService {
    public void SaveMed(String file) throws IOException;
    
}
