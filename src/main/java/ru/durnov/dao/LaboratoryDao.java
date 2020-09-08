package ru.durnov.dao;

import ru.durnov.entity.Build;
import ru.durnov.entity.Calculate;
import ru.durnov.entity.Device;

public interface LaboratoryDao {
    Iterable<Device> findAllDevices();
    Iterable<Build> findAllBuilds();
    Iterable<Calculate> findAllCalculates();

}
