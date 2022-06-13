
create table tbl_board (
	bno number primary key, -- �۹�ȣ(pk)
	title varchar2(100) not null, -- ������
	content varchar2(4000), -- �� ����()
	writer varchar2(50) not null, -- �ۼ���
	regdate date default sysdate, -- �ۼ���
	viewcnt number default 0 -- ��ȸ��
);

-- �� ��ȣ�� ������
create sequence seq_board_bno;

-- ������ ��ü ����
truncate table tbl_board;

-- ������ ���� ����
drop sequence seq_board_bno;
create sequence seq_board_bno;


-- ��� ����~

ALTER TABLE TBL_BOARD 
ADD (RE_GROUP NUMBER default 0);

ALTER TABLE TBL_BOARD 
ADD (RE_LEVEL NUMBER default 0);

ALTER TABLE TBL_BOARD 
ADD (RE_SEQ NUMBER default 0);

UPDATE TBL_BOARD SET
RE_GROUP = BNO;
-- ~��� ����


-- ÷������ ���̺�

create table tbl_attach(
	filename varchar2(50) primary key,
	bno number references tbl_board(bno)
);




