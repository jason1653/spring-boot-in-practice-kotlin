CREATE TABLE COURSES (
                         ID          BIGINT NOT NULL AUTO_INCREMENT,
                         CATEGORY    VARCHAR(255),
                         DESCRIPTION VARCHAR(255),
                         NAME        VARCHAR(255),
                         RATING      INTEGER NOT NULL,
                         PRIMARY KEY (id)
);