--  21.11.05

desc book;
--  동일한 도서가 있는 점검한 후 삽입하는 프로시저

create or replace procedure BookInsertOrUpdate(
    myBookId     number,        -- in, out 둘다 사용가능
    myBookName   varchar2,
    myPublisher  varchar2,
    myPrice      number
)
as                 --  begin ~ end 구간에 사용될 변수 선언
    myCount      number;
    
begin               --  입력받은 책 이름으로 같은 이름의 책을 보유하는지의 여부 확인
    select count(*) into myCount
    from book 
    where bookname 
    like myBookName;

    --  책의 개수로 분기 : 수정 또는 입력
    if myCount > 0 then     -- 가격수정
        update  book
        set     price = myPrice
        where   bookname 
        like    myBookName;
    else                    -- 데이터(행) 입력
        insert into book 
        values( myBookId, myBookName, myPublisher, myPrice );
    end if;
end;