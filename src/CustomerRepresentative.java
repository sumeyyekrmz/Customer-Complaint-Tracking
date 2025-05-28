
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class CustomerRepresentative extends User{
    private String assignedBrand;
    private ArrayList<Complaint> complaints;
    public static ArrayList<CustomerRepresentative> representatives = new ArrayList<>();
    public static DefaultListModel<String> brandModel = new DefaultListModel<>();
    public static Complaint selectedComplaint;
    
    // Constructors
    public CustomerRepresentative(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active, String assignedBrand){
        super(firstName, lastName, email, password, phoneNumber, role, active);
        this.assignedBrand = assignedBrand;
        this.complaints = new ArrayList<>();
    }
    
    public String getAssignedBrand(){
        return assignedBrand;
    }
    public ArrayList<Complaint> getComplaints(){
        return complaints;
    }
    
    public void setAssignedBrand(String assignedBrand){
        this.assignedBrand = assignedBrand;
    }
    
    public void addComplaint(Complaint complaint){
        if(complaint.getBrand().equals(this.assignedBrand))
            complaints.add(complaint);
    }
    
    public void updateComplaintStatus(Complaint complaint, String newStatus){
        complaint.setStatus(newStatus);
    }  
}
