package com.example.myspringproject.controllers;


import com.example.myspringproject.entities.Adventure;
import com.example.myspringproject.repositories.AdventureRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
@RequestMapping("/traveladventures")
public class TravelAdventuresController {

    private final AdventureRepository adventureRepository;

    public TravelAdventuresController(AdventureRepository adventureRepo) {
        this.adventureRepository = adventureRepo;
    }

    @GetMapping
    public Iterable<Adventure> getAllAdventures() {
        return adventureRepository.findAll();
    }

    @GetMapping("/bycountry/{country}")
    public List<Adventure> getAdventuresByCountry(@PathVariable String country) {
        return adventureRepository.findByCountry(country);
    }
    @GetMapping("/bystate")
    public List<Adventure> getAdventuresByState(@RequestParam("state") String state) {
        return adventureRepository.findByState(state);
    }

}

