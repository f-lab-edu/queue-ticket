create table member
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    login_id VARCHAR(25)  NOT NULL,
    password VARCHAR(255) NOT NULL ,
    name     VARCHAR(100) NOT NULL,
    email    VARCHAR(50) NOT NULL,
    phone    VARCHAR(12),
    address  VARCHAR(500)
);