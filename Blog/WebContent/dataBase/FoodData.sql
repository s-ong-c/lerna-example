 --준석
CREATE TABLE idData(
id varchar2(15) PRIMARY KEY,
pass varchar2(30),
name varchar2(30),
email varchar2(30),
nickname varchar2(50),
writedate date default sysdate,
admin	number(1) default 0, -- 0:일반회원  1:업주회원  2:관리자
address varchar2(200),
companyName varchar2(60),
companyPhone varchar2(15)
);

insert into idData(id,pass,name,email,nickname,address) values('alstjr','1234','민석','alstjr@naver.com','강아지','경기도');
insert into idData(id,pass,name,email,nickname,address) values('guwsjd','1234','현정','guswjd@naver.com','고양이','경기도');
insert into idData(id,pass,name,email,nickname,address) values('dmlgml','1234','의희','dmlgml@naver.com','송아지','경기도');
insert into idData(id,pass,name,email,nickname,address) values('wnstjr','1234','준석','wnstjr@naver.com','박보검','경기도');
insert into idData(id,pass,name,email,nickname,address) values('wnstjr1','1234','준석','wnstjr@naver.com','박보검','경기도');
insert into idData(id,pass,name,email,nickname,admin,address) values('wnstjr7926','1234','준석','wnstjr@naver.com','박보검',3,'경기도');
insert into idData(id,pass,name,email,nickname,admin,address) values('wnstjr6','1234','준석','wnstjr@naver.com','박보검',3,'경기도');
insert into idData(id,pass,name,email,nickname,admin,address) values('wnstjr7','1234','준석','wnstjr@naver.com','박보검',6,'경기도');
select * from idData;

--게시판번호에 쓸 시퀀시
create sequence BoardData_seq start with 1 increment by 1; 
--다같이
CREATE TABLE BoardData(
num number(5) PRIMARY KEY,
id VARCHAR2(15) CONSTRAINTS "free_userid" REFERENCES idData(id) on delete cascade,
--FOREIGN KEY (forid) REFERENCES idDate(id) ON UPDATE CASCADE,
title varchar2(50),
content varchar2(1000),
readcount number(4) default 0,
writedate date default sysdate,
fileRoad varchar2(400),
boardkind number(1)
);

insert into BoardData(num,id,title,content,boardkind) values(BoardData_seq.nextval,'wnstjr','Free첫번째글','내용없음',1);
insert into BoardData(num,id,title,content,boardkind) values(BoardData_seq.nextval,'alstjr','Free두번째글','내용없음',2);
insert into BoardData(num,id,title,content,boardkind) values(BoardData_seq.nextval,'dmlgml','Free세번째글','내용없음',3);

insert into BoardData(num,id,title,content,boardkind) values(BoardData_seq.nextval,'wnstjr','Free첫번째글','내용없음',1);
insert into BoardData(num,id,title,content,boardkind) values(BoardData_seq.nextval,'alstjr','Free두번째글','내용없음',2);
insert into BoardData(num,id,title,content,boardkind) values(BoardData_seq.nextval,'dmlgml','Free세번째글','내용없음',3);

select * 
from BoardData free inner join idData id on free.id=id.id;


--탈퇴통계에 쓸 시쿼시
create sequence statics_seq start with 1 increment by 1; 

create table statics(
	num number(5) PRIMARY KEY,
	outNum number(1),
	content varchar2(1000),
	admin number(1)
)
select * from statics;


create table acount(
	today varchar2(24) PRIMARY KEY,
	todaycount number(12)
)







select * from acount;










create table total(
	total varchar2(5) PRIMARY KEY,
	totalacount number(14) default 0
	);
	
	insert into total values('main',1);
	
	
	
select * from total;

--  초기화 하고 새롭게 등록하고 싶을때 사용
drop table total;
drop table acount;
drop table FreeBoardData;
drop table FreeBoard;
drop table PhotoBoardData;
drop table ShareBoardData;
drop table fileBoardData;
drop table BoardData;
drop table statics;
drop table idData;


drop sequence FreeBoardData_seq;
drop sequence FreeBoard_seq;
drop sequence ShareBoardData_seq;
drop sequence PhotoBoardData_seq;
drop sequence BoardData_seq;
drop sequence statics_seq;
