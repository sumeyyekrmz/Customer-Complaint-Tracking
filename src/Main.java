
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
        Admin admin = new Admin("Sümeyye", "Kırmızı", "admin@gmail.com", "admin123", "5555555555", "Admin", true);
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        CustomerRepresentative.brandModel.addElement("other");
    }
} 
