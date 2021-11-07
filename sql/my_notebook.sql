-- my note book

--  테이블 구조를 살펴볼 수 있는 desc    
--  중복 제거를 위한 키워드  Distinct
--  is null     ->  null 값을 검색 
--  is not null ->  null 값이 아닌 것을 검색
--  not a       ->  A가 아닌 모든 조건을 검색 

--  기억해야하만 하는 함수들
/*
    숫자함수들
    ABS    > 절대 값              ex) -3  > 3  
    FLOOR  > 소수점 아래를 버린다.   ex) 12.314  >  12
    POWER  > power(2,3), 2의 3승  ex) 8
    ROUND  > 특정 자리수에서 반올림  ex) round(2.134, 2) > 2.13
    TRUNC  > 특정 자리수를 버려버림  ex) trunc(2.134, 1) > 2.1
    MOD    > 입력 받는 수를 나눈 나머지 값을 반환
    
    문자함수
    lower   >   소문자로 변환
    upper   >   대문자로 변환
    initcap >   첫 글자만 대문자, 나머지는 소문자
    concat  >   문자값 연결 ||'is a'|| 랑 같음
    substr  >   문자를 잘라서 추출한다.
    length  >   문자의 길이
    trim    >   잘라내고 남은 문자를 표시
    replace >   문자열에서 특정 문자를 변경한다.
    nvl     >   null 값을 특정 값으로 변환하기 위해서 사용하는 함수.
    
    날짜함수
    sysdate >   시스템에 저장된 현재 날짜를 반환한다.
    
    형 변환 함수
    to_char   >   날짜,숫자를 문자형으로 변환   to_char(sysdate,'yyyy-mm-dd')
    to_date   >   문자형을 날짜형으로 변환
    to_number >   문자형을 숫자형으로 변환
    
    decode    >   자바에서 case함수랑 비슷하다. decode(컬럼,컬럼의 값, ....)
    case      >   자바에서 if eles if와 비슷하다
                  case 컬럼 when 조건1 then 결과1
                           when 조건2 then 결과2
                           
    그룹 함수
    sum       > 그룹의 누적 합계를 반환한다.    sum(column)
    avg       > 그룹의 평균을 반환            avg(column)
    count     > 그룹의 행 갯수를 반환
    max       > 그룹의 최댓값을 반환
    min       > 그룹의 최소값을 반환
    stddev    > 그룹의 표준편차
    variance  > 그룹의 분산을 반환
    
*/
-- 소속 부서별 평균급여
select deptno, max(sal) , min(sal)
from emp
group by deptno
having max(sal) > 2900;

-- equi *
select *
from emp, dept
where emp.deptno = dept.deptno;

-- 이름이 SCOTT인 사람의 부서명을 출력
select e.ename, d.dname
from emp e,dept d
where e.ename = 'SCOTT'
and d.deptno = e.deptno;

-- 사원의 급여가 몇 등급인지 살펴보자
select * from salgrade;
select * from emp;

select e.ename, s.grade
from salgrade s, emp e
where e.sal between s.losal and s.hisal;

select ename,dname
from emp inner join dept
on emp.deptno = dept.deptno
where ename = 'SCOTT';

select ename, dname
from emp inner join dept
using(deptno);

select ename, dname
from emp natural join dept;

select *
from dept01 full outer join dept02
on dept01.deptno = dept02.deptno;


-- 고객번호가 2 이하인 고객의 판매액을 보이시오 고객이름과 ㅏ고객별 판매액
select cs.name, sum(od.saleprice)
from (select custid, name from customer where custid <= 2) cs, orders od
where cs.custid = od.custid 
group by cs.name;

select * from orders;



-- DDL
    -- 테이블 생성
        -- 조건명시
    
    -- 테이블 삭제
    
    -- 테이블 수정
        -- 컬럼 삭제
        -- 컬럼 수정
        -- 컬럼 추가
        
    -- 테이블 이름 변경

    -- truncate에 대해 알아보기 
    
    -- 데이터 무결성을 위한 제약조건 5가지
    
    
-- DML


-- DCL


-- 트랜잭션

-- 가상테이블


-- 시퀀스  
    -- sequence?   
    -- create sequence
    -- drop sequence
    -- 시퀀스의 현재 값과 다음 값 

-- 인덱스
    -- index ?  
    -- create index ?
    -- drop index ?
    
--  데이터베이스 프로그래밍
    -- 개념? 
    -- PL/SQL
        -- 프로시저
            -- 프로시저란?            
            -- 프로시저 정의(생성)            
            -- 프로시저 호출            
            -- 제어문을 사용하는 프로시저
                -- 제어문 종류와 사용법        
            -- 결과 반환 프로시져             
            -- 커서를 사용하는 프로시저
                -- 커서생성        
        -- 트리거
            -- 트리거란?           
        -- 사용자 정의 함수
        -- PL/SQL문법
    
    