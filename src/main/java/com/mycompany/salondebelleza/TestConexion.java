
package com.mycompany.salondebelleza;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        // Intentamos conectar a la base de datos
        Connection conn = ConexionDB.conectar();
        
        // Verificamos si la conexión fue exitosa
        if (conn != null) {
            System.out.println("¡Conexión exitosa a la base de datos!");
            
            try {
                // Intentamos cerrar la conexión después de usarla
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
}
