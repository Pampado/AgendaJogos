CREATE SCHEMA `infoJogos` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
CREATE USER 'BotJogos'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON `infoJogos`.* TO 'BotJogos'@'localhost';
FLUSH PRIVILEGES;
CREATE TABLE `infoJogos`.`Jogos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_date` DATETIME NOT NULL,
  `home_team` VARCHAR(45) NOT NULL,
  `away_team` VARCHAR(45) NOT NULL,
  `champ_name`VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));