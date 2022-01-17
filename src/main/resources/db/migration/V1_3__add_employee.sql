DELETE FROM sample.department;
INSERT INTO sample.department(name, location) VALUES('인사팀', '경기');
INSERT INTO sample.department(name, location) VALUES('총무팀', '경기');
INSERT INTO sample.department(name, location) VALUES('개발팀', '서울');
INSERT INTO sample.department(name, location) VALUES('기획팀', '서울');


DELETE FROM sample.employee;
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('홍우람', 1, 1);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('복달', 1, 2);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('허힘찬', 2, 3);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('권겨울', 2, 4);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('유우리', 3, 1);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('복건', 3, 2);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('허혁', 4, 3);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('성재', 4, 4);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('안그루', 5, 1);
INSERT INTO sample.employee(name, rank_id, dept_id) VALUES('설영신', 5, 2);