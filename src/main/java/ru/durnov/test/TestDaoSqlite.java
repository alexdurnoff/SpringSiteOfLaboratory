package ru.durnov.test;

import org.junit.*;
import ru.durnov.dao.DeviceDaOISqlite;
import ru.durnov.entity.Device;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class TestDaoSqlite {
    @Test
    public void testDaoImpl() throws SQLException {
        System.out.println("Starting test DeviceDAOImpl Class");
        DeviceDaOISqlite daO = new DeviceDaOISqlite();
        ArrayList<Device> list = (ArrayList<Device>) daO.findAll();
        int len = list.size();
        System.out.println(len);
        Assert.assertNotEquals(len, 0);
    }


}
