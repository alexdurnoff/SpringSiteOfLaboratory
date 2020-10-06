package ru.durnov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.durnov.dao.DaOISqliteImplementation;
import ru.durnov.entity.Device;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/devices")
public class DeviceController {

    private final DaOISqliteImplementation deviceDaO;

    @Autowired
    public DeviceController(DaOISqliteImplementation deviceDaO) {
        this.deviceDaO = deviceDaO;
    }

    @GetMapping
    public String showDevices(Model model){
        Iterable<Device> devices = deviceDaO.findAllDevices();
        model.addAttribute("devices", devices);
        return "devices";
    }

}
