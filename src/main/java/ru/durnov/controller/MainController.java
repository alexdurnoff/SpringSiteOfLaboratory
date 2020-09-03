package ru.durnov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping("/builds")
    public String builds(){
        return "builds";
    }

    @GetMapping("/employers")
    public String employers(){
        return "employes";
    }

    @GetMapping("/calculate")
    public String calculate(){
        return "calculate";
    }

    @GetMapping("/license")
    public String license(Model model){return "license"; }


}
