
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bo
 */
@Entity
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    
    //1 til * mellem Ordre og OrderLine
    //Ordre table indeholder IKKE en owner kolonne,
    //men en owner id_id kolonne med en foreign key. Og laver en join for at lazy fetche owner.
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    Ordre order;
    
    //1 til * mellem ItemType og OrderLine
    //Ordre table indeholder IKKE en owner kolonne,
    //men en owner id_id kolonne med en foreign key. Og laver en join for at lazy fetche owner.
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEMTYPE_ID")
    ItemType itemType;
    
    public OrderLine(int quantity) {
        this.quantity = quantity;
    }

    public OrderLine() {
        
    }

    public Ordre getOrder() {
        return order;
    }

    public void setOrder(Ordre order) {
        this.order = order;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof OrderLine)) {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderLine{" + "id=" + id + ", quantity=" + quantity + ", order=" + order + ", itemType=" + itemType + '}';
    }

           
    
}
