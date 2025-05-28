
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Admin extends User{
    private ArrayList<CustomerRepresentative> representatives;
    
    public Admin(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active) {
        super(firstName, lastName, email, password, phoneNumber, "Admin", active);
        this.representatives = new ArrayList<>();        
    }
    
    public void addCustomerRepresentative(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active, String assignedBrand){
        CustomerRepresentative newRep = new CustomerRepresentative(firstName, lastName, email, password, phoneNumber, "Representative", active, assignedBrand);
        representatives.add(newRep);
    }    
}
