
create table tbl_board (
	bno number primary key, -- 글번호(pk)
	title varchar2(100) not null, -- 글제목
	content varchar2(4000), -- 글 내용()
	writer varchar2(50) not null, -- 작성자
	regdate date default sysdate, -- 작성일
	viewcnt number default 0 -- 조회수
);

-- 글 번호용 시퀀스
create sequence

-- 데이터 전체 삭제
truncate table tbl_board;

-- 시퀀스 새로 생성
drop sequence seq_board_bno;
create sequence seq_board_bno;


-- 답글 관련~

ALTER TABLE TBL_BOARD 
ADD (RE_GROUP NUMBER default 0);

ALTER TABLE TBL_BOARD 
ADD (RE_LEVEL NUMBER default 0);

ALTER TABLE TBL_BOARD 
ADD (RE_SEQ NUMBER default 0);

UPDATE TBL_BOARD SET
RE_GROUP = BNO;
-- ~답글 관련


-- 첨부파일 테이블

create table tbl_attach(
	filename varchar2(50) primary key,
	bno number references tbl_board(bno)
);




