package ru.durnov.dao;

import ru.durnov.entity.Device;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDaOImpl implements LaboratoryDao{
    public DeviceDaOImpl() throws SQLException {
        List<Device> deviceList = this.findAll();

    }

    @Override
    public List<Device> findAll() {
        ArrayList<Device> devices = new ArrayList<>();
        boolean itsAllRight = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:msql://localhost:3306/db/db.sqlite3");
            DatabaseMetaData data = connection.getMetaData();
            ResultSet catalogs = data.getCatalogs();
            ResultSetMetaData metaData = catalogs.getMetaData();
            String name = metaData.getTableName(1);
            itsAllRight = true;
            System.out.println("TRUE!!!!");
            Device device = new Device();
            devices.add(device);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
