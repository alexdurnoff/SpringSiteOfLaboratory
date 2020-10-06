package ru.durnov.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.durnov.dao.DaOISqliteImplementation;
import ru.durnov.entity.Build;


@Slf4j
@Controller
@RequestMapping("/builds")
public class BuildController {

    private final DaOISqliteImplementation buildsDao;

    @Autowired
    public BuildController(DaOISqliteImplementation buildsDao) {
        this.buildsDao = buildsDao;
    }

    @GetMapping
    public String showBuilds(Model model){
        Iterable<Build> builds = buildsDao.findAllBuilds();
        model.addAttribute("builds", builds);
        return "builds";
    }
}
