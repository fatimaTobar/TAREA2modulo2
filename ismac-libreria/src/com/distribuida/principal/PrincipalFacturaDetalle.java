package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.entities.FacturaDetalle;

public class PrincipalFacturaDetalle {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        FacturaDetalleDAO facturaDetalleDAO = context.getBean("facturaDetalleDAOImpl", FacturaDetalleDAO.class);
        
        // CRUD
        
        // Agregar un nuevo detalle de factura
        FacturaDetalle nuevoDetalle = new FacturaDetalle(32, 25, 0, 0);
        nuevoDetalle.setIdFacturaDetalle(5); // Asigna el ID de la factura correspondiente
        nuevoDetalle.setProducto("Producto A");
        nuevoDetalle.setCantidad(2);
        nuevoDetalle.setPrecioUnitario(10.5);
        facturaDetalleDAO.add(nuevoDetalle);
        
        // Actualizar un detalle de factura existente (descomentar si es necesario)
        /*
        FacturaDetalle detalleExistente = facturaDetalleDAO.findOne(1);
        if (detalleExistente != null) {
            detalleExistente.setCantidad(3);
            detalleExistente.setPrecioUnitario(12.0);
            facturaDetalleDAO.up(detalleExistente);
        }
        */
        
        // Eliminar un detalle de factura por su ID (descomentar si es necesario)
        /*
        facturaDetalleDAO.del(1);
        */
        
        // Mostrar un detalle de factura por su ID
        try {
            FacturaDetalle detalleEncontrado = facturaDetalleDAO.findOne(1);
            if (detalleEncontrado != null) {
                System.out.println("Detalle encontrado: " + detalleEncontrado);
            } else {
                System.out.println("No se encontró ningún detalle de factura con ID 1.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Mostrar todos los detalles de factura
        System.out.println("Lista de todos los detalles de factura:");
        facturaDetalleDAO.findAll().forEach(item -> {
            System.out.println(item);
        });
        
        context.close();
    }
}