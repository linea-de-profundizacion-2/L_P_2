package com.entities;

import com.entities.Vendedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-28T22:00:24")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Integer> iDProducto;
    public static volatile SingularAttribute<Producto, String> producto;
    public static volatile SingularAttribute<Producto, Integer> cantidadDisponible;
    public static volatile CollectionAttribute<Producto, Vendedor> vendedorCollection;

}