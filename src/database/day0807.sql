drop DATABASE if EXISTS mydb0807; --코드를 실행할때 기존 내용 지우고 보여줌. 만약 존재하면 삭제해라.
create DATABASE mydb0807;
use mydb0807;
create Table test(
    no int AUTO_INCREMENT,
    constraint PRIMARY KEY(no),
    name VARCHAR (30) not NULL UNIQUE,
    count int DEFAULT 2
);

-- DML : 조작어,
--      1)insert - 레코드삽입  2)select - 레코드조희  3)update - 레코드수정  4)delete - 레코드삭제
--      * 레코드 : 테이블 내 행/열 단위
# 1. insert : insert into 테이블명 (속성명1,속성명2) values (값1,값2)
insert into test ( no,name, count) VALUES (1,"유재석",10); -- table만들때 작성한 속성명/순서 과 동일
insert into test ( name, count ) VALUES ("강호동",20 ); -- 번호 : atuo_increment 로 자동생성
insert into test( name ) VALUES ("신동엽"); -- 번호(auto_increment ),개수 (default)
insert into test VALUES(4,"하하",30); -- 속성명순서 = 속성값순서 -> 속성명 생략 가능 **전체 값 직접 넣을때만 가능
insert into test (name )VALUES("박명수"),("황소연"),("권유린"); -- 여러개 레코드 한번에 삽입

# 2. select: select*from 테이블명
SELECT * from test; -- * : 테이블 내 모든 레코드 조회
SELECT name from test; -- name속성 내 레코드 조회
select name, count  from test; -- 한번ㅇㅔ 여러속성 레코드 조회가능
SELECT * from test WHERE name = "유재석"; -- 전체(*)에서 name이 "유재석"일때만 조회
SELECT *from test where count >= 5; -- 전체(*)에서 count 가 5이상이면 조회

# 3. update : update 테이블명 set 속성명 = 새로운값, where 속성명 = 새로운값 조건
update test set count = 10; -- 조건 없으면 모든 count=10 으로 수정
update test set count = 30 where name = "유재석";
update test set count = 40, name ="강호동2" where no = 2;-- no=2일때 count=40,name="강호동"으로 한번에 수정가능

# 4. delete : delete from 테이블명 where 조건
-- DELETE from test; -- 조건 없으면 test 테이블 내 모든 레코드 삭제
delete from test where name = "유재석" -- name = "유재석"이면 삭제
-- (DML)DELETE: 테이블내 레코드 삭제 vs (DDL)truncate table : 테이블내 레코드 삭제 vs drop table: 테이블 자체를 삭제
-- *DML: ROLLBACK(취소) 가능  DDL: 불가능

# SQL 연산자
# 1. 회원테이블
create table member(    # 아이돌 그룹
 mid char(8) not null ,   # 식별키   최대 8자리
    mname varchar(10) not null , # 그룹명  최대 10자리
    mnumber int not null ,   # 인원수  정수 +-21억정도
    maddr char(2) not null ,   # 지역  최대 2자리
    mphone1 char(3) ,    # 지역번호 최대 2자리
    mphone2 char(8) ,    # 전화번호  최대 8자리
    mheight smallint ,    # 평균키   정수 +-3만정도
 mdebut date ,     # 데뷔일   yyyy-mm-dd
    constraint primary key ( mid )    # 제약조건
);


# 2. 구매테이블
create table buy(
 bnum int auto_increment ,    # 구매번호 정수  자동번호 부여
    mid char(8),      # 구매자  FK
    bpname char(6) not null ,   # 제품명  최대 6자리
    bgname char(4) ,      # 분류명   최대 4자리
    bprice int not null ,    # 가격   정수
    bamount smallint not null ,   # 구매수량 정수
    constraint primary key(bnum) ,     # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);

# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# 1. as 별칭 키워드 : 조회 결과의 속성명 변경, as 생략하고 띄어쓰기 사용가능
SELECT mid from member; -- member 테이블의 mid 속성 레코드 조회
SELECT mid as 회원아이디 from member; -- 속성mid 의 별칭을 '회원아이디'로 설정
select mid as 회원아이디 from member as 회원테이블; -- SQL내 속성명/테이블명 별칭 설정
SELECT mid 회원아이디 from member 회원테이블; --as 생략, 띄어쓰기로 별칭설정 가능

# 2. distinct : 조회결과의 속성값 중복 제거
select maddr from member;

# 3. 산술연산자: + - / * div:몫 mod:나머지
select mnumber 인원수, mnumber+3 더하기, mnumber-2 빼기, mnumber/3 나누기,
    mnumber*3 곱하기, mnumber div 3 몫, mnumber mod 3 from member; --as 생략되어 있음(띄어쓰기)

# 4. 비교연산자 : = != > < >= <=
# 5. 논리연산자 : and or not 
select * from member where mname = "블랙핑크"; --mname = "블랙핑크" 인 레코드 조회
select * from member where mnumber = 4;
select * from member where mname != "블랙핑크";
select * from member where not mname = "블랙핑크";
select * from member where mheight <= 162;
select * from member where mheight >=165 and mheight <170;
# =
select * from member where mheight between 165 and 170; -- 속성명 between 시작값 and 끝값

select * from member where maddr = "경기" or maddr = "전남" or maddr = "경남";
# = 
select * from member where maddr in ("경기", "전남", "경남"); -- 속성명 in (값1, 값2, 값3)\

# (x) select * from member where mphone1 = null;
select * from member where mphone1 is null; 

-- 속성명 like "문자패턴"
--      ** %: 모든문자대응  _:개수만큼 문자대응
select * from member where mname like "에이%"; -- '에이'로 시작하는 모든 문자
select * from member where mname like "에이_"; -- '에이'로 시작하는 3글자
select * from member where mname "%이%"; -- '이'가 포함된 모든 문자  ex)에이핑크,이즈나,라이즈...
select * from membeer where mname like "_이__"; -- 두번째 글자가 '이'인 4글자 