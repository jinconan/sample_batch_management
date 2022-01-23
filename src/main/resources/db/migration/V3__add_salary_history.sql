CREATE TABLE IF NOT EXISTS sample.salary_history (
    id    INT NOT NULL AUTO_INCREMENT,
    type  VARCHAR(100) NOT NULL default '월급',
    money INT DEFAULT 0,
    emp_id INT NOT NULL,

    create_at DATETIME NOT NULL default now(),
    updated_at DATETIME NOT NULL default now(),
    PRIMARY KEY (id)
);