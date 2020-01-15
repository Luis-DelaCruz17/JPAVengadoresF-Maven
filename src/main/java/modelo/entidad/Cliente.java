/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(catalog = "", schema = "VENGF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodclie", query = "SELECT c FROM Cliente c WHERE c.codclie = :codclie")
    , @NamedQuery(name = "Cliente.findByNombclie", query = "SELECT c FROM Cliente c WHERE c.nombclie = :nombclie")
    , @NamedQuery(name = "Cliente.findByEstclie", query = "SELECT c FROM Cliente c WHERE c.estclie = :estclie")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODCLIE")
    private BigDecimal codclie;
    @Size(max = 50)
    @Pattern(regexp = "[A-Z a-z]+",message = "Sólo se permiten letras")
    @Column(name = "NOMBCLIE", length = 50)
    private String nombclie;
    @Size(max = 1)
    @Column(name = "ESTCLIE", length = 1)
    private String estclie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codclie")
    private List<Servicio> servicioList;

    public Cliente() {
    }

    public Cliente(BigDecimal codclie) {
        this.codclie = codclie;
    }

    public BigDecimal getCodclie() {
        return codclie;
    }

    public void setCodclie(BigDecimal codclie) {
        this.codclie = codclie;
    }

    public String getNombclie() {
        return nombclie;
    }

    public void setNombclie(String nombclie) {
        this.nombclie = nombclie;
    }

    public String getEstclie() {
        return estclie;
    }

    public void setEstclie(String estclie) {
        this.estclie = estclie;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclie != null ? codclie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codclie == null && other.codclie != null) || (this.codclie != null && !this.codclie.equals(other.codclie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codclie=" + codclie + ", nombclie=" + nombclie + ", estclie=" + estclie + ", servicioList=" + servicioList + '}';
    }

   
    
}
