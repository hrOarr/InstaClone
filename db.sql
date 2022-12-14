
DROP TABLE IF EXISTS ROLES;

CREATE TABLE ROLES(
    role_id INT NOT NULL AUTO_INCREMENT,
    name ENUM('ADMIN', 'USER', 'MODERATOR'),
    PRIMARY KEY (role_id)
);

DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS(
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(55) NOT NULL,
    email VARCHAR(55) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS USER_ROLE;

CREATE TABLE USER_ROLE(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS(user_id)
                      ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES ROLES(role_id)
                      ON DELETE CASCADE
);