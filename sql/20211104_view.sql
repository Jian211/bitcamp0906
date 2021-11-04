--  21.11.04

--  view : 물리적인 데이터 테이블에서 select의 결과로 만드는 가상테이블
--  목적 1: 복잡한 sql문을 간단히 사용하기 위해.
--  목적 2: 보안이 필요한 컬럼의 데이터를 보호하기 위해. (보안에 유리)

--  create [or replace] view view_name as (sub query)

--  자주사용되는 30번 부서에 소속된 사원들의
--  사번과 이름, 부서번호를 출력하기 위해,
--  select문을 하나의 뷰로 정의해봅시다.

    select empno, ename, deptno         --  자주사용되는 테이블!
    from emp
    where deptno = 30;
    
    
    create or replace view emp_view30   -- view생성
    as  (select empno, ename, deptno 
         from emp
         where deptno = 30 );

--  가상테이블 view를 이용하여 질의
    select * from emp_view30;
    select * from emp_view30 where ename = 'BLAKE';
    select * from emp_view30 where empno between 7000 and 8000;
    
    select * from user_views;   --  사용자의 view를 확인가능
    select text from user_views where view_name = 'EMP_VIEW30';


--  view 삭제
    drop view emp_view30;
    
--  입사일이 빠른 5명 구하기
    select rownum, ename, hiredate    -- oracle내에서 자동으로만드는 rownum
    from     emp 
    order by rownum;    
 
    select rownum, ename, hiredate
    from   (select * from emp order by hiredate)   -- inline view
    where  rownum < 6;
    

--  급여액 top3
    select rownum, ename, sal, job
    from   (select * from emp order by sal)
    where  rownum < 3;
    
    
--  입사일 기준으로 정렬한 가상 테이블
    create or replace view emp_hire
    as
    select * from emp order by hiredate;
    
    select ename, hiredate from emp_hire where rownum <= 5;
    
    
    
--  
    select * from user_views;
    
    select * from phoneinfo_view;
    
    select * from emp;
    
    select ename, sal from emp
    order by sal;
    
    select rownum, ename, sal
    from ( select ename, sal from emp
            order by sal)
    where rownum < 5;
    
    