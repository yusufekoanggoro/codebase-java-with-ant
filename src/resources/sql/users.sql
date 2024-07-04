CREATE TABLE `codebase`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(255) NOT NULL,
  `gender` VARCHAR(15) NOT NULL, 
  `place_of_birth` VARCHAR(15) NOT NULL, 
  `date_of_birth` DATE NOT NULL, 
  `address` TEXT NOT NULL,
  `religion` VARCHAR(255) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `created_at` DATETIME NOT NULL, 
  `updated_at` DATETIME NOT NULL, 
  `username` VARCHAR(30) NOT NULL, 
  `password` VARCHAR(255) NOT NULL, 
  `role_id` INT NOT NULL,
  `email` VARCHAR(50)
  PRIMARY KEY (`id`), UNIQUE (`username`, `email`)
) ENGINE = InnoDB;