package Models;

import javafx.scene.control.Button;
import java.util.ArrayList;

public class Project {
    String name, clientName, description;
    double  duration;
    Button btnMaterials;
    int price;

    public Project(){

        
    }

    public Project(String name, String clientName, String description, int price, double duration){
        this.name = name;
        this.clientName = clientName;
        this.description = description;
        this.price = price;
        this.duration = duration;

        btnMaterials = new Button("مشاهده");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Button getBtnMaterials() {
        return btnMaterials;
    }

    public void setBtnMaterials(Button btnMaterials) {
        this.btnMaterials = btnMaterials;
    }
}
