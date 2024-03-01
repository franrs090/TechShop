package com.tienda.tienda.service;

import com.tienda.tienda.Domain.Categoria;
import java.util.List;

public interface CategoriaService {

    //Se obtiene un ArrayList con todas las categorias de la tabla 
    public List<Categoria> getCategorias(boolean activo);

    //Se obtiene una categoria segun el id pasado por parametro
    public Categoria getCategoria(Categoria categoria);
    
    //Se actualiza una categoria o se inserta una nueva
    public void save (Categoria categoria);
    
    //Se borra una categoria segun el id pasado de la categoria
    public void delete (Categoria categoria);
}
