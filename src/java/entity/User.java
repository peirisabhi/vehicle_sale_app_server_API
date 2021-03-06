package entity;
// Generated Jan 16, 2021 4:12:56 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private int id;
     private String name;
     private String email;
     private String password;
     private Byte status;
     private Date createdAt;

    public User() {
    }

	
    public User(int id) {
        this.id = id;
    }
    public User(int id, String name, String email, String password, Byte status, Date createdAt) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.password = password;
       this.status = status;
       this.createdAt = createdAt;
    }

    public User(String name, String email, String password, Byte status, Date createdAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.createdAt = createdAt;
    }
    
    
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Byte getStatus() {
        return this.status;
    }
    
    public void setStatus(Byte status) {
        this.status = status;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }




}


