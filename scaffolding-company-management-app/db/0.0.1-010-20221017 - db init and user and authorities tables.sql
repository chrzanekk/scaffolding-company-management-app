CREATE DATABASE smc_db_dev;
CREATE TABLE users(
	id INT AUTO_INCREMENT,
	login VARCHAR(255) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	second_name VARCHAR(75) NOT NULL, LANGUAGE VARCHAR(20) NOT NULL,
	is_enabled boolean,
	registration_datetime DATETIME DEFAULT NOW(),
	modified_datetime DATETIME,
	delete_datetime DATETIME, PRIMARY KEY (id),
	provider_user_id VARCHAR(255) NOT NULL UNIQUE,
	provider VARCHAR(255) NOT NULL UNIQUE
	);
CREATE TABLE authorities(
	id INT AUTO_INCREMENT,
	authority VARCHAR(50),
	create_date DATETIME DEFAULT NOW(),
	modify_date DATETIME,
	remove_date DATETIME, PRIMARY KEY (id)
);
CREATE TABLE user_authorities(
	id INT AUTO_INCREMENT,
	user_id INT NOT NULL,
	authority_id INT NOT NULL,
	create_date DATETIME DEFAULT NOW(),
	modify_date DATETIME,
	remove_date DATETIME, PRIMARY KEY (id), FOREIGN KEY (user_id) REFERENCES users(id), FOREIGN KEY (authority_id) REFERENCES authorities(id)
);		