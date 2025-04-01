
package controller;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageServicesApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear la tabla de servicios
        TableView<Service> table = new TableView<>();
        TableColumn<Service, String> nameColumn = new TableColumn<>("Servicio");
        TableColumn<Service, String> priceColumn = new TableColumn<>("Precio");

        // Configurar las columnas
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

        // Agregar las columnas a la tabla
        table.getColumns().add(nameColumn);
        table.getColumns().add(priceColumn);

        // Agregar datos a la tabla
        table.getItems().addAll(
                new Service("Corte de Cabello", "$10"),
                new Service("Tratamiento Capilar", "$20")
        );

        // Botón para agregar un nuevo servicio
        Button addButton = new Button("Agregar Servicio");

        // Layout principal
        VBox vbox = new VBox(10, table, addButton);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Gestionar Servicios");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Clase de datos para el servicio
    public static class Service {
        private final StringProperty name = new SimpleStringProperty();
        private final StringProperty price = new SimpleStringProperty();

        public Service(String name, String price) {
            this.name.set(name);
            this.price.set(price);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public StringProperty priceProperty() {
            return price;
        }
    }
}
