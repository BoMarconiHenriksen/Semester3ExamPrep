
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Bo
 */
@Entity
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    
    //I forhold til 1 til * mellem ItemType og OrderLine
    //mappedBy = "owner" attributen specificer at 'private Employee owner;' i Ordre 
    // "ejer" relation dvs har f.k. i forhold til at finde alle ordre for en Customer.
    @OneToMany(mappedBy = "itemType")
    private List<OrderLine> orderLinesByItemTypes = new ArrayList();

    public ItemType(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public ItemType() {
        
    }

    public List<OrderLine> getOrderLinesByItemTypes() {
        return orderLinesByItemTypes;
    }

    public void setOrderLinesByItemTypes(List<OrderLine> orderLinesByItemTypes) {
        this.orderLinesByItemTypes = orderLinesByItemTypes;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemType)) {
            return false;
        }
        ItemType other = (ItemType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemType{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", orderLinesByItemTypes=" + orderLinesByItemTypes + '}';
    }

          
    
}