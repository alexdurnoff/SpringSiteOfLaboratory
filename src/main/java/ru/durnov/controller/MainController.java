package ru.durnov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String base(){
        return "base";
    }

    @GetMapping("/devices")
    public String devices(){
        return "devices";
    }

}
