-- 2021. 11.01
-- 서브 쿼리 ( 부속 질의 ) : select 구문 안에 또 다른 구문을 이용하는 sql문

-- scott 사원의 부서를 출력
select dname
from emp, dept
where emp.deptno = dept.deptno and ename = 'SCOTT';

-- 서브쿼리 사용
select dname
from dept
where deptno = (
                 select deptno
                 from emp
                 where ename = 'SCOTT'
                );

-- SCOTT 사원의 부서이름                
-- 1. 내부 쿼리를 먼저 작성 : 스컷 사원의 부서번호
-- 2. 외부 쿼리 작성 : 부서 번호로 부서이름을 검색

-- 서브쿼리 종류
-- 1. 스칼라 select 
-- 2. 인라인 from 
-- 3. nested where

-- view란 물리적인 테이블에서 여러 조건식을 통해 나온 결과를 view테이블로 만들 수 있다. 


-- 마당서점의 고객별 판매액을 보이시오( 결과는 고객이름과 고객 별 판매액을
select * from customer;
select * from orders;

select custid, 
    (select name from customer c where o.custid = c.custid) as name,
    sum(o.saleprice)
from orders o
group by custid;

-- 위에 것을 join으로
select o.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by o.custid, c.name;

-- 사원의 이름과 부서 이름을 출력
-- 서브쿼리
select
    ename,
    (select dname from dept d where emp.deptno = d.deptno)
from emp;

-- JOin
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno;

-- 인라인 뷰 : from 뒤에 오는 서브쿼리
-- 고객번호가 2 이하인 고객의 판매액을 보이시오 ( 고객이름과 고객별 만매액 출력)

select custid, name from customer where custid < 3;

select o.custid , sum(o.saleprice)
from orders o, 
    ( select custid, name from customer where custid < 3) c        
where o.custid = c.custid
group by o.custid;

-- 30번 부서의 인라인 뷰를 만들어서 사용
select *
from (select * from emp where deptno = 30);






