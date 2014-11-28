
-- 데이터베이스 생성
create database bookstore;

-- 계정생성
create user 'bookstore'@'localhost' identified by 'bookstore';

-- 특정 디비에 대한 모든권한을 가진계정
GRANT ALL PRIVILEGES ON bookstore.* TO 'bookstore'@'%' IDENTIFIED BY 'bookstore';

-- 설정 적용
flush privileges;

-- 사용자 접속권한 정보 확인
show grants for 'bookstore'@'%';



DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS histories;

create table books (
  id Integer AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) NOT NULL,
  author varchar(50) NOT NULL,
  publishDate timestamp NOT NULLa,
  comment varchar(255),
  status Integer NOT NULL,
  rentUserId Integer
);

create table users (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    password varchar(12) NOT NULL,
    point Integer NOT NULL,
    level Integer NOT NULL
);

ALTER TABLE bookstore.books ADD CONSTRAINT books_users_FK FOREIGN KEY (rentUserId) REFERENCES bookstore.users(id) ON DELETE SET NULL;


create table histories (
    id Integer AUTO_INCREMENT PRIMARY KEY,
    userId Integer NOT NULL,
    bookId Integer NOT NULL,
    actionType Integer NOT NULL,
    insertDate timestamp NOT NULL
);

ALTER TABLE bookstore.histories ADD CONSTRAINT history_userFK FOREIGN KEY (userId) REFERENCES bookstore.users(id);
ALTER TABLE bookstore.histories ADD CONSTRAINT history_bookFK FOREIGN KEY (bookId) REFERENCES bookstore.books(id);

