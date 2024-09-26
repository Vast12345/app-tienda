package com.apptienda.app_tienda.infrastructure.repositories.categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apptienda.app_tienda.domain.entities.Categoria;

@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Long>{

}
