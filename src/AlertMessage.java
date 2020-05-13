import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertMessage {

    String title, message;
    boolean answer;

    public AlertMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public AlertMessage(){

    }

    public boolean display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);

        Button btnYes = new Button("Yes");
        btnYes.setOnAction(e -> {
            answer = true;
            window.close();
        });

        Button btnNo = new Button("No");
        btnNo.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, btnYes, btnNo);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 200, 100);

        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public void errorHandlingMessage(String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("خطا");

        Label errorText = new Label(message);

        StackPane layout = new StackPane();
        layout.getChildren().add(errorText);

        Scene scene = new Scene(layout, 200, 100);

        window.setScene(scene);
        window.showAndWait();
    }
}
