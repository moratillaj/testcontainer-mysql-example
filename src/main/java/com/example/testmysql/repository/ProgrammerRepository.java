package com.example.testmysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.testmysql.model.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, String> {
    List<Programmer> findByLanguage(String language);

    @Query(nativeQuery = true, value = "select reverse(nick) as nick, reverse(language) as language from programmers where language=:language")
    List<Programmer> findWithReversedStringByLanguage(@Param("language") String language);
}
