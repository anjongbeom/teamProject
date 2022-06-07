-- ����Ʈ

create table tbl_point_code (
	pcode number primary key,
	pdesc varchar2(100) not null
);



create table tbl_point(
	pid number primary key,
	userid varchar2(50) references tbl_member(userid),
	point number default 0,
	pcode number references tbl_point_code(pcode),
	pointdate date default sysdate
);

create sequence seq_point_pid;

insert into tbl_point_code(pcode, pdesc)
values (1001, "���� ������");
insert into tbl_point_code(pcode, pdesc)
values (1002, "���� �б�");





