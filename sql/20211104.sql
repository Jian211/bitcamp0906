--  21.11.04

--  DML :   데이터의 변경 > 데이터 삽입, 수정,삭제
    drop table emp01;
    create table emp01
    as
    select * from emp;

--  update table_name
--  set    column_name = value
--  where  column_name 

--  1. 모든 사원을 30번으로 수정하자
--  모든 사원은 where절을 사용하지 않는 경우
    update emp01
    set    deptno = 30;
    

    update emp01
    set deptno = 40
    where deptno = 30;


--  모든 사원의 급여를 10%인상
    update emp01
    set    sal = sal * 1.1;    


--  모든 사원의 입사일을 오늘로 수정하려면
    update emp01
    set    hiredate = sysdate;
    
    
--  부서번호가 10번인 사원의 부서번호를 30번으로 수정합시다.
    update  emp01
    set     deptno = 30
    where   deptno = 10;  
    
    
--  급여가 3000이상인 사원만 급여를 10% 인상합니다.
    update  emp01
    set     sal = sal * 1.1
    where   sal >= 3000;
    

--  1987년에 입사한 사원의 입사일이 오늘로 수정합니다
--  사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴보자
    update  emp01
    set     hiredate = sysdate
    where   substr(hiredate, 1,2) = 87;
    
    
--  SCOTT 사원의 부서번호는 20번으로 직급은 매니저로 한꺼번에 수정하도록 하자
    update  emp01
    set     deptno = 20,
            job = 'MANAGER'
    where   ename = 'SCOTT';
    

--  SCOTT 사원의 입사일자는 오늘, 급여는 50, 커니션을 4000으로 수정
    update  emp01
    set     hiredate = sysdate,
            sal = 50,
            comm = 4000
    where   ename = 'SCOTT';
    
--------------------------------------------------------------------------------
--  update > sub query 사용
--  설정 : dept01 -> 새로만들기
    drop table dept01;
    create table dept01 as select * from dept;
    select * from dept01;


--  20번 부서의 지역명을 40번부서의 지역명으로 변경하기 위해서 서브쿼리문을 사용해보자    
    update  dept01
    set     loc = ( select loc from dept01 where deptno = 20 )
    where   deptno = 40;
    
    
--  서브쿼리를 이용해서 부서번호가 20인 부서의 부서명과
--  지역명을 부서번호가 40번인 부서번호와 동일하게 변경해보자
    update  dept01
    set     (dname,loc) = ( select dname,loc from dept01 where deptno = 40)
    where   deptno = 20;
  
    
--  행을 삭제하는 delete문 :  행을 삭제하여 커밋한 후에도 테이블의 형태는 남아있다.
    delete from dept01;
    delete from emp01;
    rollback;   -- 마지막 commit된 위치로 이동, 마지막 커밋 후 작업된 DML은 사라진다.
    
    select * from dept01;
    
    
--  부서 테이블에서 30번 부서만 삭제합시다.
    delete from dept01
    where deptno = 30;
    
    commit;
    
--  사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
    delete 
    from    dept01
    where   deptno = (select deptno from dept where dname = 'SALES');
    
    select * from emp01;
    
    
    
    





    
    