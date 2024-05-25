package com.springboot;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final CustomerRepository customerRepository;

    public Controller(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/api/v1/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("/api/v1/customers")
    public void postCustomer(@RequestBody CustomerData customerData){
        Customer customer = new Customer();
        customer.setAge(customerData.age);
        customer.setEmail(customerData.email);
        customer.setAge(customerData.age);
        customerRepository.save(customer);
    }

    @PutMapping("/api/v1/customers/{id}")
    public void putCustomer(@RequestBody CustomerData customerData, @PathVariable("id") Integer id){
        Customer customer = customerRepository.findById(id).get();
        customer.setAge(customerData.age);
        customer.setEmail(customerData.email);
        customer.setAge(customerData.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("api/v1/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerRepository.deleteById(id);
    }


    @GetMapping("/")
    public String greet(){
        return "Hii";
    }
}
