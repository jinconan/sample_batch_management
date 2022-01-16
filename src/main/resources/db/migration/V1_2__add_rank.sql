CREATE TABLE IF NOT EXISTS sample.rank (
    id    INT NOT NULL AUTO_INCREMENT,
    name  VARCHAR(100) NOT NULL,
    salary INT DEFAULT 0,

    create_at DATETIME NOT NULL default now(),
    updated_at DATETIME NOT NULL default now(),
    PRIMARY KEY (id)
);

ALTER TABLE sample.employee ADD IF NOT EXISTS rank_id INTEGER;

DELETE FROM sample.rank;
INSERT INTO sample.rank(name, salary) VALUES('사원', 100);
INSERT INTO sample.rank(name, salary) VALUES('대리', 150);
INSERT INTO sample.rank(name, salary) VALUES('과장', 200);
INSERT INTO sample.rank(name, salary) VALUES('차장', 250);
INSERT INTO sample.rank(name, salary) VALUES('부장', 300);
INSERT INTO sample.rank(name, salary) VALUES('사장', 350);