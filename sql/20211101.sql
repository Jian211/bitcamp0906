-- 2021 11-01 
-- join
-- cross join : 단순히 테이블을 붙이는 Join
--              컬럼을 붙이고, 행(데이터)는 집합의 합 연산(카티즌 곱)
--              전체 행은 붙이려는 테이블 행의 곱이다. 
--              ex) emp table(행 14개)과 dept table(행4개)의 조인
--                  > 14 * 4 = 56(행)
--                  select * from table1, table2

select *
from emp,dept
order by dept.deptno;

-- Equi join : 특정 칼럼의 값들을 비교해서 같은 결과 행만 축출

select *
from emp,dept
where emp.deptno = dept.deptno;

-- Scoot 사원의 부서이름을 출력
select dept.dname
from dept, emp
where dept.deptno = emp.deptno
and emp.ename = 'SCOTT';

-- 테이블 별칭 이용
select *
from emp e, dept d
where e.deptno = d.deptno;

-- Non - equi join : 이퀄 비교가 아니다. 

-- 사원의 급여가 몇 등급인지 살펴보는 예제
select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
order by e.empno;

-- self join : 나 자신을 참조해서 붙이는 조인
select e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno
order by e.mgr
;

-- 결과 행이 13개인 이유는 null은 무조건 false이기 때문이다.

-- outer join
select e.ename as eName, nvl( m.ename, '관리자 없음') as Manager
from emp e, emp m
where e.mgr = m.empno(+)
order by e.mgr
;

-- ANST CROSS JOIN
select *
from emp cross join dept;  --  emp, dept;와 결과가 같다

-- inner join
-- select *  from t1 inner join t2
-- on 컬럼의 비교 조건 (join의 비교)

-- Scott 사원의 사원 정보와 부서 정보를 inner join을 이용해서 출력
select *
from emp join dept  -- inner join은 (inner)를 생략해도된다. 
on emp.deptno = dept.deptno -- inner join은 on 키워드를 붙이지 않으면 오류발생!! 
where emp.ename = 'SCOTT';

-- join 연습









