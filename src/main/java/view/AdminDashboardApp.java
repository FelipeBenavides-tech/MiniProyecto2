package view;




import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;



public class DashboardApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear el panel principal con un VBox
        VBox vbox = new VBox(20);  // Espaciado entre los componentes

        // Crear los botones para las diferentes funcionalidades
        Button addUserButton = new Button("Agregar Nuevo Usuario");
        Button addHairdresserButton = new Button("Agregar Nuevo Peluquero");
        Button clientHistoryButton = new Button("Historial de Clientes");
        Button inventoryButton = new Button("Manejo de Inventario");
        Button machineMaintenanceButton = new Button("Registro de Máquinas y Mantenimiento");

        // Añadir funcionalidad a cada botón
        addUserButton.setOnAction(e -> showAddUserForm());
        addHairdresserButton.setOnAction(e -> showAddHairdresserForm());
        clientHistoryButton.setOnAction(e -> showClientHistory());
        inventoryButton.setOnAction(e -> showInventoryManagement());
        machineMaintenanceButton.setOnAction(e -> showMachineMaintenance());

        // Agregar los botones al VBox
        vbox.getChildren().addAll(addUserButton, addHairdresserButton, clientHistoryButton, inventoryButton, machineMaintenanceButton);

        // Configurar la escena y la ventana principal
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Pantalla Administrador - Salón de Belleza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        private void showAddUserForm() {
            Stage stage = new Stage();
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 20, 20, 20));

            Label nameLabel = new Label("Nombre:");
            TextField nameField = new TextField();
            Label emailLabel = new Label("Correo Electrónico:");
            TextField emailField = new TextField();
            Label userTypeLabel = new Label("Tipo de Usuario:");
            ComboBox<String> userTypeCombo = new ComboBox<>();
            userTypeCombo.getItems().addAll("Administrador", "Peluquero", "Cliente");

            Button submitButton = new Button("Agregar Usuario");

            submitButton.setOnAction(e -> {
                // Aquí puedes guardar el nuevo usuario en la base de datos
                System.out.println("Usuario agregado: " + nameField.getText() + ", " + emailField.getText() + ", Tipo: " + userTypeCombo.getValue());
                stage.close();
            });

            grid.add(nameLabel, 0, 0);
            grid.add(nameField, 1, 0);
            grid.add(emailLabel, 0, 1);
            grid.add(emailField, 1, 1);
            grid.add(userTypeLabel, 0, 2);
            grid.add(userTypeCombo, 1, 2);
            grid.add(submitButton, 1, 3);

            Scene scene = new Scene(grid, 300, 200);
            stage.setTitle("Agregar Nuevo Usuario");
            stage.setScene(scene);
            stage.show();
        }

    }

        private void showAddHairdresserForm() {
         Stage stage = new Stage();
         GridPane grid = new GridPane();
         grid.setHgap(10);
         grid.setVgap(10);
         grid.setPadding(new Insets(20, 20, 20, 20));

         Label nameLabel = new Label("Nombre:");
         TextField nameField = new TextField();
         Label specialtyLabel = new Label("Especialidad:");
         TextField specialtyField = new TextField();
         Label availabilityLabel = new Label("Disponibilidad:");
         TextField availabilityField = new TextField();

         Button submitButton = new Button("Agregar Peluquero");

         submitButton.setOnAction(e -> {
             // Aquí puedes guardar el nuevo peluquero en la base de datos
             System.out.println("Peluquero agregado: " + nameField.getText() + ", Especialidad: " + specialtyField.getText());
             stage.close();
         });

         grid.add(nameLabel, 0, 0);
         grid.add(nameField, 1, 0);
         grid.add(specialtyLabel, 0, 1);
         grid.add(specialtyField, 1, 1);
         grid.add(availabilityLabel, 0, 2);
         grid.add(availabilityField, 1, 2);
         grid.add(submitButton, 1, 3);

         Scene scene = new Scene(grid, 300, 250);
         stage.setTitle("Agregar Nuevo Peluquero");
         stage.setScene(scene);
         stage.show();
     

    }

        private void showClientHistory() {
         Stage stage = new Stage();
         TableView<Client> table = new TableView<>();

         TableColumn<Client, String> nameColumn = new TableColumn<>("Nombre");
         TableColumn<Client, String> servicesColumn = new TableColumn<>("Servicios Previos");
         TableColumn<Client, String> preferencesColumn = new TableColumn<>("Preferencias");

         // Aquí puedes agregar las propiedades de cada columna de la tabla
         table.getColumns().addAll(nameColumn, servicesColumn, preferencesColumn);

         // Agregar datos de ejemplo
         table.getItems().add(new Client("Juan Pérez", "Corte de cabello, Tratamiento capilar", "Corte corto"));
         table.getItems().add(new Client("Ana Gómez", "Corte, Manicura", "Corte largo"));

         VBox vbox = new VBox(table);
         Scene scene = new Scene(vbox, 400, 300);
         stage.setTitle("Historial de Clientes");
         stage.setScene(scene);
         stage.show();
     }

     // Clase Client (modelo para el historial)
     public class Client {
         private final StringProperty name;
         private final StringProperty services;
         private final StringProperty preferences;

         public Client(String name, String services, String preferences) {
             this.name = new SimpleStringProperty(name);
             this.services = new SimpleStringProperty(services);
             this.preferences = new SimpleStringProperty(preferences);
         }

         public StringProperty nameProperty() {
             return name;
         }

         public StringProperty servicesProperty() {
             return services;
         }

         public StringProperty preferencesProperty() {
             return preferences;
         }
     }


        private void showInventoryManagement() {
         Stage stage = new Stage();
         TableView<Product> table = new TableView<>();

         TableColumn<Product, String> nameColumn = new TableColumn<>("Producto");
         TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Cantidad");
         TableColumn<Product, Double> priceColumn = new TableColumn<>("Precio");

         table.getColumns().addAll(nameColumn, quantityColumn, priceColumn);

         // Agregar datos de ejemplo
         table.getItems().add(new Product("Shampoo", 10, 15.99));
         table.getItems().add(new Product("Acondicionador", 5, 12.50));

         VBox vbox = new VBox(table);
         Scene scene = new Scene(vbox, 400, 300);
         stage.setTitle("Gestión de Inventario");
         stage.setScene(scene);
         stage.show();
     }

        // Clase Product (modelo para los productos)
        public class Product {
            private final StringProperty name;
            private final IntegerProperty quantity;
            private final DoubleProperty price;

            public Product(String name, int quantity, double price) {
                this.name = new SimpleStringProperty(name);
                this.quantity = new SimpleIntegerProperty(quantity);
                this.price = new SimpleDoubleProperty(price);
            }

            public StringProperty nameProperty() {
                return name;
            }

            public IntegerProperty quantityProperty() {
                return quantity;
            }

            public DoubleProperty priceProperty() {
                return price;
            }
        }


            private void showMachineMaintenance() {
            Stage stage = new Stage();
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 20, 20, 20));

            Label machineNameLabel = new Label("Nombre de la Máquina:");
            TextField machineNameField = new TextField();
            Label maintenanceDateLabel = new Label("Fecha de Mantenimiento:");
            DatePicker maintenanceDatePicker = new DatePicker();

            Button submitButton = new Button("Registrar Máquina");

            submitButton.setOnAction(e -> {
                System.out.println("Máquina registrada: " + machineNameField.getText() + ", Fecha: " + maintenanceDatePicker.getValue());
                stage.close();
            });

            grid.add(machineNameLabel, 0, 0);
            grid.add(machineNameField, 1, 0);
            grid.add(maintenanceDateLabel, 0, 1);
            grid.add(maintenanceDatePicker, 1, 1);
            grid.add(submitButton, 1, 2);

            Scene scene = new Scene(grid, 300, 200);
            stage.setTitle("Registrar Máquina y Mantenimiento");
            stage.setScene(scene);
            stage.show();
        }


    public static void main(String[] args) {
        
    }

