package com.tpjpa.demo.entidades;

import com.tpjpa.demo.numeraciones.PagoFactura;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class factura extends baseEntidad{
    private int numero;
    private Date fecha;
    private double descuento;

    private PagoFactura pagofactura;
    private int total;





}
