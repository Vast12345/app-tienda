package com.apptienda.app_tienda.infrastructure.repositories.compra;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apptienda.app_tienda.application.services.ICompraService;
import com.apptienda.app_tienda.domain.entities.Compra;

@Service
public class CompraImpl implements ICompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Transactional
    @Override
    public List<Compra> findAll() {
        return (List<Compra>) compraRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Compra> findById(Long id) {
        return compraRepository.findById(id);
    }

    @Transactional
    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    @Transactional
    @Override
    public Optional<Compra> update(Long id, Compra compra) {
        Optional<Compra> compraOld = compraRepository.findById(id);
        if(compraOld.isPresent()) {
            Compra compraDb = compraOld.orElseThrow();

            compraDb.setFecha(compra.getFecha());
            compraDb.setMediopago(compra.getMediopago());
            compraDb.setComentario(compra.getComentario());
            compraDb.setEstado(compra.isEstado());

            return Optional.of(compraRepository.save(compraDb));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Compra> delete(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        compra.ifPresent(compraDb -> {
            compraRepository.delete(compraDb);
        });
        return compra;
    }
}
