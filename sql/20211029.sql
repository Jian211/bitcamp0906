-- 10월 29일 금요일

select *
from dual;

-- 함수는 단일행 함수, 집합 함수로 나뉠수 있다.

-- 단일행 함수 : 숫자, 문자, 날짜 ,변환 

-- 숫자 함수
select ABS(-52.2) from dual;      -- 절대값으로 출력된다. 
select floor(35.93) from dual;    -- 소수점을 날려버린다.
select round(32.293) from dual;   -- 반올림
select round(32.293,1) from dual; -- 두번째 들어가는 매개변수로 자릿수를 정함
select trunc(15.6789) from dual;  -- 소수점자리를 그냥 잘라버림 
select trunc(15.6789,2) from dual;-- 자릿수 자르기 
select MOD(11,4) from dual;       -- 11 나누기 4 의 나머지를 출력

-- 데이터베이스에서 함수하나를 잘 사용하면 자바에서 손댈일이 적어지며, 속도도 빨라진다.

-- 문자 함수
select lower(ename) , UPPER(ename)from emp; -- lower 소문자로 변환한다.
select concat(ename,'손흥민 입니다.') from emp;
select ename || ' is a ' from emp;
select concat('나의 이름은', ename) from emp;
select lpad('page 1',15,'*') from dual;
select rpad('page 1',15,'*') from dual;
select rpad('001111-3',14, '*') from dual;

select SUBSTR('ABCDEFG',3,4) from dual;
select substr('930211-3001234',1,8) from dual;
select substr(hiredate,1,2) from emp;

select rpad(substr('930211-3001234',1,8), 14,'*') from dual;
select rpad(substr(name, 1,2),5,'*' ) from customer; -- 한글은 2byte씩이다.
select lTRIM('     =from=     ') from dual;
select rTRIM('     =from=     ') from dual;
select TRIM('+' from '+++++from+++++') as a from dual;
select REPLACE('JACK and JUE','J','BL') from dual;  -- 
select replace('010-0000-0000','-','') from dual;

-- 날짜 함수
select replace(sysdate,'/','-') from dual;
select sysdate-30 from dual;
select add_months(sysdate, 4) from dual;
select LAST_DAY(SYSDATE) - sysdate  from dual; -- 이번달 몇일 남았는지 구하기

-- 형 변환 함수 
-- 문자 > 날짜
select to_date('2021/10/29','yyyy mm dd') from dual;

-- 날짜 > 문자
select to_char(sysdate,'yyyy.mm.dd. day dy AM PM HH HH24:mi:ss') from dual;
select to_char(sysdate,'yyyy.mm.dd. am HH24:MI') from dual; -- 2021.10.29. 13:00 
select hiredate,to_char(hiredate,'yyyy.mm.dd') from emp;

-- 숫자 > 문자 
select to_char(100000,'0,000,000') from dual; -- 
select to_char(100000,'9,999,999') from dual; 
select to_char(100000.123,'L9,999,999') from dual;
select sal, to_char( sal*1200 ,'L9,999,999') from emp; 

-- 2021.01.01~ 오늘 현재까지 몇일이 
select trunc(sysdate - to_date('1993-02-11','yyyy-mm-dd')) from dual;

-- decode와 case 활용
select ename, deptno,
    decode(deptno,  10, 'ACCOUNTING',
                    20, 'RESEARCH',
                    30, 'SALESE',
                    40, 'OPERATIONS'
    ) as "dName"
from emp;

-- 8. 직급에 따라 급여를 인상하도록 하자. 직급이 'ANAIYST'인 사원은 5%, 
-- 'SALESMAN' 인 사원은 10%, 'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인 인상한다.
select ename, job,
    decode( job, 'ANAIYST', sal * 1.05,
                 'SALESMAN', sal * 1.1,
                 'MANAGER', sal * 1.15,
                 'CLERK', sal * 1.2
    ) as upSal
from emp;

-- case 컬럼이름 when 조건1 then 결과1
select ename, sal,
    case 
        when sal >= 3000 then sal * 10
        when sal <= 3000 then sal * 0.1
    end as cor
from emp;


-------------------------------------------------------
-- 그룹 함수( 집합 함수)
-- 하나의 행의 컬럼이 대상이 아니고, 행 그룹의 컬럼들이 대상
-------------------------------------------------------
select 
    to_char(sum(sal) * 1200, 'L999,999,999') as "월급여 총액",
    to_char(round(avg(sal) * 1200),'L999,999,999') as "월급여 평균",
    count(*) as "총 사원의 수",
    count(comm) as "커미션 등록 수",  -- 14개 행 중에는 4개 의 값을 빼고 null이다. null은 포함되지 않는다.
    sum(comm) as "커미션 합",
    avg(comm) as "커미션 평균",
    max(sal) as "가장 높은 급여",
    min(sal) as "가장 낮은 급여"

from emp;

select 
    sum(sal),
    sum(nvl(comm,0)),
    count(nvl(comm,0)),
    trunc(avg(nvl(comm,0)))
from emp;

select count(distinct job)
from emp;

select deptno
from emp
group by deptno;

select deptno, avg(sal)
from emp
group by deptno;




