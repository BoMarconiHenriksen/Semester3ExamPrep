package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Bo
 */
@Entity
public class Ordre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int orderId;

    //Ordre table indeholder IKKE en owner kolonne,
    //men en owner id_id kolonne med en foreign key. Og laver en join for at lazy fetche owner.
    @ManyToOne//()//fetch = FetchType.LAZY
    @JoinColumn(name = "OWNER_ID")
    Customer owner;
    
    //I forhold til 1 til * mellem Ordre og OrderLine
    //mappedBy = "owner" attributen specificer at 'private Employee owner;' i Ordre 
    // "ejer" relation dvs har f.k. i forhold til at finde alle ordre for en Customer.
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines = new ArrayList();

    public Ordre(int orderId) {
        this.orderId = orderId;
    }

    public Ordre() {

    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof Ordre)) {
            return false;
        }
        Ordre other = (Ordre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordre{" + "id=" + id + ", orderId=" + orderId + ", owner=" + owner + '}';
    }

    
}
