package ru.durnov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LaboratoryController {
    @GetMapping("/")
    public String base(){
        return "base";
    }
}
