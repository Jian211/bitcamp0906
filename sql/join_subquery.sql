-- [실습] join & sub query

-- 1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.
-- (5) 박지성이 구매한 도서의 출판사 수.

--       박지성의 custid 와 orders의 custid 비교  bookid가 필요
select o.bookid
from customer c, orders o
where c.custid = o.custid
and c.name = '박지성';

--      orders의 bookid와 book의 bookid비교 
select 
    count(publisher)
from
    book b,
    (select o.bookid
    from customer c, orders o
    where c.custid = o.custid
    and c.name = '박지성') o
where
    b.bookid = o.bookid;
    
-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매 가격의 차이


    -- 1.구매한 도서 가격과, 책아이디 추출   > sub query 용도
    select o.bookid, o.saleprice
    from customer c, orders o
    where c.custid = o.custid 
    and c.name = '박지성';
    
    
    -- 2. 이름과 가격차 뽑기
    select b.bookname, b.price - o.saleprice as pricegap
    from 
        book b,
        (select o.bookid, o.saleprice
        from customer c, orders o
        where c.custid = o.custid 
        and c.name = '박지성') o
    where 
        b.bookid = o.bookid;
  
        
-- (7) 박지성이 구매하지 않은 도서의 이름
    select * from book;
    
    -- 박지성이 구매한 책 id 추출
    select o.bookid
    from customer c, orders o
    where c.custid = o.custid 
    and c.name = '박지성';
    
    -- 구매하지 않은 책 제목 ( 박지성이 구매한 책의 id가 필요)
    select 
        b.bookname
    from 
        book b,
        (select o.bookid
        from customer c, orders o
        where c.custid = o.custid 
        and c.name = '박지성') o
    where 
        b.bookid != o.bookid
  -- 책이 왜 전체 출력될까
    group by 
        b.bookname;
        
-- 마당 서점의 운영자와 경영자가 요구한는 다음 질문에 대해 SQL문을 작성하시오.
--(8) 주문하지 않은고객의 이름 (부속질의 사용 - 서브쿼리)
      -- 오더 테이블에서 주문한 고객id 뽑아오기
      select c.name    
      from customer c,(select o.custid
                        from orders o 
                    ) o
      where c.custid != o.custid
      group by c.name;
            
      select c.name
      from customer c
      where 
         c.custid != (select c.name
         from orders o 
         where o.custid = 5
        )
      ;
           
      select * from customer;
      

-- (9) 주문금액의 총액과 주문의 평균금액
select 
    (select sum(saleprice)
        from orders
    ) as total,
    (select sum(saleprice)from orders) / (select count(orderid) from orders
    ) as AVGSALEPRICE
from dual;
      

-- (10) 고객의 이름과 고객별 구매액
select
    c.name,
    sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
;










      