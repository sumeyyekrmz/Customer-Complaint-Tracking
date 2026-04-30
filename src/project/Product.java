package project;

import java.io.Serializable;
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
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    private boolean active;

    public Product() {
    }

    public Product(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
        this.active = true;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;  // Combobox'ta ürün adı görünür
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public static List<Product> findByBrandId(EntityManager em, int brandId) {
        return em.createQuery(
                "SELECT p FROM Product p WHERE p.brand_id = :brand_id", Product.class)
                .setParameter("brand_id", brandId)
                .getResultList();

    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }
}
