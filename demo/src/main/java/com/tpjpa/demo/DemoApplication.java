package com.tpjpa.demo;

import com.tpjpa.demo.entidades.*;
import com.tpjpa.demo.numeraciones.Estado;
import com.tpjpa.demo.numeraciones.PagoFactura;
import com.tpjpa.demo.numeraciones.TipoEnvio;
import com.tpjpa.demo.numeraciones.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tpjpa.demo.repositorios.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	rubroRepository rubroRepository;
	@Autowired
	clienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init(rubroRepository rubroRepository1, clienteRepository clienteRepository1){
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");
			//crear instancia rubro
			rubro rubro1 = rubro.builder()
					.denominacion("Hamburguesas")
					.build();
			//crear instancias de productos
			producto producto1 = producto.builder()
					.tiempoEStimadoCocina(60)
					.denominacion("Hamburguesa con Cheddar")
					.precioVenta(2000)
					.precioCompra(1200)
					.stockActual(50)
					.stockMinimo(3)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipoproducto(TipoProducto.insumo)
							.build();
			producto producto2 = producto.builder()
					.tiempoEStimadoCocina(60)
					.denominacion("Hamburguesa con Baccon")
					.precioVenta(2200)
					.precioCompra(1500)
					.stockActual(32)
					.stockMinimo(4)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipoproducto(TipoProducto.insumo)
					.build();
			//agregar productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			//guardar rubro
			rubroRepository.save(rubro1);
			//Crear instancia Cliente
			cliente cliente1 = cliente.builder()
					.nombre("Facundo")
					.apellido("Sampieri")
					.email("@mail")
					.telefono("telefono1")
					.build();
			//Crear instancia domicilio
			domicilio domicilio1 = domicilio.builder()
					.calle("San Martin")
					.numero("6538")
					.localidad("Lujan")
					.build();
			domicilio domicilio2 = domicilio.builder()
					.calle("Las Heras")
					.numero("1223")
					.localidad("Ciudad")
					.build();
			//agregar domicilios a cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			//Crear Instancia Detalle Pedido
			detallePedido detallePedido1 = detallePedido.builder()
					.cantidad(2)
					.subtotal(4000)
					.build();
			detallePedido detallePedido2 = detallePedido.builder()
					.cantidad(1)
					.subtotal(2200)
					.build();
			detallePedido detallePedido3 = detallePedido.builder()
					.cantidad(3)
					.subtotal(6000)
					.build();
			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-09";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);
			//Crear Instancia Pedido
			pedido pedido1 = pedido.builder()
					.fecha(fecha)
					.total(6200)
					.estadopedido(Estado.entregado)
					.tipoenvio(TipoEnvio.delivery)
					.build();
			pedido pedido2 = pedido.builder()
					.fecha(fecha)
					.total(6000)
					.estadopedido(Estado.entregado)
					.tipoenvio(TipoEnvio.delivery)
					.build();
			//Crear instancias de factura
			factura factura1 = factura.builder()
					.fecha(fecha)
					.total(5800)
					.numero(1)
					.descuento(400)
					.pagofactura(PagoFactura.efectivo)
					.build();
			factura factura2 = factura.builder()
					.fecha(fecha)
					.total(5400)
					.numero(2)
					.descuento(600)
					.pagofactura(PagoFactura.efectivo)
					.build();
			//Agregar detalles al pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);
			//agregar pedidos al cliente
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);
			//vincular el detalle pedido con el producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);
			//vincular factura con pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			//guardar cliente
			clienteRepository.save(cliente1);

			//recuperar objeto rubro desde la base de datos
			rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			//recuperar Cliente desde la base de Datos
			cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();

			}
		};
	}

}
