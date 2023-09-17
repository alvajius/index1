package com.tpjpa.demo.entidades;

import com.tpjpa.demo.numeraciones.TipoProducto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class producto extends baseEntidad {
    private TipoProducto tipoproducto;
    private int tiempoEStimadoCocina;
    private String denominacion;
    private double precioVenta;
    private  double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;

}
