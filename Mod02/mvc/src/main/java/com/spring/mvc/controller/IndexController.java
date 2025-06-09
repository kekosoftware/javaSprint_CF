package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String Index(Model model) {
        model.addAttribute("titulo", "Soy el título");
        model.addAttribute("saludo", "Estoy saludando");
        model.addAttribute("show", true);

        // List<String> series = List.of("Dexter", "Game of Thrones", "Vikings");
        // model.addAttribute("series", series);

        return "Index";
    }

    @GetMapping(value = "/index-mv")
    public ModelAndView IndexMV(ModelAndView mv) {
        mv.addObject("titulo", "Titulo de MV");
        mv.addObject("saludo", "Saludo de MV");
        mv.addObject("show", true);

        // List<String> series = List.of("Dexter", "Game of Thrones", "Vikings");
        // mv.addObject("series", series);

        mv.setViewName("Index");

        return mv;
    }

    @ModelAttribute("series")
    public List<String> getSeries() {
        return List.of("Dexter", "Game of Thrones", "Vikings", "Flash");
    }

    @RequestMapping(value = "/index-req-mapping", method = RequestMethod.GET)
    public String IndexRequestMapping() {
        return "Index";
    }

    @PostMapping(value = "/index-post-mapping")
    public String IndexPostMapping() {
        return "Index";
    }
}
