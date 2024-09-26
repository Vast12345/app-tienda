package com.apptienda.app_tienda.infrastructure.repositories.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apptienda.app_tienda.application.services.ICategoriaService;
import com.apptienda.app_tienda.domain.entities.Categoria;

@Service
public class CategoriaImpl implements ICategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Transactional(readOnly=true)
    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    @Override
    public Optional<Categoria> update(Long id, Categoria categoria) {
        Optional<Categoria> categoriaOld = categoriaRepository.findById(id);
        if(categoriaOld.isPresent()) {
            Categoria categoriaDb = categoriaOld.orElseThrow();

            categoriaDb.setDescripcion(categoria.getDescripcion());
            categoriaDb.setEstado(categoria.isEstado());

            return Optional.of(categoriaRepository.save(categoriaDb));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Categoria> delete(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        categoria.ifPresent(categoriaDb -> {
            categoriaRepository.delete(categoriaDb);
        });
        return categoria;
    }

}
