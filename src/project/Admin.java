package project;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.persistence.*;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
@Entity
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable{

    
    public Admin(){}
    
    public Admin(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active) {
        super(firstName, lastName, email, password, phoneNumber, "Admin", active);
   
    }
    
    public void addCustomerRepresentative(EntityManager em, String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active, Brand assignedBrand){
        CustomerRepresentative newRep = new CustomerRepresentative(firstName, lastName, email, password, phoneNumber, "Representative", active, assignedBrand);
        em.persist(newRep);
    }    
}
