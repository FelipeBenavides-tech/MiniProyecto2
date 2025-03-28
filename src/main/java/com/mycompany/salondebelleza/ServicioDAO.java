
package com.mycompany.salondebelleza;

public class ServicioDAO {
    public static void insertarServicios() {
        // Servicios de Corte
        insertarServicio("Corte Clásico", "Corte de cabello tradicional", 50000.0, "Corte");
        insertarServicio("Corte Desvanecido", "Corte de cabello desvanecido", 60000.0, "Corte");
        insertarServicio("Corte Pixie", "Corte corto tipo pixie.", 55000.0, "Corte");
        insertarServicio("Barbería (barba y bigote)", "Afeitado de barba y recorte de bigote.", 30000.0, "Corte");
        
        // Servicios de Tratamiento
        insertarServicio("Tratamiento Hidratación Profunda", "Tratamiento capilar de hidratación profunda", 80000.0, "Tratamiento Capilar");
        insertarServicio("Alisado", "Tratamiento para alisar el cabello.", 120000.0, "Tratamiento Capilar");
        insertarServicio("Tinte y Mechas", "Aplicación de tinte y mechas para cabello.", 100000.0, "Tratamiento Capilar");
        insertarServicio("Botánica Capilar", "Tratamiento capilar basado en productos naturales.", 95000.0, "Tratamiento Capilar");
        
        // Servicios Estéticos
        insertarServicio("Manicure y Pedicure", "Cuidado de uñas y pies", 45000.0, "Estética");
        insertarServicio("Depilación", "Depilación corporal con cera.", 50000.0, "Estética");
        insertarServicio("Maquillaje Profesional", "Maquillaje para eventos especiales", 70000.0, "Estética");
    }
    
    public static void insertarServicio(String nombre, String descripcion, double precio, String categoria) {
        String sql = "INSERT INTO servicios (nombre, descripcion, precio, categoria) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setDouble(3, precio);  
            stmt.setString(4, categoria);
            
            // Se utiliza para insertar un servicio
            stmt.executeUpdate();
            System.out.println("Servicio insertado correctamente: " + nombre);
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el servicio.");
            e.printStackTrace();
        }
    }
}
