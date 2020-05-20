import Models.Employee;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Modals {
    int width = 350 , height = 300;
    Employee employee;

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

        Label maritalStatusLabel = new Label("وضعیت تاهل :");
        GridPane.setConstraints(maritalStatusLabel, 0, 2);

        ChoiceBox<String> maritalStatusBox = new ChoiceBox<>();
        maritalStatusBox.getItems().addAll("مجرد", "متاهل");
        maritalStatusBox.setValue("مجرد");
        GridPane.setConstraints(maritalStatusBox, 1, 2);

        Button btnSubmit = new Button("ثبت");
        GridPane.setConstraints(btnSubmit, 0, 3);
        btnSubmit.setOnAction(e -> {
            if (nameField.getText().isEmpty())
                new AlertMessage().errorHandlingMessage("لطفا نام را وارد کنید");
            else if (salaryField.getText().isEmpty())
                new AlertMessage().errorHandlingMessage("لطفا میزان حقوق را وارد کنید");
            else {
                employee = new Employee(nameField.getText(), (Double.parseDouble(salaryField.getText())));
                employee.setMarried(maritalStatusBox.getValue().equals("متاهل"));
                System.out.println(employee.getName());
                System.out.println(employee.getMonthlySalary());
                System.out.println(employee.getDailySalary());
                System.out.println(employee.getInsurancePay());
                System.out.println(employee.isMarried());
            }

        });

        Button btnCancel = new Button("لغو");
        GridPane.setConstraints(btnCancel, 1, 3);
        btnCancel.setOnAction(e -> window.close());

        Button btnShow = new Button("نمایش اطلاعات");
        GridPane.setConstraints(btnShow, 0, 4);
        btnShow.setOnAction(e -> showEmployee(employee));

        layout.getChildren().addAll(nameLabel, nameField, salaryField, salaryLabel, btnCancel, btnSubmit, maritalStatusBox, maritalStatusLabel, btnShow);
        layout.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        Scene scene = new Scene(layout, width, height);
        window.setScene(scene);
        window.show();

    }

    public void showEmployee(Employee employee) {
        Stage window = new Stage();
        window.setTitle("اطلاعات کارگران");
        GridPane layout = new GridPane();

        Label nameLabel = new Label("نام و نام خانوادگی :");
        Label salaryLabel = new Label("حقوق ماهانه :");
        Label dailySalaryLabel = new Label("حقوق روزانه :");
        Label maritalStatusLabel = new Label("وضعیت تاهل :");

        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(salaryLabel, 0, 1);
        GridPane.setConstraints(dailySalaryLabel, 0, 2);
        GridPane.setConstraints(maritalStatusLabel, 0, 3);

        Label nameValue = new Label();
        nameValue.setStyle("-fx-font-weight: bold");
        Label salaryValue = new Label();
        salaryValue.setStyle("-fx-font-weight: bold");
        Label dailySalaryValue = new Label();
        dailySalaryValue.setStyle("-fx-font-weight: bold");
        Label maritalStatusValue = new Label();
        maritalStatusValue.setStyle("-fx-font-weight: bold");

        GridPane.setConstraints(nameValue, 1, 0);
        GridPane.setConstraints(salaryValue, 1, 1);
        GridPane.setConstraints(dailySalaryValue, 1, 2);
        GridPane.setConstraints(maritalStatusValue, 1, 3);

        nameValue.setText(employee.getName());
        salaryValue.setText(String.valueOf(employee.getMonthlySalary()));
        dailySalaryValue.setText(String.valueOf(employee.getDailySalary()));
        if (employee.isMarried())
            maritalStatusValue.setText("متاهل");
        else
            maritalStatusValue.setText("مجرد");

        layout.getChildren().addAll(nameLabel, nameValue, salaryLabel, salaryValue, dailySalaryLabel, dailySalaryValue, maritalStatusLabel, maritalStatusValue);
        layout.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        Scene scene = new Scene(layout, width, height);
        window.setScene(scene);
        window.show();
    }

}
