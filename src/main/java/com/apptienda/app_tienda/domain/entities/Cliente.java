package com.apptienda.app_tienda.domain.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=40, nullable=false)
    @NotEmpty
    private String nombre;

    @Column(length = 100, nullable=false)
    @NotEmpty
    private String apellido;

    @Column(length=10, nullable = false, columnDefinition="Decimal(10,0)")
    private Float celular;

    @Column(length=80, nullable = false)
    @NotEmpty
    private String direccion;

    @Column(length=70, name="correo_electronico", nullable=false)
    @NotEmpty
    @Email
    private String correoelectronico;

    @OneToMany(mappedBy="cliente")
    @JsonManagedReference
    private Set<Compra> compras;
}
