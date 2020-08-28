package ru.durnov.dao;

import org.springframework.stereotype.Repository;
import ru.durnov.entity.Build;
import ru.durnov.entity.Calculate;
import ru.durnov.entity.Device;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class DeviceDaOISqlite implements LaboratoryDao{
    private final String url = "jdbc:sqlite:db/db.sqlite3";
    private final String user = "alexej";
    private final String password = "fvngz5BYgh";
    public DeviceDaOISqlite(){
    }

    @Override
    public ArrayList<Device> findAllDevices() {
        ArrayList<Device> devices = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM devices_devices";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Device device = new Device();
                device.setTitle(resultSet.getString("title"));
                device.setDescription(resultSet.getString("description"));
                device.setMeasurementRange(resultSet.getString("measurement_range"));
                device.setDateOfVerification(resultSet.getString("date_of_verification"));
                device.getDateOfNextVerification(resultSet.getString("date_of_next_verification"));
                System.out.println(resultSet.getString("image_of_devices"));
                devices.add(device);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            if (!connection.equals(null)){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return devices;
    }

    @Override
    public ArrayList<Build> findAllBuilds() {
        ArrayList<Build> builds = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM builds_builds";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Build build = new Build();
                builds.add(build);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            if (!connection.equals(null)){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return builds;
    }

    @Override
    public ArrayList<Calculate> findAllCalculates() {
        ArrayList<Calculate> calculates = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM calculate_calculate";
            //ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' ORDER BY name");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Calculate calculate = new Calculate();
                calculates.add(calculate);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            if (!connection.equals(null)){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return calculates;
    }

    public ArrayList<String> getTableNames(){
        ArrayList<String> tableNames = new ArrayList<>();
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' ORDER BY name");
            while (resultSet.next()){
                tableNames.add(resultSet.getString("name"));
            }
        } catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
            if (!connection.equals(null)){
                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return tableNames;
    }
}