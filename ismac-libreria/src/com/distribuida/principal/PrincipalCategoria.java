package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.entities.Categoria;

public class PrincipalCategoria {
    
    public static void main(String[] args) {
        // Load Spring context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        // Retrieve beans from context
        CategoriaDAO categoriaDAO = context.getBean("categoriaDAOImpl", CategoriaDAO.class);
        
        // CRUD operations
        
        // Create new categoria
        Categoria categoria = new Categoria(0, "Categoria1", "Description1");
        categoriaDAO.add(categoria);
        
        // Update existing categoria (commented out)
        Categoria categoria2 = new Categoria(1, "Updated Categoria", "Updated Description");
        // categoriaDAO.up(categoria2);  // Uncomment to update
        
        // Delete categoria (commented out)
        // categoriaDAO.del(1);  // Uncomment to delete
        
        // Find and print specific categoria
        try {
            System.out.println("********** FIND ONE ********** " + categoriaDAO.findOne(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Find and print all categorias
        categoriaDAO.findAll().forEach(item -> {
            System.out.println(item.toString());
        });
        
        // Close context
        context.close();
    }
}