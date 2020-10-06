package ru.durnov.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.durnov.entity.Build;
import ru.durnov.entity.Calculate;
import ru.durnov.entity.Device;


import java.nio.file.Paths;
import java.sql.*;

@Slf4j
@Repository
public class DaOISqliteImplementation implements LaboratoryDao{

    @Autowired
    public JdbcTemplate jdbc;

    @Autowired
    public DaOISqliteImplementation(JdbcTemplate jdbs){
        this.jdbc = jdbs;
    }

    @Override
    public Iterable<Device> findAllDevices() {
        return jdbc.query("SELECT * FROM devices_devices", this::mapRowToDevice);
    }

    public Device mapRowToDevice(ResultSet resultSet, int rowNumber) throws SQLException {
        Device device = new Device();
        device.setTitle(resultSet.getString("title"));
        device.setAccuracyClass(resultSet.getString("accuracy_Class"));
        device.setDateOfNextVerification(resultSet.getString("date_of_next_verification"));
        device.setDateOfVerification(resultSet.getString("date_of_verification"));
        device.setDescription(resultSet.getString("description"));
        device.setMeasurementRange(resultSet.getString("measurement_range"));
        int index = resultSet.getString("image_of_devices").lastIndexOf("/");
        device.setImageOfDevice("/resources/images" + resultSet.getString("image_of_devices").substring(index));//Пока костыль. Надо базу редактировать.
        log.info(device.getImageOfDevice());
        System.out.println(device.getImageOfDevice());
        return device;
    }

    @Override
    public Iterable<Build> findAllBuilds() {
        return jdbc.query("SELECT * FROM builds_builds", this::mapRowToBuild);
    }

    public Build mapRowToBuild(ResultSet resultSet, int rownumber) throws SQLException {
        Build build = new Build();
        build.setTitle(resultSet.getString("title"));
        build.setAdress(resultSet.getString("adress"));
        build.setDescription(resultSet.getString("description"));
        build.setDate_end_of_build(resultSet.getString("date_end_of_build"));
        build.setEmployer(resultSet.getString("employer"));
        int index = resultSet.getString("image_of_build").lastIndexOf("/");
        build.setImage_of_build("/resources/images" + resultSet.getString("image_of_build").substring(index));//Пока костыль
        return build;
    }

    @Override
    public Iterable<Calculate> findAllCalculates() {
      return jdbc.query("SELECT * FROM calculate_calculate", this::mapRowToCalculate);
    }

    public  Calculate mapRowToCalculate(ResultSet resultSet, int rowNumber){
        Calculate calculate = new Calculate();
        calculate.setTitle("title");
        calculate.setUnit("unit");
        calculate.setCoast(Integer.valueOf("coast"));
        calculate.setCoast_fr(Integer.valueOf("coast_fr"));
        return calculate;
    }

}
