package modelo.entidad;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidad.Cliente;
import modelo.entidad.Profesional;
import modelo.entidad.TipoServ;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T14:15:39")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, TipoServ> codtipserv;
    public static volatile SingularAttribute<Servicio, String> totpreserv;
    public static volatile SingularAttribute<Servicio, BigDecimal> codserv;
    public static volatile SingularAttribute<Servicio, Profesional> codprof;
    public static volatile SingularAttribute<Servicio, Cliente> codclie;

}