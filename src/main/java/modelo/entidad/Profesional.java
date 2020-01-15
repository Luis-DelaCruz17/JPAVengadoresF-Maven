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
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p")
    , @NamedQuery(name = "Profesional.findByCodprof", query = "SELECT p FROM Profesional p WHERE p.codprof = :codprof")
    , @NamedQuery(name = "Profesional.findByTipprof", query = "SELECT p FROM Profesional p WHERE p.tipprof = :tipprof")
    , @NamedQuery(name = "Profesional.findByPreprof", query = "SELECT p FROM Profesional p WHERE p.preprof = :preprof")
    , @NamedQuery(name = "Profesional.findByEstprof", query = "SELECT p FROM Profesional p WHERE p.estprof = :estprof")})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODPROF")
    private BigDecimal codprof;
    @Size(max = 100)
    @Column(name = "TIPPROF")
    private String tipprof;
    @Size(max = 10)
    @Pattern(regexp = "[0-9]+",message = "Sólo se permiten números")
    @Column(name = "PREPROF", length = 5)
    private String preprof;
    @Size(max = 1)
    @Column(name = "ESTPROF", length = 1)
    private String estprof;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprof")
    private List<Servicio> servicioList;

    public Profesional() {
    }

    public Profesional(BigDecimal codprof) {
        this.codprof = codprof;
    }

    public BigDecimal getCodprof() {
        return codprof;
    }

    public void setCodprof(BigDecimal codprof) {
        this.codprof = codprof;
    }

    public String getTipprof() {
        return tipprof;
    }

    public void setTipprof(String tipprof) {
        this.tipprof = tipprof;
    }

    public String getPreprof() {
        return preprof;
    }

    public void setPreprof(String preprof) {
        this.preprof = preprof;
    }

    public String getEstprof() {
        return estprof;
    }

    public void setEstprof(String estprof) {
        this.estprof = estprof;
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
        hash += (codprof != null ? codprof.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.codprof == null && other.codprof != null) || (this.codprof != null && !this.codprof.equals(other.codprof))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesional{" + "codprof=" + codprof + ", tipprof=" + tipprof + ", preprof=" + preprof + ", estprof=" + estprof + ", servicioList=" + servicioList + '}';
    }

    
    
}
