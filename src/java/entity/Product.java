package entity;
// Generated Jan 16, 2021 4:12:56 PM by Hibernate Tools 4.3.1



/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private Integer id;
     private Category category;
     private String productName;
     private String description;
     private Double price;
     private String img;

    public Product() {
    }

    public Product(Category category, String productName, String description, Double price, String img) {
       this.category = category;
       this.productName = productName;
       this.description = description;
       this.price = price;
       this.img = img;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", category=" + category + ", productName=" + productName + ", description=" + description + ", price=" + price + ", img=" + img + '}';
    }




}

