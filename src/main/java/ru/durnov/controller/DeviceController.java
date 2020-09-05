package ru.durnov.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.durnov.dao.DeviceDaOISqlite;
import ru.durnov.entity.Device;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/devices")
public class DeviceController {

    @GetMapping
    public String showDevices(Model model){
        DeviceDaOISqlite daOISqlite = new DeviceDaOISqlite();
        DeviceDaOISqlite daO = new DeviceDaOISqlite();
        ArrayList<Device> devices = (ArrayList<Device>) daO.findAllDevices();
        System.out.println(devices.size());
        model.addAttribute("devices", devices);
        return "devices";
    }

}
