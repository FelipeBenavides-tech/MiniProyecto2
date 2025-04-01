
package com.mycompany.salondebelleza;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SalonDeBelleza extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un GridPane para organizar los componentes
        GridPane grid = new GridPane();
        grid.setHgap(10); // Espaciado horizontal
        grid.setVgap(10); // Espaciado vertical
        grid.setPadding(new Insets(20, 20, 20, 20)); // Padding en el contorno

        // Crear los componentes
        Label userLabel = new Label("Usuario:");
        TextField userTextField = new TextField();
        Label passwordLabel = new Label("Contraseña:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Iniciar sesión");
        Label errorLabel = new Label(); // Label para errores

        // Agregar los componentes al GridPane
        grid.add(userLabel, 0, 0);
        grid.add(userTextField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(errorLabel, 1, 3);

        // Acción del botón de login
        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = passwordField.getText();

            // Aquí deberías validar las credenciales con tu base de datos
            if (username.equals("admin") && password.equals("1234")) {
                errorLabel.setText("");  // Limpiar error
                openDashboardApp(primaryStage);  // Abrir la pantalla principal
            } else {
                errorLabel.setText("Credenciales incorrectas");
            }
        });

        // Configuración de la escena y la ventana principal
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Login - Salón de Belleza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Función para abrir el Dashboard después de login exitoso
    private void openDashboardApp(Stage primaryStage) {
        // Aquí llamamos al método para abrir la pantalla principal (Dashboard)
        DashboardApp dashboardApp;
        dashboardApp = new DashboardApp();
        dashboardApp.start(primaryStage); // Cerrar la ventana de login
    }

    public static void main(String[] args) {
        launch(args);
    }
}
