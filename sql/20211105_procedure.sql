--  21.11.05

--  procedure   : 데이터를 받아서 프로그램 요소를 이용하여 데이터 변경처리를 한다.

--  create or replace procedure_name(
--     변수이름 in 속성
--  )
--  as
--  begin  프로그램 코드시작
--  ...
--  ...
--  end; 

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
    

--  프로시저 호출 : 실행요청 
--  exec 프로시저이름(매개변수 값, ...)

exec insertbook(13,'스포티비','스포티비채널',19990);

select * from book;
-- 같은이름의 책을 등록해보고, 다른 이름의 책을 입력.

--  같은이름의 책 등록  > 하눈데 왜 그로지 이솽하네
exec bookinsertorupdate (14, '스포티비','스포티비채널',1000);
exec bookinsertorupdate (17,'스포츠즐거움','축구',30000);

delete from book
where bookname = '스포티비';

-----------------------------------------------------------------------------

set serveroutput on;
declare 
    avgVal  number;
begin
    -- 프로시저 호출
    avgPrice(avgVal);
    dbms_output.put_line('책값 평균 :'||avgVal);
end;

set serveroutput on;
exec interest;