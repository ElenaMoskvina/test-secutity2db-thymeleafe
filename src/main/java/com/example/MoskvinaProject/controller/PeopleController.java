package com.example.MoskvinaProject.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import com.example.MoskvinaProject.entity.People;
import com.example.MoskvinaProject.repository.PeopleRepository;
import com.example.MoskvinaProject.service.UserActionsService;


import java.util.Optional;
@Slf4j
@Controller
public class PeopleController {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private UserActionsService userActionsService;

    public PeopleController() {
    }

    @GetMapping ("/list")
    public ModelAndView getAllPeople () {
        log.info ("/list -> connections");
        ModelAndView mav = new ModelAndView( "list-people");
        mav.addObject ("people", peopleRepository.findAll());
        userActionsService.savelog("User get all people");
        return mav;
    }
    @GetMapping("/addPeopleForm")
    public ModelAndView addPeopleForm () {
        ModelAndView mav = new ModelAndView( "add-people-form");
        People people = new People();
        mav.addObject ("people", people);
        userActionsService.savelog("User adds people");
        return mav;
    }
    @PostMapping("/savePeople")
    public String savePeople (@ModelAttribute People people) {
        peopleRepository.save (people);
        userActionsService.savelog("User saves people");
        return "redirect:/list";
    }

    @GetMapping ("/showUpdateForm")
    public ModelAndView showUpdateForm (@RequestParam Long peopleId) {
        ModelAndView mav = new ModelAndView("add-people-form");
        Optional<People> optionalPeople = peopleRepository.findById(peopleId);
        People people = new People();
        if (optionalPeople.isPresent()) {
            people = optionalPeople.get();
        }
        mav.addObject("people", people);
        userActionsService.savelog("User see list of people");
        return mav;
    }
    @GetMapping ("/deletePeople")
    public String deletePeople (@RequestParam Long peopleId) {
        log.info ("/deletePeople -> connections");
        peopleRepository.deleteById(peopleId);
        userActionsService.savelog("User delete people");
        return "redirect:/list";
    }
}
