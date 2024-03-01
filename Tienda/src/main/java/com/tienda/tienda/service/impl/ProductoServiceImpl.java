package com.tienda.tienda.service.impl;

import com.tienda.tienda.Domain.Producto;
import com.tienda.tienda.dao.ProductoDao;
import com.tienda.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var productos = productoDao.findAll();
        if (activo) {
            productos.removeIf(e -> !e.isActivo());
        }
        return productos;
    }

    //Se obtiene una producto segun el id pasado por parametro
    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    //Se actualiza una producto o se inserta una nueva
    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    //Se borra una producto segun el id pasado de la producto
    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    //metodo para filtrar por precio, ordenado por descripcion
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaQuery(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
}
