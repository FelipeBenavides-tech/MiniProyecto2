
package controller;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaymentApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear los componentes de pago
        Label label = new Label("Método de Pago");
        ComboBox<String> paymentMethods = new ComboBox<>();
        paymentMethods.getItems().addAll("Efectivo", "Tarjeta de Crédito", "Billetera Electrónica");

        Button payButton = new Button("Pagar");

        // Acción del botón de pago
        payButton.setOnAction(e -> {
            String selectedMethod = paymentMethods.getValue();
            System.out.println("Pago realizado con " + selectedMethod);
        });

        // Layout principal
        VBox vbox = new VBox(10, label, paymentMethods, payButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Realizar Pago");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
