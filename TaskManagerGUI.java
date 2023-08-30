
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TaskManagerGUI extends Application {
    private TaskManager taskManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        taskManager = new TaskManager();

        primaryStage.setTitle("Task Manager Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);
        TextField usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText(), primaryStage));

        grid.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin(String username, String password, Stage primaryStage) {
        // Replace with your authentication logic
        if (username.equals("admin") && password.equals("password")) {
            showTaskManager(primaryStage);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }

    private void showTaskManager(Stage primaryStage) {
        primaryStage.close(); // Close the login window
        taskManager.showTaskManagerWindow(); // Open the main task manager window
    }
}

