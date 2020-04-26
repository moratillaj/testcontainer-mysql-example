package com.example.testmysql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "programmers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Programmer {

  @Id
  private String nick;
  private String language;
}
