CREATE TABLE cities (city_id smallint (6) AUTO_INCREMENT, zip smallint(6), city VARCHAR (20), primary key (city_id)) ;
CREATE TABLE `citizens` (
	`citizen_id` INT(11) NOT NULL AUTO_INCREMENT,
	`citizen_name` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
	`zip` VARCHAR(4) NOT NULL COLLATE 'utf8_hungarian_ci',
	`age` BIGINT(20) NOT NULL,
	`email` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
	`taj` VARCHAR(10) NOT NULL COLLATE 'utf8_hungarian_ci',
	`number_of_vaccination` INT(11) NOT NULL,
	`last_vaccination` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`citizen_id`));
CREATE TABLE `vaccinations` (
	`vaccination_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`citizen_id` INT(11) NOT NULL DEFAULT '0',
	`vaccination_date` DATETIME NULL DEFAULT NULL,
	`status` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`note` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`vaccination_type` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`vaccination_id`) USING BTREE,
	INDEX `FK__citizens` (`citizen_id`) USING BTREE,
	CONSTRAINT `FK__citizens` FOREIGN KEY (`citizen_id`) REFERENCES `vaccinetracker`.`citizens` (`citizen_id`) ON UPDATE RESTRICT ON DELETE RESTRICT);
INSERT INTO `cities` VALUES (1, 2000, 'Szentendre');
INSERT INTO `cities` VALUES (2, 2009, 'Pilisszentlászló');
INSERT INTO `cities` VALUES (3, 2011, 'Budakalász');
INSERT INTO `cities` VALUES (4, 2013, 'Pomáz');
INSERT INTO `cities` VALUES (5, 2014, 'Csobánka');
INSERT INTO `cities` VALUES (6, 2015, 'Szigetmonostor');
INSERT INTO `cities` VALUES (7, 2016, 'Leányfalu');
INSERT INTO `cities` VALUES (8, 2017, 'Pócsmegyer');
INSERT INTO `cities` VALUES (9, 2021, 'Tahitótfalu');
INSERT INTO `cities` VALUES (10, 2022, 'Tahitótfalu');
INSERT INTO `cities` VALUES (11, 2023, 'Dunabogdány');
INSERT INTO `cities` VALUES (12, 2024, 'Kisoroszi');
INSERT INTO `cities` VALUES (13, 2025, 'Visegrád');
INSERT INTO `cities` VALUES (14, 2026, 'Visegrád');
INSERT INTO `cities` VALUES (15, 2027, 'Dömös');
INSERT INTO `cities` VALUES (16, 2028, 'Pilismarót');
INSERT INTO `cities` VALUES (17, 2030, 'Érd');
INSERT INTO `cities` VALUES (18, 2038, 'Sóskút');

