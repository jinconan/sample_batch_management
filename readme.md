# 스프링 배치 샘플 백엔드

## Specification
|항목|설명|
|---|---|
|DB|MariaDB 10.6.5|
|Protocol|WebSocket|

## Database
>로컬 환경의 Virtual Machine 내부에 Docker 설치 후 MariaDB 컨테이너 운용

### 1. 컨테이너 실행
```shell
docker run --name mariadb \
-v ~/Docker-volumes/mariadb/data:/var/lib/mysql \
-p 3306:3306 \
-e MARIADB_ROOT_PASSWORD=mariadb \
-d mariadb
```

### 2. database & 계정 생성 및 권한 부여
``` text
# 데이터베이스 db_name 생성
create database db_name;

# 계정 user_name을 input_password 패스워드로 생성
create user 'user_name'@'XXX.XXX.XXX.XXX' identified by 'input_password';
create user 'user_name'@'localhost' identified by 'input_password';
create user 'user_name'@'%' identified by 'input_password';

# 권한 추가
grant all privileges on db_name.* to 'user_name'@'XXX.XXX.XXX.XXX';
flush privileges;
```

