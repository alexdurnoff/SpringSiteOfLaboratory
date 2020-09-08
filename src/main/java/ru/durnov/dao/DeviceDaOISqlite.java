package ru.durnov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.durnov.entity.Build;
import ru.durnov.entity.Calculate;
import ru.durnov.entity.Device;


import javax.sql.DataSource;
import java.sql.*;


@Repository
public class DeviceDaOISqlite implements LaboratoryDao{

    @Autowired
    public JdbcTemplate jdbc;

    @Autowired
    public DeviceDaOISqlite(JdbcTemplate jdbs){
        this.jdbc = jdbs;
    }

    @Override
    public Iterable<Device> findAllDevices() {
        return jdbc.query("SELECT * FROM devices_devices", this::mapRowToDevice);
    }

    public Device mapRowToDevice(ResultSet resultSet, int rowNumber){
        return new Device();
    }

    public Build mapRowToBuild(ResultSet resultSet, int rownumber){
        return new Build();
    }

    public Calculate mapRowToCalculate(ResultSet resultSet, int rowNumber){
        return new Calculate();
    }

    @Override
    public Iterable<Build> findAllBuilds() {
        return jdbc.query("SELECT * FROM devices_devices", this::mapRowToBuild);
    }

    @Override
    public Iterable<Calculate> findAllCalculates() {
      return jdbc.query("SELECT * FROM calculate_calculate", this::mapRowToCalculate);
    }

}
