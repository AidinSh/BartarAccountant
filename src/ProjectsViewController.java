import Models.Project;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;


public class ProjectsViewController {



    public void onGoingProjects() throws SQLException {
        Stage window = new Stage();
        VBox vBox = new VBox();
        HBox hBox = new HBox();

        TableView<Project> table;
        TableColumn<Project, String> nameColumn = new TableColumn<>("پروژه");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("name"));
        nameColumn.setMinWidth(100);

        TableColumn<Project, String> clientNameColumn = new TableColumn<>("نام مشتری");
        clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        clientNameColumn.setMinWidth(100);

        TableColumn<Project, Integer> priceColumn = new TableColumn<>("قیمت");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setMinWidth(50);

        TableColumn<Project, Double> durationColumn = new TableColumn<>("مدت زمان");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        durationColumn.setMinWidth(50);

        TableColumn<Project, Button> materialsColumn = new TableColumn<>("مواد و خدمات مصرفی");
        materialsColumn.setCellValueFactory(new PropertyValueFactory<>("btnMaterials"));
        materialsColumn.setMinWidth(200);

        TableColumn<Project, String> descriptionColumn = new TableColumn<>("توضیحات");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionColumn.setMinWidth(200);

        table = new TableView<>();
        table.setItems(new ProjectsDataManager().loadOnGoingProjects());
        table.getColumns().addAll(nameColumn, clientNameColumn, priceColumn, durationColumn, descriptionColumn,materialsColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button btnAddProject = new Button("اضافه کردن پروژه");
        btnAddProject.setOnAction(e -> addProject());

        Button btnLoad = new Button("بارگذاری پروژه ها");
        btnLoad.setOnAction(e -> {
            try {
                table.setItems(new ProjectsDataManager().loadOnGoingProjects());
            }catch (SQLException exception){
                exception.printStackTrace();
            }

        });

        hBox.setPadding(new Insets(5));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btnAddProject, btnLoad);
        vBox.getChildren().addAll(table, hBox);
        vBox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        Scene scene = new Scene(vBox, table.getWidth(), table.getHeight());
        window.setScene(scene);
        window.show();
    }

    public void addProject(){
        Stage window = new Stage();
        VBox vBox = new VBox();

        TextField tfName = new TextField();
        tfName.setPromptText("نام پروژه");

        TextField tfClientName = new TextField();
        tfClientName.setPromptText("نام مشتری");

        TextField tfPrice = new TextField();
        tfPrice.setPromptText("قیمت پروژه");

        TextField tfDuration = new TextField();
        tfDuration.setPromptText("مدت زمان پروژه");

        TextField tfDescription = new TextField();
        tfDescription.setPromptText("توضیحات");
        tfDescription.setPrefHeight(100);

        Button btnAdd = new Button("اضافه کردن");
        btnAdd.setOnAction(e -> {
            new ProjectsDataManager().saveOnGoingProjects(tfName.getText(), tfClientName.getText(), tfDescription.getText(), Integer.parseInt(tfPrice.getText()), Double.parseDouble(tfDuration.getText()));
            new AlertMessage().savedMessage("با موفقیت ذخیره شد");
            window.close();
        });

        vBox.getChildren().addAll(tfName, tfClientName, tfPrice, tfDuration, tfDescription, btnAdd);
        vBox.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

}
