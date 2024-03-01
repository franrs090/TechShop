package com.tienda.tienda.dao;

import com.tienda.tienda.Domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}
