package com.example.topheadlines.controllers;

import com.example.topheadlines.model.Article;
import com.example.topheadlines.services.RestHeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerHeadline {

    private final RestHeadlineService service;

    @Autowired
    public ControllerHeadline(RestHeadlineService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getArticleList(Model model, @RequestParam(defaultValue = "pl") String country,
                                 @RequestParam(defaultValue = "technology") String category) {

        model.addAttribute("headline", service.getHeadlineService(country, category));
        model.addAttribute("countries", service.getCountries());
        model.addAttribute("categories", service.getCategories());
        return "index";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Article getArticle(@RequestParam Integer counter,
                              @RequestParam(defaultValue = "pl") String country,
                              @RequestParam(defaultValue = "technology") String category) {
        return service.getAricles(country, category).get(counter);
    }

}