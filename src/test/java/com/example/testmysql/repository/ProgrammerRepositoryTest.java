package com.example.testmysql.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.testmysql.model.Programmer;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
    "spring.datasource.username=user",
    "spring.datasource.password=pass",
    "driver-class-name=org.h2.Driver",
    "platform=h2"
})
@SpringBootTest
public class ProgrammerRepositoryTest {

  private static final String LANGUAGE = "java";

  @Autowired
  private ProgrammerRepository programmerRepository;

  @Test
  public void shouldFindByLanguage() {
    //Given && When
    List<Programmer> found = programmerRepository.findByLanguage(LANGUAGE);

    //Then
    assertThat(found).extracting("language").containsOnly("java");

  }

}
