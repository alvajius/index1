package com.tpjpa.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class rubro extends baseEntidad {
    private String denominacion;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro-id")
    @Builder.Default
    private List<producto> productos = new ArrayList<>();

    public void agregarProducto(producto prod) {

        productos.add(prod);
    }

    public void mostrarProductos() {
        System.out.println("Los productos de este rubro son: ");
        for (producto producto : productos) {
            System.out.println("Denominacion: " + producto.getDenominacion() + ", Receta: " + producto.getReceta()
                    + ", Unidad Medida: " + producto.getUnidadMedida() + ", Precio Compra: " + producto.getPrecioCompra()
                    + ", Precio Venta: " + producto.getPrecioVenta() + ", Stock Actual: " + producto.getStockActual()
                    + ", Stock Min: " + producto.getStockMinimo() + ", Tiempo Estimado Cocina: " + producto.getTiempoEStimadoCocina()
                    + ", Tipo: " + producto.getTipoproducto());
        }
    }
}