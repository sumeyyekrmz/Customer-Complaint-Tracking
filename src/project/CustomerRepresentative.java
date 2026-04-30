package project;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
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
@Entity
@DiscriminatorValue("Representative")
public class CustomerRepresentative extends User implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "brand_id", nullable = true)
    private Brand assignedBrand;

    @OneToMany(mappedBy = "rep", cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    public static DefaultListModel<Brand> brandModel = new DefaultListModel<>();
    public static Complaint selectedComplaint;

    // Constructors
    public CustomerRepresentative() {
    }

    public CustomerRepresentative(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active, Brand assignedBrand) {
        super(firstName, lastName, email, password, phoneNumber, role, active);
        this.assignedBrand = assignedBrand;
        this.complaints = new ArrayList<>();
    }

    public Brand getAssignedBrand() {
        return assignedBrand;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setAssignedBrand(Brand assignedBrand) {
        this.assignedBrand = assignedBrand;
    }

    public void addComplaint(Complaint complaint) {
        if (complaint.getBrand().equals(this.assignedBrand)) {
            complaints.add(complaint);
        }
    }

    public void updateComplaintStatus(Complaint complaint, String newStatus) {
        complaint.setStatus(newStatus);
    }
}
