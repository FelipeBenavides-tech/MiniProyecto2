
package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear el GridPane para organizar los componentes
        GridPane grid = new GridPane();
        grid.setHgap(10);  // Espacio horizontal entre los componentes
        grid.setVgap(10);  // Espacio vertical entre los componentes
        grid.setPadding(new Insets(20, 20, 20, 20));  // Espaciado interno

        // Componentes de la interfaz
        Label userLabel = new Label("Usuario:");
        TextField userTextField = new TextField();
        Label passwordLabel = new Label("Contraseña:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Iniciar sesión");

        // Agregar los componentes al GridPane
        grid.add(userLabel, 0, 0);
        grid.add(userTextField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(new Label(), 0, 2);  // Espacio vacío
        grid.add(loginButton, 1, 3);

        // Acción del botón de login
        loginButton.setOnAction((ActionEvent e) -> {
            String username = userTextField.getText();
            String password = passwordField.getText();
            
            // Aquí deberías validar el login (puedes integrarlo con tu base de datos)
            if (username.equals("admin") && password.equals("1234")) {
                // Si es correcto, abre la ventana principal
                System.out.println("Login exitoso");
                // Aquí se puede abrir la pantalla principal, por ejemplo:
                new DashboardApp().start(new Stage());
                primaryStage.close(); // Cierra la ventana de login
            } else {
                // Si es incorrecto, muestra un mensaje de error
                showAlert("Error", "Credenciales incorrectas", Alert.AlertType.ERROR);
            }
        });

        // Crear la escena y configurar la ventana
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Login - Salón de Belleza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para mostrar alertas
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
