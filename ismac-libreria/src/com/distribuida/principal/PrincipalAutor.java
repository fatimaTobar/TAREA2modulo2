package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

public class PrincipalAutor {

    public static void main(String[] args) {
        // Cargar el contexto de Spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        // Obtener el bean AutorDAO del contexto
        AutorDAO autorDAO = context.getBean("autorDAOImpl", AutorDAO.class);

        // Operaciones CRUD con autores

        // Crear un nuevo autor
        Autor autor1 = new Autor(0, "Gabriel Garcia Marquez", "Colombiano", null, null, null, null);
        autorDAO.add(autor1);

        // Actualizar un autor existente
        Autor autor2 = new Autor(1, "Julio Cortazar", "Argentino", null, null, null, null);
        autorDAO.up(autor2);

        // Eliminar un autor por ID
        autorDAO.del(1);

        // Buscar y mostrar un autor por ID
        Autor autor3 = autorDAO.findOne(1);
        if (autor3 != null) {
            System.out.println("Autor encontrado: " + autor3);
        } else {
            System.out.println("Autor no encontrado.");
        }

        // Mostrar todos los autores
        System.out.println("Todos los autores:");
        autorDAO.findAll().forEach(System.out::println);

        // Cerrar el contexto de Spring
        context.close();
    }
}