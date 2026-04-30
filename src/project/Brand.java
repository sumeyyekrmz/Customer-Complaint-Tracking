package project;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;
import static project.PersistenceManager.getEntityManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean active;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public Brand() {
    }

    public Brand(String name, boolean active) {
        this.name = name;
        this.active = true;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;  // Combobox'ta isim gözükür ama seçince nesne alınır
    }

    public String getName() {
        return name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setBrand(this);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setBrand(null);
    }

    public static Brand findById(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Brand.class, id);
        } catch (IllegalArgumentException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Brand findByName(String name) {
        EntityManager em = PersistenceManager.getEntityManager();
        Brand brand = null;
        try {
            brand = em.createQuery("SELECT b FROM Brand b WHERE LOWER(b.name) = :name AND b.active = true", Brand.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            // Sonuç yoksa null dönebiliriz
            brand = null;
        } finally {
            em.close();
        }
        return brand;
    }

    void setId(int id) {
        this.id = id;
    }

}
