package com.apptienda.app_tienda.infrastructure.repositories.producto;

import com.apptienda.app_tienda.domain.entities.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

}
