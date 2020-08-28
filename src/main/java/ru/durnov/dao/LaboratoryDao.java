package ru.durnov.dao;

import ru.durnov.entity.Build;
import ru.durnov.entity.Calculate;
import ru.durnov.entity.Device;

import java.util.ArrayList;

public interface LaboratoryDao {
    ArrayList<Device> findAllDevices();
    ArrayList<Build> findAllBuilds();
    ArrayList<Calculate> findAllCalculates();

}
