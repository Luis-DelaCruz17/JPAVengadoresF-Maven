package modelo.entidad;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidad.Servicio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-15T14:15:39")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> nombclie;
    public static volatile SingularAttribute<Cliente, String> estclie;
    public static volatile ListAttribute<Cliente, Servicio> servicioList;
    public static volatile SingularAttribute<Cliente, BigDecimal> codclie;

}