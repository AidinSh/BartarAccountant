import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {

    Stage window = new Stage();
    Button button;
    Label label;
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
        button = new Button();
        button.setText("Employees");
        button.setOnAction(e -> new Modals().getNewEmployee());

        ArrayList<String> list = new ArrayList<>();
        list.add("Aidin");
        list.add("Ghazaal");
        list.add("Aida");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(list);

        Button btnTest = new Button("Test");
        btnTest.setOnAction(e -> window.setScene(testScene(window, window.getScene(), window.getScene().getWidth(), window.getScene().getHeight())));

        label = new Label("Hello There");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(button, label, btnTest, choiceBox);
        label.setVisible(false);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void closeApp(){
        answer = new AlertMessage("Quit", "Are you sure?").display();
        if (answer)
            window.close();
    }

    public Scene testScene(Stage stage, Scene currentScene, double width, double height){
        Button button = new Button("Back");
        button.setOnAction(e -> stage.setScene(currentScene));
        Label label = new Label("Test");

        TextField field = new TextField();
        Button btnSubmit = new Button("Submit Text");
        btnSubmit.setOnAction(e -> label.setText(field.getText()));


        VBox layout = new VBox(10);
        layout.getChildren().addAll(button, label, field, btnSubmit);

        return new Scene(layout, width, height);
    }
}
