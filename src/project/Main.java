package project;

import java.util.List;
import javax.persistence.*;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Admin> query = em.createQuery(
                "SELECT a FROM Admin a", Admin.class);

            List<Admin> admins = query.getResultList();

            if (admins.isEmpty()) {
                Admin admin = new Admin();
                admin.setFirstName("Admin");
                admin.setLastName("User");
                admin.setEmail("admin@gmail.com");
                admin.setPassword("admin123");
                admin.setPhoneNumber("5550000000");
                admin.setActive(true);

                em.persist(admin);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
} 
