
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Customer extends User{
    public ArrayList<Complaint> complaints = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    
    public Customer(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active){
        super(firstName, lastName, email, password, phoneNumber, "Customer", active);
        customers.add(this);
    }

    
    public void addComplaint(Complaint complaint){
        complaints.add(complaint);
    }
    
    public ArrayList<Complaint> getComplaints(){
        return complaints;
    } 
}

