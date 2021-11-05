-- 21.11.05

--  function    : 데이터를 받아서 처리 후 결과를 반환.

create or replace function func_interest(
    price   number
)   return int
is  
    myInterest  number;
begin
    -- 3만원 이상이면 10%, 미만이면 5% 값을 반환
    if price >= 30000 then
        myInterest := price * 1.1;
    else 
        myInterest := price *0.05;
    end if;
    
    return myInterest;      -- 값을 반환
end;