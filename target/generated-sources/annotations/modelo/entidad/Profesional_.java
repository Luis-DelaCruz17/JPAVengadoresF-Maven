package modelo.entidad;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidad.Servicio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T14:15:39")
@StaticMetamodel(Profesional.class)
public class Profesional_ { 

    public static volatile SingularAttribute<Profesional, String> estprof;
    public static volatile SingularAttribute<Profesional, BigDecimal> codprof;
    public static volatile SingularAttribute<Profesional, String> tipprof;
    public static volatile SingularAttribute<Profesional, String> preprof;
    public static volatile ListAttribute<Profesional, Servicio> servicioList;

}