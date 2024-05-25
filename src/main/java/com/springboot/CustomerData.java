package com.springboot;

public class CustomerData {
    public String name;
    public String email;
    public int age;
  
    @Override
    public String toString() {
        return "Customer [name=" + name + ", email=" + email + ", age=" + age + "]";
    }
    public CustomerData(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public CustomerData() {
    }
    
}
