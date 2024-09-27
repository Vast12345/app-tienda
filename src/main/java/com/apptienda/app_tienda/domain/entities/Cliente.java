package com.apptienda.app_tienda.domain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=40, nullable=false)
    private String nombre;
    @Column(length = 100, nullable=false)
    private String apellido;
    @Column(length=10, nullable = false, columnDefinition="Decimal(10,0)")
    private Float celular;
    @Column(length=80, nullable = false)
    private String direccion;
    @Column(length=70, name="correo_electronico", nullable=false)
    private String correoelectronico;

    @OneToMany(mappedBy="cliente")
    private List<Compra> compras;
}
