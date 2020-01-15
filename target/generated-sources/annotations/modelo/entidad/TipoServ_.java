package modelo.entidad;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidad.Servicio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T14:15:39")
@StaticMetamodel(TipoServ.class)
public class TipoServ_ { 

    public static volatile SingularAttribute<TipoServ, BigDecimal> codtipserv;
    public static volatile SingularAttribute<TipoServ, String> esttipserv;
    public static volatile SingularAttribute<TipoServ, String> subtipserv;
    public static volatile ListAttribute<TipoServ, Servicio> servicioList;
    public static volatile SingularAttribute<TipoServ, String> instipserv;
    public static volatile SingularAttribute<TipoServ, String> nomtipserv;
    public static volatile SingularAttribute<TipoServ, String> pretipserv;
    public static volatile SingularAttribute<TipoServ, String> bartipserv;

}