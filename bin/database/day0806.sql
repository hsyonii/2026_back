# [1] 데이터 베이스 삭제
drop database if exists mydb0805; # ctrl+enter : 실행
# [2] 데이터베이스 생성
create database mydb0805;
# [3] 데이터베이스 목록 보기
show database;
# [4] 사용할 데이터베이스 선택
use mydb0805;

# DDL
# 1. 테이블 생성: 테이블 생성할 데이터베이스 활성화. create table 테이블명(속성명 타입, 속성명 타입);
create table test1(필드명1 int , 필드명2 double, 필드명3 text);

# 2. 테이블 목록 조회
show tables;

# 3.
describe test1;

drop table test1;

# 예제) 회원제 게시판 서비스
drop DATABASE if EXISTS boardService0805; #데이터 베이스 존재하면 삭제
CREATE DATABASE boadService0805; #데이터 베이서 생성
use boardService0805; #데이터베이스 활성화
#회원테이블 생성
CREATE Table member(
    mno int auto_increment , --자동회원번호
    constraint PRIMARY KEY (mno) --회원번호 PK 설정
    mid varchar (30) not null UNIQUE, -- 회원아이디, varchar(30): 최대30글자, not null : 공백X, UNIQUE: 중복불가능 설정
    mpw varchar(20) not null , -- 회원 비번
    mname varchar(10) not NULL,
    mdate DATETIME DEFAULT now()
);

#게시물 테이블
create table board (
    bno int AUTO_INCREMENT, --auto_increment : 자동번호 매김
    constraint primary KEY(bno), -- 게시물 번호 pk 설정 *테이블 1개당 pk 1개이상 권장*
    btitle varchar(255),
    bcontent longtext, --게시물 내용, longtext: 대용량(사진)포함 최대 4기가 까지
    bdate DATETIME DEFAULT now(),
    bview int DEFAULT 0 , --게시물 조회수
    mno int , --작성자(회원번호)  / 관례적으로 PK-FK 필드명 동일
    constraint FOREIGN KEY(mno) REFERENCES member (mno) -- member 의 mono 를 참조
        on delete CASCADE -- 회원 탈퇴 시 작성 게시물도 같이 삭제
    
)