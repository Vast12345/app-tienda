    package com.apptienda.app_tienda.domain.entities;

    import java.time.LocalDateTime;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import com.fasterxml.jackson.annotation.JsonIdentityInfo;
    import com.fasterxml.jackson.annotation.ObjectIdGenerators;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.Table;
    import lombok.Data;

    @Entity
    @Table(name="compras")
    @Data
    //@JsonIdentityInfo(
    //        generator = ObjectIdGenerators.PropertyGenerator.class,
    //        property = "id")
    public class Compra {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable=false, columnDefinition="datetime")
        private LocalDateTime fecha;
        @Column(columnDefinition="char(1)", name = "medio_pago")
        private String mediopago;
        @Column(length=300, nullable = false)
        private String comentario;
        @Column(nullable = false, columnDefinition = "char(1)")
        private boolean estado;

        @ManyToOne
        @JsonBackReference
        private Cliente cliente;
    }
