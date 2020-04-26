package com.example.testmysql.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.testmysql.TestMysqlApplication;
import com.example.testmysql.model.Programmer;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;

@RunWith(SpringRunner.class)
@ContextConfiguration(initializers = ProgrammerRepositoryMysqlTest.Initializer.class,
    classes = TestMysqlApplication.class)
public class ProgrammerRepositoryMysqlTest {

  private static final String LANGUAGE = "java";
  @ClassRule
  public static MySQLContainer mysql = new MySQLContainer();
  @Autowired
  private ProgrammerRepository programmerRepository;

  @Test
  public void shouldFindByLanguage() {
    //Given && When
    List<Programmer> found = programmerRepository.findByLanguage(LANGUAGE);

    //Then
    assertThat(found).extracting("language").containsOnly("java");

  }

  @Test
  public void shouldFindWithReversedStringsByLanguage() {
    //Given && When
    List<Programmer> found = programmerRepository.findWithReversedStringByLanguage(LANGUAGE);

    //Then
    assertThat(found).extracting("language").containsOnly("avaj");

  }

  public static class Initializer implements
      ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues values = TestPropertyValues.of(
          "spring.datasource.url=" + mysql.getJdbcUrl(),
          "spring.datasource.username=" + mysql.getUsername(),
          "spring.datasource.password=" + mysql.getPassword());
      values.applyTo(configurableApplicationContext);
    }
  }
}
