/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author c0611751
 */
@Entity
public class Product implements Serializable {
    @Id
     @Column(name = "id")
  @GeneratedValue
    private int productId;
    private String name;
    private String description;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String name, String description, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
    
    

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public JsonValue toJSON() {
        return Json.createObjectBuilder()
                .add("ProductID", productId)
                .add("Name", name)
                .add("Description", description)
                .add("Quantity", quantity)
                .build();
    }
    
    
    
   
}
