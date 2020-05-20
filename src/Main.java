import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    Stage window = new Stage();
    Button btnEmployees;
    boolean answer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Bartar Accountant");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeApp();
        });
        btnEmployees = new Button();
        btnEmployees.setText("امور کارگران");
        btnEmployees.setOnAction(e -> new Modals().getNewEmployee());

        Button btnCustomers = new Button("امور مشتریان");
        btnCustomers.setOnAction(e -> {
            try {
                new ProjectsViewController().onGoingProjects();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        Button btnStorage = new Button("انبار وسایل");
        //TODO set Action

        VBox layout = new VBox(10);
        layout.getChildren().addAll(btnEmployees, btnCustomers, btnStorage);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void closeApp(){
        answer = new AlertMessage("Quit", "Are you sure?").display();
        if (answer)
            window.close();
    }
}
