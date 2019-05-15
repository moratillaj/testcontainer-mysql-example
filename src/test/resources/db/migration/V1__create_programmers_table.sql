CREATE TABLE programmers (
  nick varchar(100) NOT NULL,
  `language` varchar(100) NOT NULL,
  PRIMARY KEY (nick)
) ;

INSERT INTO programmers (nick, `language`) VALUES ('mark', 'java');
INSERT INTO programmers (nick, `language`) VALUES('sarah', 'php');
INSERT INTO programmers (nick, `language`) VALUES('john', 'java');
