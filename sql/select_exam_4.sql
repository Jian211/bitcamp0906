-- select exam4

-- 32. equi 조인을 사용하여 scott 사원의 부서번호와 부서 이름을 출력하시오.
-- 사원의 부서번호, 부서 이름

select e.ename,
       e.deptno,
       d.dname
from emp e, dept d
where e.deptno = d.deptno 
and e.ename = 'SCOTT';

-- ansi 이용



-- 33. INNER JOIN과 on 연산자를 사용
-- 사원이름과 함께 그 사원이 소속된 부서이름과 지역명을 출력하시오.
-- inner join은 on명령어가 꼭 들어가야 오류가 나지 않는다.

select e.ename, d.deptno, d.loc -- 사원이름, 소속부서명, 지역명
from emp e inner join dept d 
on e.deptno = d.deptno
order by deptno;


-- 34. 
-- 35.

-- 36. 조인과 WildCARD를 사용하여 이름에 'A'가 포함된 모든 사원의 이름과 부서명을 출력
-- 모든사원이름, 부서명  select
-- dept와 emp  from
-- a가 포함된 where like

select e.ename, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename like '%A%'
order by e.ename;



-- 37. join을 이용하여 newyork에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명출력

select e.ename, d.dname, e.job, e.deptno, d.loc
from emp e join dept d
on e.deptno = d.deptno
where d.loc = 'NEW YORK';


-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름(번호?)을 출력하시오.
select * from emp;

select employee.ename as " 사원이름",
       employee.deptno as "사원번호",
       manager.ename as "관리자 번호"
from emp employee, emp manager
where employee.ename = manager.ename;


-- 39. outer join, self join을 사용하여 관리자가 없는 사원을 포함,
--     사원번호를 기준으로 내림차순 정렬하여 출력.

select employee.ename as " 사원이름",
       employee.deptno as "사원번호",
       manager.mgr as "관리자 번호"
from emp employee, emp manager
where employee.ename = manager.ename(+)
order by employee.deptno;


-- 40. SELF JOIN을 사용, 지정된 사원( SCOTT )
--     지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원 출력

select e.ename as "지정된 사원",s.ename, e.deptno
from emp e, emp s
where e.ename = 'SCOTT'
and e.deptno = s.deptno
and s.ename != 'SCOTT';


-- 41. self join을 사용하여 ward 사원보다 늦게 입사한 사원의 이름과 입사일을 출력
select e.ename, e.hiredate
from emp e,emp w
where e.hiredate > w.hiredate
and w.ename = 'WARD';


-- 42. self join을 사용하여 
--      관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을
--      관리자의 이름 및 입사일과 함께 출력하시오
select m.ename mng, m.hiredate mngHireDate, s.ename emp, s.hiredate empHireDate
from emp s, emp m
where m.mgr = s.empno
and s.hiredate < m.hiredate;

