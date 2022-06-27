create table non_memberBoard(
    bno number not null primary key,
    writer varchar2(10) not null,
    title varchar2(30) not null,
    email varchar2(30) not null,
    pwd varchar2(12) not null,
    content varchar2(4000) not null,
    reg_date DATE DEFAULT sysdate not null,
    readcount number default 0,
    re_group number not null,
    re_step number default 0,
    re_level number not null);
create sequence seq_sno ;

drop table non_memberBoard;

select * from non_memberBoard;

truncate table non_memberBoard;

create table NON_COMMENT(
cno number not null primary key,
bno number not null,
content varchar2(2000) not null,
adminId varchar2(20) 
);

create sequence seq_cno;