public class MaterialAndService {
    String name;
    int project_id;
    double quantity, cost;

    public MaterialAndService(String name, int project_id, double cost, double quantity){
        this.name = name;
        this.project_id = project_id;
        this.cost = cost;
        this.quantity = quantity;
    }
    public MaterialAndService(String name, int project_id, double cost){
        this.name = name;
        this.project_id = project_id;
        this.cost = cost;
    }
    public MaterialAndService(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

/*
Project
projectName : name
projectMaterials : {1,2,3,..}
 */
