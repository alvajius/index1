package com.tpjpa.demo.entidades;

import com.tpjpa.demo.numeraciones.Estado;
import com.tpjpa.demo.numeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class pedido extends baseEntidad {
private Estado estadopedido;
private Date fecha;
private TipoEnvio tipoenvio;

private double total;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER) //Es necesario agregar el parametro de "FetchType.EAGER"
    @JoinColumn(name = "Pedido-id")
    @Builder.Default
    private List<detallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(detallePedido detallePedidoed){

        detallePedidos.add(detallePedidoed);
    }

    public detallePedido[] getDetallePedidos() {
        return new detallePedido[0];
    }
}
