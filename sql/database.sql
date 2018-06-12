CREATE SCHEMA `java_blog_platform` DEFAULT CHARACTER SET latin1  DEFAULT COLLATE latin1_bin;

CREATE TABLE `java_blog_platform`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(32) NOT NULL COMMENT 'stores the md5 hash for the user\'s password',
  `first_name` VARCHAR(15) NOT NULL,
  `last_name` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `avatar_link` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `java_blog_platform`.`blog_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author_id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `text` LONGTEXT NOT NULL,
  'date' DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `author_id_idx` (`author_id` ASC),
  CONSTRAINT `author_id`
    FOREIGN KEY (`author_id`)
    REFERENCES `java_blog_platform`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `java_blog_platform`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author_id` INT NOT NULL,
  `blog_post_id` INT NOT NULL,
  `text` MEDIUMTEXT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `author_id_idx` (`author_id` ASC),
  INDEX `blog_post_id_idx` (`blog_post_id` ASC),
  CONSTRAINT `comment_author_id`
    FOREIGN KEY (`author_id`)
    REFERENCES `java_blog_platform`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `blog_post_id`
    FOREIGN KEY (`blog_post_id`)
    REFERENCES `java_blog_platform`.`blog_post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


