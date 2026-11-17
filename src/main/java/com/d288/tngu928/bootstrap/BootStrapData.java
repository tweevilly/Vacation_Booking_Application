package com.d288.tngu928.bootstrap;

import com.d288.tngu928.dao.CustomerRepository;
import com.d288.tngu928.dao.DivisionRepository;
import com.d288.tngu928.entities.Customer;
import com.d288.tngu928.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component      //registers this class as a Spring bean so the runner is picked up at startup
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String...args) throws Exception {

        long customerCount = customerRepository.count();
        if (customerCount < 6) {                //revised to add 5 customers

        Division division = divisionRepository.findAll().get(1);
        
        Customer customer1 = new Customer(
                "Amanda", "Benson", "1234 Apple Rd", "12345", "012-345-6789", division);

        Customer customer2 = new Customer(
                "Chelsea", "Smith", "5678 Oak St", "45678","444-222-3333", division);

        Customer customer3 = new Customer(
                "Brittany", "Larson", "5678 Oak St", "66666","011-234-5566", division);

        Customer customer4 = new Customer(
                "Eric", "Stone", "1213 Peach St", "55664","858-541-3636", division);

        Customer customer5 = new Customer(
                "George", "Tran", "1415 Cherry St", "56487","488-787-8978", division);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        }
    }

}
