
import java.time.LocalDate;
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
public class Complaint {
    public static ArrayList<Complaint> allComplaints = new ArrayList<>();
    private final Customer customer;
    private final String brand;
    private final String productId;
    private final String subject;
    private String detail;
    private String status;
    private ArrayList<String> solutions;
    private CustomerRepresentative rep;
    private final LocalDate date;
    private String objection;
    private boolean active;
    
    // Constructors
    public Complaint(Customer customer, String brand, String productId, String subject, String detail, boolean active){
        this.customer = customer;
        this.brand = brand;
        this.productId = productId;
        this.subject = subject;
        this.detail = detail;
        this.status = "Created";
        this.date = LocalDate.now();
        this.active = true;
        solutions = new ArrayList<>();
    }
    
    // Getter methods
    public Customer getCustomer() {
        return customer;
    }
    public String getBrand(){
        return brand;
    }
    public String getProductId(){
        return productId;
    }    
    public String getSubject(){
        return subject;
    }    
    public String getDetail(){
        return detail;
    }   
    public String getStatus(){
        return status;
    }
    public ArrayList<String> getSolutions(){
        return solutions;
    }
    public CustomerRepresentative getRep(){
        return rep;
    }
    public LocalDate getDate(){
        return date;
    } 
    public String getObjection(){
        return objection;
    }
    public boolean getActive(){
        return active;
    }
    
    // Setter methods
    public void setDetail(String detail){
        this.detail = detail;
    }
    public void setStatus(String status){
        this.status = status;
    }
        
    public void setSolutions(ArrayList<String> solutions){
        this.solutions = solutions;
    }
    public void setRep(CustomerRepresentative rep){
        this.rep = rep;
    }
    public void setObjection(String objection){
        this.objection = objection;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    
    public void addSolution(String solution) {
        solutions.add(solution);
    }
}
