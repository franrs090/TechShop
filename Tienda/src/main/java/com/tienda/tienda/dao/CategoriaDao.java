package com.tienda.tienda.dao;

import com.tienda.tienda.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
