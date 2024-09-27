package com.apptienda.app_tienda.infrastructure.repositories.compraproducto;

import com.apptienda.app_tienda.domain.entities.CompraProducto;
import com.apptienda.app_tienda.domain.entities.CompraProductoPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraProductoRepository extends CrudRepository<CompraProducto, CompraProductoPk> {

}
