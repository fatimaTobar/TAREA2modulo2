package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

public class PrincipalCliente {
    
    public static void main(String[] args) {
        // Load Spring context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        
        // Retrieve beans from context
        ClienteDAO clienteDAO = context.getBean("clienteDAOImpl", ClienteDAO.class);
        
        // CRUD operations
        
        // Create new cliente
        Cliente cliente = new Cliente(0, "John Doe", "john.doe@example.com", "123-456-7890", null, null, null);
        clienteDAO.add(cliente);
        
        // Update existing cliente
        Cliente clienteToUpdate = new Cliente(1, "Jane Doe", "jane.doe@example.com", "098-765-4321", null, null, null);
        //clienteDAO.up(clienteToUpdate);  // Uncomment to update
        
        // Delete cliente
        //clienteDAO.del(1);  // Uncomment to delete
        
        // Find and print specific cliente
        try {
            System.out.println("********** FIND ONE ********** " + clienteDAO.findOne(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Find and print all clientes
        clienteDAO.findAll().forEach(item -> {
            System.out.println(item.toString());
        });
        
        // Close context
        context.close();
    }
}
