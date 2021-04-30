package com.entities;

import com.entities.Producto;
import com.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-28T22:00:24")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, Integer> iDvendedor;
    public static volatile SingularAttribute<Vendedor, String> ciudad;
    public static volatile SingularAttribute<Vendedor, String> direccion;
    public static volatile SingularAttribute<Vendedor, Usuario> usuario;
    public static volatile SingularAttribute<Vendedor, Producto> producto;

}