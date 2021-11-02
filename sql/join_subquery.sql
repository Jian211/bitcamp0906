-- [실습] join & sub query

-- 1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.
--------------------------------------------------------------------------------
-- (5) 박지성이 구매한 도서의 출판사 수.

--  join

    select  DISTINCT o.bookid    --  박지성이 구매한 책들
    from    customer c, orders o
    where   c.custid = o.custid
    and     c.name = '박지성';

    select  count(publisher)    --  출판사 의 수
    from    book b,
            (select o.bookid
            from customer c, orders o
            where c.custid = o.custid
            and c.name = '박지성') o
    where   b.bookid = o.bookid;

--  sub query
    select  count( DISTINCT publisher )
    from    book
    where   bookid in ( select DISTINCT o.bookid
                        from customer c, orders o
                        where c.custid = o.custid
                        and c.name = '박지성');
                
--------------------------------------------------------------------------------
-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매 가격의 차이

--  1. 박지성이 구매한 책의 id 구하기.
    select bookid, saleprice
    from orders
    where custid = ( select custid
                     from customer    
                     where name = '박지성'
                    )   
    ;

--  도서의 이름, 가격, 정가와 판매 가격의 차이
    select  bookname, price - o.saleprice as pricegap
    from    book b,
            (select bookid, saleprice
             from orders
             where custid = ( select custid
                              from customer    
                              where name = '박지성')
            ) o   
    where   b.bookid = o.bookid; 

--------------------------------------------------------------------------------
-- (7) 박지성이 구매하지 않은 도서의 이름
    
    --  1. 박지성이 구매한 책의 id 구하기.
    select                      --  북아이디를 찾다. 
        bookid
    from                        --  오더 테이블과 고객테이블에서   
        orders o, customer c    
    where                       --  각 테이블의 id가 같고
        o.custid = c.custid
    and                         --  이름이 박지성이며
        c.name = '박지성';
   
    --  2.  책 테이블과 비교해서 구매하지 않은 도서 찾기
    select  distinct bookname
    from    book,(select    bookid
                  from      orders o, customer c    
                  where     o.custid = c.custid
                  and       c.name = '박지성') o
    where   book.bookid not in( o.bookid );
    
    
    
    
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










      