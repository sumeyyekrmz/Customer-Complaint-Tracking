package project;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
@Entity
@DiscriminatorValue("Customer")
public class Customer extends User implements Serializable{
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Complaint> complaints = new ArrayList<>();
    
    public Customer(){}
    
    public Customer(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active){
        super(firstName, lastName, email, password, phoneNumber, "Customer", active);
  
    }

    
    public void addComplaint(Complaint complaint){
        complaints.add(complaint);
    }
    
    public List<Complaint> getComplaints(){
        return complaints;
    } 

 public void setId(int id){
     super.setId(id);
 }
   
}

