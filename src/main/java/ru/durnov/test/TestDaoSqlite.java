package ru.durnov.test;

import org.junit.*;
import ru.durnov.dao.DeviceDaOISqlite;
import ru.durnov.entity.Calculate;
import ru.durnov.entity.Device;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;

public class TestDaoSqlite {
    @Test
    public void testDaoImpl() throws SQLException {
        System.out.println("Starting test DeviceDAOImpl Class");
        DeviceDaOISqlite daO = new DeviceDaOISqlite();
        ArrayList<Device> list = (ArrayList<Device>) daO.findAllDevices();
        int len = list.size();
        System.out.println(len);
        Assert.assertNotEquals(len, 0);
    }

    @Test
    public void testDaoGetTableNames() throws SQLException {
        System.out.println("Starting test daoGetTableNames");
        DeviceDaOISqlite daOISqlite = new DeviceDaOISqlite();
        ArrayList<String> list = daOISqlite.getTableNames();
        int len = list.size();
        Assert.assertNotEquals(len, 0);
        for (String name: list){
            System.out.println(name);
        }
    }

    @Test
    public void testCalculate() throws SQLException {
        System.out.println("Starting test Calculates");
        DeviceDaOISqlite daO = new DeviceDaOISqlite();
        ArrayList<Calculate> list = (ArrayList<Calculate>) daO.findAllCalculates();
        int len = list.size();
        System.out.println(len);
        Assert.assertNotEquals(len, 0);
        for (Calculate calculate: list){
            System.out.println(calculate.getTitle());
            System.out.println(calculate.getUnit());
            System.out.println(calculate.getCoast());
        }
    }

}