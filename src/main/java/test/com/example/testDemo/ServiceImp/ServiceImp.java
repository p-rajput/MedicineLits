package test.com.example.testDemo.ServiceImp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.example.testDemo.Entity.Medicine;
import test.com.example.testDemo.Repository.RepositoryMed;
import test.com.example.testDemo.Service.MedService;

@Service
public class ServiceImp implements MedService {

    @Autowired
    private RepositoryMed repo;

    @Override
    public void SaveMed(String file) throws IOException{
        //FileReader filereader;
        BufferedReader filereader;
        try {
            URL url = new URL(file);
		    URLConnection conn = url.openConnection();
		    System.out.println(conn.getContentType());
		    InputStream inputStream = conn.getInputStream();
		
		    filereader = new BufferedReader(new InputStreamReader(inputStream));
            //filereader = new FileReader("C:/Users/prabh/Downloads/sheet.csv");//C:\Users\prabh\Downloads\sheet.csv
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            int i=0,j=0;
            Map<Integer,String> header = new HashMap<Integer,String>(); 
            List<Medicine> medList = new ArrayList<Medicine>();

            while ((nextRecord = csvReader.readNext()) != null) {
                Medicine med = new Medicine();
                if(i==0){

                    for (String cell : nextRecord) {
                        header.put(j,cell);
                        j++;
                    }
                    
                }else{
                    j=0;
                    for(String cell : nextRecord){
                        if(header.get(j).equalsIgnoreCase("c_name")){
                            med.setC_name(cell);
                        } else if(header.get(j).equalsIgnoreCase("c_batch_no")){
                            med.setC_batch_no(cell);
                        } else if(header.get(j).equalsIgnoreCase("d_expiry_date")){
                            med.setD_expiry_date(cell);
                        }else if(header.get(j).equalsIgnoreCase("n_balance_qty")){
                            med.setN_balance_qty(cell);
                        }else if(header.get(j).equalsIgnoreCase("c_packaging")){
                            med.setC_packaging(cell);
                        }else if(header.get(j).equalsIgnoreCase("c_unique_code")){
                            med.setC_unique_code(cell);
                        }else if(header.get(j).equalsIgnoreCase("c_schemes")){
                            med.setC_schemes(cell);
                            if(i==3)System.out.println("cell sche "+cell);
                        }else if(header.get(j).equalsIgnoreCase("n_mrp")){
                            med.setN_mrp(cell);
                        }else if(header.get(j).equalsIgnoreCase("c_manufacturer")){
                            med.setC_manufacturer(cell);
                        }else if(header.get(j).equalsIgnoreCase("hsn_code")){
                            med.setHsn_code(cell);
                        }
                        j++;
                    }

                }
                i++;
                if(i==2 || i == 9)
                System.out.println("Med "+med.toString());
                medList.add(med);
            }
            repo.saveAll(medList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
}
