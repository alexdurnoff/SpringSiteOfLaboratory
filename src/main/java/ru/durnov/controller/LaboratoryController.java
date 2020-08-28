package ru.durnov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaboratoryController {
    @GetMapping("/")
    public String base(){
        return "base";
    }

    @GetMapping("/devices")
    public String devices(Model model){

        return "devices";}

    @GetMapping("/builds")
    public String builds(Model model){
        return "builds";}
}
