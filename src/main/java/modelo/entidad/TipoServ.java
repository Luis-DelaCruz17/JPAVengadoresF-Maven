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
@Table(name = "TIPO_SERV", catalog = "", schema = "VENGF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServ.findAll", query = "SELECT t FROM TipoServ t")
    , @NamedQuery(name = "TipoServ.findByCodtipserv", query = "SELECT t FROM TipoServ t WHERE t.codtipserv = :codtipserv")
    , @NamedQuery(name = "TipoServ.findByNomtipserv", query = "SELECT t FROM TipoServ t WHERE t.nomtipserv = :nomtipserv")
    , @NamedQuery(name = "TipoServ.findBySubtipserv", query = "SELECT t FROM TipoServ t WHERE t.subtipserv = :subtipserv")
    , @NamedQuery(name = "TipoServ.findByPretipserv", query = "SELECT t FROM TipoServ t WHERE t.pretipserv = :pretipserv")
    , @NamedQuery(name = "TipoServ.findByEsttipserv", query = "SELECT t FROM TipoServ t WHERE t.esttipserv = :esttipserv")
    , @NamedQuery(name = "TipoServ.findByBartipserv", query = "SELECT t FROM TipoServ t WHERE t.bartipserv = :bartipserv")
    , @NamedQuery(name = "TipoServ.findByInstipserv", query = "SELECT t FROM TipoServ t WHERE t.instipserv = :instipserv")})
public class TipoServ implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODTIPSERV")
    private BigDecimal codtipserv;
    @Size(max = 100)
    @Pattern(regexp = "[A-Z a-z]+",message = "Sólo se permiten letras")
    @Column(name = "NOMTIPSERV")
    private String nomtipserv;
    @Size(max = 50)
    @Pattern(regexp = "[A-Z a-z]+",message = "Sólo se permiten letras")
    @Column(name = "SUBTIPSERV")
    private String subtipserv;
    @Size(max = 5)
    @Pattern(regexp = "[0-9]+",message = "Sólo se permiten números")
    @Column(name = "PRETIPSERV", length = 5)
    private String pretipserv;
    @Size(max = 7)
    @Column(name = "ESTTIPSERV", length = 7)
    private String esttipserv;
    @Size(max = 2)
    @Column(name = "BARTIPSERV", length = 2)
    private String bartipserv;
    @Size(max = 2)
    @Column(name = "INSTIPSERV", length = 2)
    private String instipserv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipserv")
    private List<Servicio> servicioList;

    public TipoServ() {
    }

    public TipoServ(BigDecimal codtipserv) {
        this.codtipserv = codtipserv;
    }

    public BigDecimal getCodtipserv() {
        return codtipserv;
    }

    public void setCodtipserv(BigDecimal codtipserv) {
        this.codtipserv = codtipserv;
    }

    public String getNomtipserv() {
        return nomtipserv;
    }

    public void setNomtipserv(String nomtipserv) {
        this.nomtipserv = nomtipserv;
    }

    public String getSubtipserv() {
        return subtipserv;
    }

    public void setSubtipserv(String subtipserv) {
        this.subtipserv = subtipserv;
    }

    public String getPretipserv() {
        return pretipserv;
    }

    public void setPretipserv(String pretipserv) {
        this.pretipserv = pretipserv;
    }

    public String getEsttipserv() {
        return esttipserv;
    }

    public void setEsttipserv(String esttipserv) {
        this.esttipserv = esttipserv;
    }

    public String getBartipserv() {
        return bartipserv;
    }

    public void setBartipserv(String bartipserv) {
        this.bartipserv = bartipserv;
    }

    public String getInstipserv() {
        return instipserv;
    }

    public void setInstipserv(String instipserv) {
        this.instipserv = instipserv;
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
        hash += (codtipserv != null ? codtipserv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServ)) {
            return false;
        }
        TipoServ other = (TipoServ) object;
        if ((this.codtipserv == null && other.codtipserv != null) || (this.codtipserv != null && !this.codtipserv.equals(other.codtipserv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoServ{" + "codtipserv=" + codtipserv + ", nomtipserv=" + nomtipserv + ", subtipserv=" + subtipserv + ", pretipserv=" + pretipserv + ", esttipserv=" + esttipserv + ", bartipserv=" + bartipserv + ", instipserv=" + instipserv + ", servicioList=" + servicioList + '}';
    }

    
}
