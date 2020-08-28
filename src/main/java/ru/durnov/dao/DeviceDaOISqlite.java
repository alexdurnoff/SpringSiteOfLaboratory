package ru.durnov.dao;

import ru.durnov.entity.Device;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDaOISqlite implements LaboratoryDao{
    private final String url = "jdbc:sqlite:db/db.sqlite3";
    private final String user = "alexej";
    private final String password = "1103206bygh";
    public DeviceDaOISqlite(){
    }

    @Override
    public List<Device> findAll() {
        ArrayList<Device> devices = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM devices_devices";
            //ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' ORDER BY name");
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
}
