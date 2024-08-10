package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Libro;
import com.distribuida.entities.Factura;

public class PrincipalFacturaDetalle {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        FacturaDetalleDAO facturaDetalleDAO = context.getBean("facturaDetalleDAOImpl", FacturaDetalleDAO.class);

        // CRUD
        
        // Agregar un nuevo detalle de factura
        try {
            FacturaDetalle nuevoDetalle = new FacturaDetalle();
            nuevoDetalle.setCantidad(2);
            nuevoDetalle.setSubtotal(21.0);

            // Aquí deberías proporcionar objetos válidos para 'libro' y 'factura'
            // Suponiendo que ya tienes instancias de Libro y Factura, por ejemplo:
            Libro libro = new Libro(); // Inicializa con datos reales
            Factura factura = new Factura(); // Inicializa con datos reales

            nuevoDetalle.setLibro(libro);
            nuevoDetalle.setFactura(factura);

            facturaDetalleDAO.add(nuevoDetalle);
            System.out.println("Detalle de factura agregado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Actualizar un detalle de factura existente
        /*
        try {
            FacturaDetalle detalleExistente = facturaDetalleDAO.findOne(1);
            if (detalleExistente != null) {
                detalleExistente.setCantidad(3);
                detalleExistente.setSubtotal(36.0);
                facturaDetalleDAO.update(detalleExistente);
                System.out.println("Detalle de factura actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningún detalle de factura con ID 1.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        
        // Eliminar un detalle de factura por su ID
        /*
        try {
            facturaDetalleDAO.delete(1);
            System.out.println("Detalle de factura eliminado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            System.out.println("Lista de todos los detalles de factura:");
            facturaDetalleDAO.findAll().forEach(item -> {
                System.out.println(item);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        context.close();
    }
}
