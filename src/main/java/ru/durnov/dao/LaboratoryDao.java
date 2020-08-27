package ru.durnov.dao;

import ru.durnov.entity.Device;

import java.util.List;

public interface LaboratoryDao {
    List<Device> findAll();

}
