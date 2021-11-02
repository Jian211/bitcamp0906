
-- select exam 5

--------------------------------------------------------------------------------
-- 43. 사원번호가 7788인 사원과 담당업무가 같은 사원을표시(사원 이름과 담당업무)


-- 사원번호가 7788인 사원의 job
select job from emp where empno = 7788;

-- 담당업무가같은 사원이름과 업무를표시
select ename, job
from emp
where job = (select job from emp where empno = 7788);


--------------------------------------------------------------------------------
-- 44. 사원번호가7499인 사원보다 급여가 많은 사원을 표시하시오.( 사원이름과 담당 업무)


-- 사원번호가 7499인 사원의 sal
select sal from emp where empno = 7499; -- 1600

-- 급여가많은 사원의 이름과 업무를 표시
select ename, job
from emp
where sal > (select sal from emp where empno = 7499);


--------------------------------------------------------------------------------
-- 45. 최소급여를 받는 사원의 이름, 담당업무 및  급여를 표시하시오. (그룹함수)


-- 최소급여를 받는 사원의 sal
select min(sal) from emp; -- 800

select ename, job, sal
from emp
where sal = (select min(sal) from emp); 

select ename, job, sal
from emp
where sal <=  all(select min(sal) from emp); 


--------------------------------------------------------------------------------
-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.

--이거다시!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
-- 부서별 평균의 최소 평균 값
select avg(sal) from emp group by job;


select min(avg)
from (select avg(sal) from emp group by job) as avg;


--------------------------------------------------------------------------------
-- 47. 각 부서의 최소 급여를 받는 사원의 이름,급여, 부서번호를 표시하시오.


-- 각 부서의 최소 급여 테이블
select min(sal)
from emp
group by deptno;


--------------------------------------------------------------------------------
-- 48. 담당업무가 ANANLYST인 사원보다 급여가 적으면서 업무가
--     ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당업무, 급여)


--  담당업무가 ANALYST인 사원보다 급여가 적은
select distinct sal from emp where job = 'ANALYST';

--  업무가 ANALYST가 아닌 사원을 표시
select e.empno,e.ename,e.job,e.sal
from emp e
where e.sal < all(select sal from emp where job = 'ANALYST')
and e.job != 'ANALYST'
order by e.empno;


--------------------------------------------------------------------------------
-- 49. 부하직원이 없는 사원의 이름을 표시하시오.
--  부하직원이 있는지 체크  == 상사가 있는지 체크 

select distinct mgr from emp where mgr is not null; -- 이 문장 해석

select ename, mgr
from emp
where empno not in (select distinct mgr from emp where mgr is not null);


--------------------------------------------------------------------------------
-- 50. 부하직원이 있는 사원의 이름을 표시

select mgr from emp where mgr is not null;  -- 매니저 확인 

select ename
from emp
where empno in (select mgr from emp where mgr is not null);


--------------------------------------------------------------------------------
--  51. BLACKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오.( 단 BLAKE는 제외)
--  blacke와 동일한 부서에 속한 사원의 이름과 입사일


--  blacke의 부서 출력해보자
select deptno from emp where ename = 'BLAKE';

-- (blake가 속한 부서 '30')에 속한 사원의 이름과 입사일 표시
select ename, hiredate
from emp
where deptno = (select deptno
                from emp 
                where ename = 'BLAKE')
and ename != 'BLAKE';


--------------------------------------------------------------------------------
--  52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되
--      결과를 급여에 대해서 오름차순으로 정렬하시오


--  평균 급여를 구하라.
select avg(sal) from emp;

--  평균급여보다 많은 사원의 사원번호와 이름을 표시
select empno, ename
from emp
where sal > (select avg(sal) from emp)
order by sal;


--------------------------------------------------------------------------------
--  53. 이름에 k가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.


--  이름에 k가 포함된 사원의 부서를 출력
select distinct(deptno) from emp where ename like '%K%';

--  위 부서에서 일하는 사원의 사원번호와 이름
select empno, ename
from emp
where deptno = any(select distinct(deptno) from emp where ename like '%K%');


--------------------------------------------------------------------------------
--  54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.

--  부서위치 찾기 
select deptno from dept where loc = 'DALLAS';

select ename,deptno, job
from emp
where deptno = (select deptno from dept where loc = 'DALLAS');

--------------------------------------------------------------------------------
--  55. KING에게 보고하는 사원의 이름과 급여를 표시

select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING')
order by sal desc;


--------------------------------------------------------------------------------
--  56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.

select deptno from dept where dname = 'RESEARCH';


select empno, ename, job
from emp
where deptno = (select deptno from dept where dname = 'RESEARCH');


--------------------------------------------------------------------------------
-- 57. 평균 월급보다 많은 급여를 받고 이름이 M이 포함된 사원과 같은 부서에서 근무하는
--     사원의 사원 번호, 이름, 급여를 표시하시오.

select avg(sal) from emp;
select distinct deptno from emp where ename like '%M%';

select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
and deptno in(select distinct deptno from emp where ename like '%M%');


--------------------------------------------------------------------------------
--  58. 평균급여가 가장 적은 업무를 찾으시오.

--  job의 각 평균 급여
select avg(sal)
from emp 
group by job;

select job, avg(sal) 
from emp
group by job
having avg(sal) <= all(
                    select avg(sal)
                    from emp 
                    group by job
                    );


--------------------------------------------------------------------------------
--  59. 담당업무가 manager인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.

-- sub-query 사용 
--  job이 manager인 사원이 소속된 부서
select deptno from emp where job = 'MANAGER';

select ename
from emp
where deptno in(select deptno from emp where job = 'MANAGER');








