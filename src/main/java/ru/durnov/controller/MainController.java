package ru.durnov.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String base(){
        return "base";
    }

    @GetMapping("employers")
    public String employers(){
        return "employes";
    }

    @GetMapping("calculate")
    public String calculate(){
        return "calculate";
    }

    @GetMapping("license")
    public String license(Model model){return "license"; }


}
