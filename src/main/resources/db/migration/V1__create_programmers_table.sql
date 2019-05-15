CREATE TABLE programmers (
  nick varchar(100) NOT NULL,
  `language` varchar(100) NOT NULL,
  PRIMARY KEY (nick)
) ;

INSERT INTO programmers VALUES ("mark", "java");
INSERT INTO programmers VALUES("sarah", "php");
INSERT INTO programmers VALUES("john", "java");
