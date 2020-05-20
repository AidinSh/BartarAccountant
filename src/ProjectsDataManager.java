import Models.Project;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectsDataManager {

    Connection connection;

    public ObservableList<Project> loadOnGoingProjects() throws SQLException {
        connection = dbConnection.getConnection();
        String query = "SELECT * FROM ongoing_projects";
        ObservableList<Project> data = FXCollections.observableArrayList();
        assert connection != null;
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        while (resultSet.next()){
            data.add(new Project(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDouble(5)));
        }
        return data;
    }

    public void saveOnGoingProjects(String name, String clientName, String description , int price , double duration) {
        try {
            connection = dbConnection.getConnection();
            String query = "INSERT INTO ongoing_projects(name, client_name, description, price, duration) VALUES (?,?,?,?,?)";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, clientName);
            statement.setString(3, description);
            statement.setInt(4, price);
            statement.setDouble(5, duration);

            statement.execute();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
