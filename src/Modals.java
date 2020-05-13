import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Modals {
    int width = 300 , height = 300;

    public void getNewEmployee(){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ثبت کارگر جدید");

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setHgap(10);
        layout.setVgap(10);

        Label nameLabel = new Label("نام و نام خانوادگی :");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameField = new TextField();
        GridPane.setConstraints(nameField, 1, 0);

        Label salaryLabel = new Label("حقوق ماهیانه :");
        GridPane.setConstraints(salaryLabel, 0, 1);

        TextField salaryField = new TextField();
        salaryField.setPromptText("مبلغ به تومان");
        GridPane.setConstraints(salaryField,1, 1);

        Label maritalStatusLabel = new Label("وضعیت تعهل :");
        GridPane.setConstraints(maritalStatusLabel, 0, 2);

        ChoiceBox<String> maritalStatusBox = new ChoiceBox<>();
        maritalStatusBox.getItems().addAll("مجرد", "متاهل");
        GridPane.setConstraints(maritalStatusBox, 1, 2);

        Button btnSubmit = new Button("ثبت");
        GridPane.setConstraints(btnSubmit, 0, 3);
        btnSubmit.setOnAction(e -> {
            Employee employee = new Employee(nameField.getText(), (Double.parseDouble(salaryField.getText())));

            System.out.println(employee.getName());
            System.out.println(employee.getMonthlySalary());
            System.out.println(employee.getDailySalary());
            System.out.println(employee.getInsurancePay());
        });

        Button btnCancel = new Button("لغو");
        GridPane.setConstraints(btnCancel, 1, 3);
        btnCancel.setOnAction(e -> window.close());

        layout.getChildren().addAll(nameLabel, nameField, salaryField, salaryLabel, btnCancel, btnSubmit, maritalStatusBox, maritalStatusLabel);
        layout.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        Scene scene = new Scene(layout, width, height);
        window.setScene(scene);
        window.show();

    }
}
