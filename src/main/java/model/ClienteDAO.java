
package com.mycompany.salondebelleza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public static void insertarClientes() {
        insertarCliente("Juan", "Pérez", "juanperez@gmail.com", "3001234567", "Calle 123, Bogotá");
        insertarCliente("María", "Gómez", "mariagomez@gmail.com", "3007654321", "Avenida 45, Medellín");
        insertarCliente("Carlos", "Rodríguez", "carlosr@gmail.com", "3101234567", "Carrera 6, Cali");
    }

    public static void insertarCliente(String nombre, String apellido, String email, String telefono, String direccion) {
        String sql = "INSERT INTO clientes (nombre, apellido, email, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, email);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);
            
            // Insertamos al usuario
            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente: " + nombre + " " + apellido);
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente.");
            e.printStackTrace();
        }
    }
}
