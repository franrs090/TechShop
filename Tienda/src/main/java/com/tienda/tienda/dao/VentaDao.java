package com.tienda.tienda.dao;

import com.tienda.tienda.Domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository <Venta,Long> {
     
}
