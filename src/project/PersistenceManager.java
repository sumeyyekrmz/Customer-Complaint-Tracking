/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.persistence.*;
/**
 *
 * @author LENOVO
 */
public class PersistenceManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeFactory() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
