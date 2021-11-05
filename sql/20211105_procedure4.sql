--  21.11.05

--  orders 테이블의 판매 도서에 대한 이익을 계산하는 프로시저

create or replace procedure interest
as
    myInterest  number;      -- numberic과 차이는?
    price       number;      --  
    cursor      interestCursor is select saleprice from orders;  -- list느낌같다.

begin
    myInterest  := 0.0;
    open    interestCursor;     --  커서 사용하겠습니다.
    
    loop                                    --  반복하면서 cursor의 각 행을 처리
        fetch   interestCursor into price;  --  하나의 행을 받아 price에 대입.
        
        exit when interestCursor%notfound;  --  반복문 탈출 조건 : 행에 값이 없을 때
        
        if price >= 30000 then
            myInterest := myInterest + price * 0.1;    
        else
            myInterest := myInterest + price * 0.05;
        end if;
    
    end loop;
    
    close interestCursor;   -- 커서 종료.
    
    dbms_output.put_line('전체 이익금 : '||myInterest);
end;

