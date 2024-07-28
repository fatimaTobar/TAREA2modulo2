package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.LibroDAOImpl;
import com.distribuida.entities.Libro;

public class PrincipalLibro {
	
	public static void main(String[] args) {
		// Cargar el contexto de Spring desde el archivo ApplicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// Obtener el bean del DAO de Libro
		LibroDAOImpl libroDAO = context.getBean("libroDAOImpl", LibroDAOImpl.class);
		
		// Ejemplo de operaciones CRUD
		
		// Agregar un nuevo libro
		Libro libro = new Libro(0, "ISBN-123456", "Título del Libro", 0, "Autor del Libro", null, null, null, null, null, 0, null, null, 29.99);
		libroDAO.add(libro);
		
		// Obtener y mostrar un libro por su ID
		Libro libroEncontrado = libroDAO.findOne(1);
		System.out.println("Libro encontrado por ID: " + libroEncontrado);
		
		// Actualizar un libro existente (descomentar si el método está implementado)
		// libroEncontrado.setPrecio(39.99);
		// libroDAO.up(libroEncontrado);
		
		// Eliminar un libro por su ID (descomentar si el método está implementado)
		// libroDAO.del(1);
		
		// Mostrar todos los libros
		System.out.println("Todos los libros:");
	
		// Cerrar el contexto de Spring
		context.close();
	}
}	