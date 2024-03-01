package com.tienda.tienda.service;

import com.tienda.tienda.Domain.Producto;
import java.util.List;

public interface ProductoService {

    //Se obtiene un ArrayList con todas las productos de la tabla 
    public List<Producto> getProductos(boolean activo);

    //Se obtiene una producto segun el id pasado por parametro
    public Producto getProducto(Producto producto);
    
    //Se actualiza una producto o se inserta una nueva
    public void save (Producto producto);
    
    //Se borra una producto segun el id pasado de la producto
    public void delete (Producto producto);
    
    //metodo para filtrar por precio, ordenado por descripcion
    public List<Producto> consultaQuery(
            double precioInf, double precioSup);
    
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
    
    public List<Producto> consultaSQL(double precioInf, double precioSup);
}
