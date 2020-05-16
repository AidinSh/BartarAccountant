import java.util.ArrayList;

public class Project {
    String name, clientName, description;
    double price, duration, cost;
    ArrayList<MaterialAndService> materials;

    public Project(){

    }
    public Project(String name, String clientName, String description, double price, double duration, ArrayList<MaterialAndService> materials){
        this.name = name;
        this.clientName = clientName;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.materials = materials;
    }
}
