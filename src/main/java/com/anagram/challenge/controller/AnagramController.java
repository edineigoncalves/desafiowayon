package com.anagram.challenge.controller;

import com.anagram.challenge.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagramController {

    private final AnagramService anagramService;

    @Autowired
    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @GetMapping("/api/anagrams")
    public List<String> getAnagrams(@RequestParam String letters) {
        return anagramService.generateAnagrams(letters);
    }
}

