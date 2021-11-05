--  21.11.05

desc book;
--  book테이블에 한 개의 튜플을 삽입하는 프로시저
create or replace procedure insertbook(
    mybookId    in number,
    mybookName  in varchar2,
    myPublisher in varchar2,
    myPrice     in number
) -- 선언문
as
begin -- 코드 실행
    insert into book ( bookid, bookname, publisher, price )
    values ( mybookid, mybookname, myPublisher, myprice );
end;  -- 코드 종료
    
