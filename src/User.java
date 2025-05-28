
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private boolean active;
    public static ArrayList<User> users = new ArrayList<>();
    
    public User(String firstName, String lastName, String email, String password, String phoneNumber, String role, boolean active){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.active = true;
        users.add(this);
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getRole(){
        return role;
    }
    public boolean getActive(){
        return active;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName; 
    }
    public void setLastName(String lastName){
        this.lastName = lastName; 
    }
    public void setEmail(String email){
        this.email = email; 
    }
    public void setPassword(String password){
        this.password = password; 
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }  
    public void setActive(boolean active){
        this.active = active;
    }
    
}
