package com.example.testmysql.service;

import com.example.testmysql.model.Programmer;
import com.example.testmysql.repository.ProgrammerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammerService {

  @Autowired
  private ProgrammerRepository programmerRepository;

  public List<Programmer> findProgrammersByLanguage(String language) {
    return programmerRepository.findByLanguage(language);
  }

  public List<Programmer> findAllProgrammers() {
    return programmerRepository.findAll();
  }
}
