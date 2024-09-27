package com.apptienda.app_tienda.infrastructure.repositories.compra;

import com.apptienda.app_tienda.domain.entities.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends CrudRepository<Compra, Long> {

}
