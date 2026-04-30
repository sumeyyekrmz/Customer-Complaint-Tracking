package project;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
@Table(name = "complaints")
public class Complaint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private String subject;
    private String detail;
    private String status;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "complaint_solutions", joinColumns = @JoinColumn(name = "complaint_id"))
    @Column(name = "solution")
    private List<String> solutions;
    
    @ManyToOne
    @JoinColumn(name = "rep_id")
    private CustomerRepresentative rep;
    
    @Column(name = "complaint_date", nullable = false)
    private LocalDate date;
    private String objection;
    private boolean active;
    
    // Constructors
    public Complaint(){}
    
    public Complaint(Customer customer, Brand brand, Product product, String subject, String detail, boolean active){
        this.customer = customer;
        this.brand = brand;
        this.product = product;
        this.subject = subject;
        this.detail = detail;
        this.status = "Created";
        this.date = LocalDate.now();
        this.active = true;
        solutions = new ArrayList<>();
    }
    
    // Getter methods
    public int getId(){
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Brand getBrand(){
        return brand;
    }
    public Product getProduct(){
        return product;
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
    public List<String> getSolutions(){
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

    void setId(int id) {
        this.id = id;
    }

    void setDate(LocalDate date) {
        this.date = date;
    }
}
