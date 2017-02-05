/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.db;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mnm
 */
@Entity
@Table(name = "aiar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aiar.findAll", query = "SELECT a FROM Aiar a"),
    @NamedQuery(name = "Aiar.findByIdaiar", query = "SELECT a FROM Aiar a WHERE a.idaiar = :idaiar"),
    @NamedQuery(name = "Aiar.findByName", query = "SELECT a FROM Aiar a WHERE a.name = :name"),
    @NamedQuery(name = "Aiar.findByWeight", query = "SELECT a FROM Aiar a WHERE a.weight = :weight"),
    @NamedQuery(name = "Aiar.findByAiar", query = "SELECT a FROM Aiar a WHERE a.aiar = :aiar"),
    @NamedQuery(name = "Aiar.findByAiar2", query = "SELECT a FROM Aiar a WHERE a.aiar2 = :aiar2")})
public class Aiar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaiar")
    private Integer idaiar;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private String weight;
    @Column(name = "aiar")
    private String aiar;
    @Column(name = "aiar2")
    private String aiar2;

    public Aiar() {
    }

    public Aiar(Integer idaiar) {
        this.idaiar = idaiar;
    }

    public Integer getIdaiar() {
        return idaiar;
    }

    public void setIdaiar(Integer idaiar) {
        this.idaiar = idaiar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAiar() {
        return aiar;
    }

    public void setAiar(String aiar) {
        this.aiar = aiar;
    }

    public String getAiar2() {
        return aiar2;
    }

    public void setAiar2(String aiar2) {
        this.aiar2 = aiar2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaiar != null ? idaiar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aiar)) {
            return false;
        }
        Aiar other = (Aiar) object;
        if ((this.idaiar == null && other.idaiar != null) || (this.idaiar != null && !this.idaiar.equals(other.idaiar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mnm.db.Aiar[ idaiar=" + idaiar + " ]";
    }
    
}
