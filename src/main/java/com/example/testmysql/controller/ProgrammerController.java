package com.example.testmysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testmysql.model.Programmer;
import com.example.testmysql.service.ProgrammerService;

@RestController("/programmers")
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;

    @GetMapping
    public List<Programmer> findProgrammersByLanguage(@RequestParam(value = "language", required = false) String language) {
        return Optional.ofNullable(language)
                .map(programmerService::findProgrammersByLanguage)
                .orElse(programmerService.findAllProgrammers());
    }
}
