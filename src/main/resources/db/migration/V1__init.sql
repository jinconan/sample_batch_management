CREATE TABLE IF NOT EXISTS sample.employee (
    id    INT NOT NULL AUTO_INCREMENT,
    name  VARCHAR(100) NOT NULL,
    money INT DEFAULT 0,
    dept_id INT,

    create_at DATETIME NOT NULL default now(),
    updated_at DATETIME NOT NULL default now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sample.department (
    id       INT NOT NULL AUTO_INCREMENT,
    name     VARCHAR(100) NOT NULL,
    location VARCHAR(100),

    create_at DATETIME NOT NULL default now(),
    updated_at DATETIME NOT NULL default now(),
    PRIMARY KEY (id)
);
