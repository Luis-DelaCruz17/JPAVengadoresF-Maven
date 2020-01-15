package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(catalog = "", schema = "VENGF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByCodserv", query = "SELECT s FROM Servicio s WHERE s.codserv = :codserv")
    , @NamedQuery(name = "Servicio.findByTotpreserv", query = "SELECT s FROM Servicio s WHERE s.totpreserv = :totpreserv")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODSERV")
    private BigDecimal codserv;
    @Size(max = 10)
    @Column(name = "TOTPRESERV")
    private String totpreserv;
    @JoinColumn(name = "CODCLIE", referencedColumnName = "CODCLIE")
    @ManyToOne(optional = false)
    private Cliente codclie;
    @JoinColumn(name = "CODPROF", referencedColumnName = "CODPROF")
    @ManyToOne(optional = false)
    private Profesional codprof;
    @JoinColumn(name = "CODTIPSERV", referencedColumnName = "CODTIPSERV")
    @ManyToOne(optional = false)
    private TipoServ codtipserv;

    @Transient
    private int Subtotal;

    public Servicio() {
    }

    public Servicio(BigDecimal codserv) {
        this.codserv = codserv;
    }

    public BigDecimal getCodserv() {
        return codserv;
    }

    public void setCodserv(BigDecimal codserv) {
        this.codserv = codserv;
    }

    public String getTotpreserv() {
        return totpreserv;
    }

    public void setTotpreserv(String totpreserv) {
        this.totpreserv = totpreserv;
    }

    public Cliente getCodclie() {
        return codclie;
    }

    public void setCodclie(Cliente codclie) {
        this.codclie = codclie;
    }

    public Profesional getCodprof() {
        return codprof;
    }

    public void setCodprof(Profesional codprof) {
        this.codprof = codprof;
    }

    public TipoServ getCodtipserv() {
        return codtipserv;
    }

    public void setCodtipserv(TipoServ codtipserv) {
        this.codtipserv = codtipserv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codserv != null ? codserv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.codserv == null && other.codserv != null) || (this.codserv != null && !this.codserv.equals(other.codserv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codserv=" + codserv + ", totpreserv=" + totpreserv + ", codclie=" + codclie + ", codprof=" + codprof + ", codtipserv=" + codtipserv + '}';
    }

    public int getSubtotal() {
        return Subtotal;
    }

    public void calculate() {
        double total = 0;
    
        if ("Si".equals(codtipserv.getInstipserv())) {
            total = ((((Double.valueOf(codtipserv.getPretipserv()) * Double.valueOf(codprof.getPreprof()) / 100)
                    + (Double.valueOf(codtipserv.getPretipserv()))) * 0.15) + (Double.valueOf(codtipserv.getPretipserv())));

        }
        else{
            total = ((Double.valueOf(codtipserv.getPretipserv()) * Double.valueOf(codprof.getPreprof()) / 100)
                    + (Double.valueOf(codtipserv.getPretipserv())));
        }
        this.setTotpreserv(String.valueOf(total));
        
    }
}
