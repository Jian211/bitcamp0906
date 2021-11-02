-- 2021 11.02

-- 중첩질의

-- 평균 급여보다 더 많은 급여를 받는 사원을 검색하는 문장

select avg(sal)from emp;
-- 2073.214285714285714285714285714285714286

select ename, sal
from emp
where sal > (select avg(sal) from emp);

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
-- 평균 주문금액
select avg(saleprice) from orders;

-- 주문금액 이하의 주문에 대해서 주무번호와 금액
select orderid,saleprice
from orders
where saleprice <= (select avg(saleprice) from orders);


-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호
-- 각 고객의 평균 주문금액
-- 조건 : 각 고객의 평균 주문금액보다 큰 금액의 주문내역

select avg(saleprice) from orders where custid = 1;

select custid,orderid, saleprice
from orders o
where saleprice  > (
        select avg(saleprice) from orders a where a.custid = o.custid);



-- 다중행 서브쿼리
-- in, some, any, all, exist

-- 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 직월출력

select distinct(deptno) from emp where sal >= 3000;
select *from emp where deptno = 10 or deptno = 20;

select * from emp where deptno in(
    select distinct(deptno) from emp where sal >= 3000);
    
    
-- 대한민국에 거주하는 고객에게 판맨한 도서의 총 판매액을 구하시오.
-- 대한민국에 거주하는고객
select custid from customer where address like '%대한민국%';

-- 도서의 총 판매액
select sum(saleprice) 
from orders                 
where custid in (select custid from customer where address like '%대한민국%')
;


-- 3번 고객이 주무한 도서의 최고 금액보다더 비싼도서를구입한
-- 3번 고객의 주문 도서의 금액들
select saleprice from orders where custid = '3';

-- 더 비싼 도서를 구입한 주문의 주문번호와 금액
select saleprice
from orders
where saleprice > all (select saleprice from orders where custid = '3');


-- 부서번호가 30번인 사원들의급여 중가장 작은 값보다많ㅇㄴㄴㄱㅂ여를받는사원의일므
-- 부서번호가 30번인 사원들의 급여
select sal from emp where deptno  = 30;

--급여중 가장 작은 값보다 많은 급여를받는 사원의 이름,급여
select ename, sal
from emp 
where sal > any (select sal from emp where deptno  = 30);

 -- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는사
-- 30번소속 사원들의 급여
select sal from emp where deptno = '30';

-- 조건 : 30번 부서의 최고급여보다 큰 급여를 받는
-- 이름과 급여 출력
select ename, sal
from emp
where sal > all (select sal from emp where deptno = '30');

select ename, sal
from emp
where sal > (select max(sal)from emp where deptno = '30');


-- exists 연산자로 대한민국에거주하는고객 
select * from customer where address like '%대한민국%' and custid = 1;

select sum(saleprice)
from orders o
where exists ( select *
               from customer c
               where address like '%대한민국%' and c.custid = o.custid)
;


