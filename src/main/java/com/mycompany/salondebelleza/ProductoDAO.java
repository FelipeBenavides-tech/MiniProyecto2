
package com.mycompany.salondebelleza;

public class ProductoDAO {
    public static void insertarProductos() {
        // Productos de cuidado capilar
        insertarProducto("Shampoo Hidratante", "Shampoo de hidratación profunda para cabellos secos", 30000.0, 50);  // 50 unidades en stock
        insertarProducto("Aceite Capilar Reparador", "Aceite capilar para reparación intensiva", 40000.0, 30); // 30 unidades en stock
        insertarProducto("Tinte Profesional", "Tinte capilar de alta calidad", 50000.0, 20);  // 20 unidades en stock
        
        // Herramientas de cuidado personal
        insertarProducto("Plancha de Pelo", "Plancha profesional para alisar el cabello", 180000.0, 10); // 10 unidades en stock
        insertarProducto("Secador de Pelo", "Secador de pelo profesional", 150000.0, 15);  // 15 unidades
        insertarProducto("Cepillo Desenredante", "Cepillo para desenredar el cabello", 25000.0, 25);  // 25 unidades 
    }
    
    public static void insertarProducto(String nombre, String descripcion, double precio, int stock) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setDouble(3, precio);  
            stmt.setInt(4, stock);
            
            // Insertar un producto o herramienta de trabajo
            stmt.executeUpdate();
            System.out.println("Producto insertado correctamente: " + nombre);
            
        } catch (SQLException e) {
            System.out.println("Error al insertar el producto.");
            e.printStackTrace();
        }
    }
}
