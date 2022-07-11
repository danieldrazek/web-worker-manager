package pl.pp.manager.model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkersDBUtils {
    public static List<Worker> getWorkers(DataSource dataSource){
        System.out.println("metoda getWorkers");
        List<Worker> workers = new ArrayList<>();

        //database connection
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()){    //make statement

            //get all workers from database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM workers");

            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                double salary = resultSet.getDouble("salary");

                Worker worker = new Worker(id, firstName, lastName, salary);
                System.out.println(worker);
                workers.add(worker);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workers;
    }
    public static void addWorker(Worker worker, DataSource dataSource) {
        String sql = "INSERT INTO workers (first_name, last_name, salary) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){    //make a statement

            statement.setString(1, worker.getFirstName());
            statement.setString(2, worker.getLastName());
            statement.setDouble(3, worker.getSalary());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Worker getWorkerById(int id, DataSource dataSource) {
        String sql = "SELECT * FROM workers WHERE id = ?";
        Worker worker = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){    //make a statement

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                double salary = resultSet.getDouble("salary");

                worker = new Worker(id, firstName, lastName, salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worker;
    }

    public static void updateWorker(Worker worker, DataSource dataSource) {
        String sql = "UPDATE workers SET first_name=?, last_name=?, salary=? WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, worker.getFirstName());
            statement.setString(2, worker.getLastName());
            statement.setDouble(3, worker.getSalary());
            statement.setInt(4, worker.getId());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWorkerById(int id, DataSource dataSource) {
        String sql = "DELETE FROM workers WHERE id=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
