package com.tpjpa.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class detallePedido extends baseEntidad {
    private int cantidad;
    private double subtotal;
    @ManyToOne()
    @JoinColumn(name = "producto-id")
    private producto producto;

}
