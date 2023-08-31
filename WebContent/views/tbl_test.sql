create table tbl_test(
    no number(38) primary key
    , title varchar2(200) not null
    , content varchar2(4000) not null
    , regdate timestamp default sysdate
    );


select * from tbl_test order by no desc;