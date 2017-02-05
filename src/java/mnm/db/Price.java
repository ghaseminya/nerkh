/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mnm
 */
@Entity
@Table(name = "price")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Price.findAll", query = "SELECT p FROM Price p"),
    @NamedQuery(name = "Price.findByIdprice", query = "SELECT p FROM Price p WHERE p.idprice = :idprice"),
    @NamedQuery(name = "Price.findByName", query = "SELECT p FROM Price p WHERE p.name = :name"),
    @NamedQuery(name = "Price.findBySell", query = "SELECT p FROM Price p WHERE p.sell = :sell"),
    @NamedQuery(name = "Price.findByBuy", query = "SELECT p FROM Price p WHERE p.buy = :buy"),
    @NamedQuery(name = "Price.findByTime", query = "SELECT p FROM Price p WHERE p.time = :time"),
    @NamedQuery(name = "Price.findByPerTime", query = "SELECT p FROM Price p WHERE p.perTime = :perTime")})
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprice")
    private Integer idprice;
    @Column(name = "name")
    private String name;
    @Column(name = "sell")
    private String sell;
    @Column(name = "buy")
    private String buy;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "per_time")
    private String perTime;

    public Price() {
    }

    public Price(Integer idprice) {
        this.idprice = idprice;
    }

    public Integer getIdprice() {
        return idprice;
    }

    public void setIdprice(Integer idprice) {
        this.idprice = idprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPerTime() {
        return perTime;
    }

    public void setPerTime(String perTime) {
        this.perTime = perTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprice != null ? idprice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.idprice == null && other.idprice != null) || (this.idprice != null && !this.idprice.equals(other.idprice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mnm.db.Price[ idprice=" + idprice + " ]";
    }
    
}
