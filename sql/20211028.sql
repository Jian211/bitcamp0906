 
 -- 2021.10.28
 
 
 -- 로그인한 사용자가 보유하고 있는 테이블 정보 > 메타데이터 테이블 
 select * from tab;
 
 
 --테이블의 구조 확인
 desc dept;
 
 
 select * from emp;
 select * from dept;
 select loc,dname,deptno from dept;
 select * from book;
 select * from customer;
 select * from orders;
 select orderId, custid,saleprice from orders;
 
 
 -- Select 구문에서 컬럼의 산술연산이 가능하다.
 select * from emp;
 select sal, sal + 100,sal - 100, sal * 12, sal / 2 from emp;
 
 -- 우리 회사 사원들의 이름과 월 급여  연봉을 출력하는 리스트로 출력
 select ename, sal, sal * 12 from emp;
 
 select * from emp;
 
 --연봉에 comm , 주의! comm의 값 중에는 Null이 존재한다.
 -- Null : 아직 정해지지 않은 값,  null에 연산을 하면 null이 나온다. 
 
 select ename, sal, sal * 12 , sal * 12 + comm from emp;
 
 -- null 값을 치환해주는 nvl함수 
 -- nvl(컬럼명, 치환할 데이터 값)  => 컬럼 값중 null값은 치환데이터 값으로 변경됨.
 
 select comm, nvl(comm,0) from emp;
 
 -- nvl() 이용해서 null값을 치환해라
 select ename, sal, sal * 12 , sal * 12 + nvl(comm,0) from emp;
 
 select ename as "사원이름",sal as "월급여" , sal * 12 + nvl(comm,0) as "연봉" from emp;  --별칭 사용법 

 select ename name,sal sal , sal * 12 + nvl(comm,0) salOfYear from emp;   --별칭 사용법 
 
 
 -- 문자열을 연결해주는 연산자 || ' ... ' ||
 select ename || ' is a ' || job msg from emp;
 
 
 -- 사원들이 소속된 부서 번호 출력
 select deptno from emp;
 
 select distinct deptno from emp;
 
 select distinct publisher from book;
 
 select distinct deptno, job from emp;
 
 ------------------------------------------------------------
 
 select * from emp;
 
 select ename, sal   -- 출력하고자 하는 컬럼 culumn, 열을 선택
 from emp            -- 대상 table, 테이블을 선택
 where sal > 2900;   -- 조건,  비교연산 또는 논리연산, 행을 선택 
 
 -- 10번 부서의 소속된  >  행을 검색할 조건
 -- 사원의 List를 출력하자.
 
 select * 
 from emp
 where deptno = 10;
 
 -- 이름이 FORD인 사원의 
 -- 사원번호 사원이름 급여 를 출력.
 select empno, ename, sal
 from emp
 where ename ='FORD';  -- 값을 비교시에는 대소문자 구분을 명확하게 해야한다. 그 외는 ㄱㅊ
 
-- 날짜 비교 82년 이후 입사자
select *
from emp
where hiredate > '81/12/31';
 
 -- 10번 부서 소속인 사원들 중에서
 -- 직급이 manager인 사람을 검색하여
 -- 사원명, 부성번호 직급을 출력
 select ename, deptno, job
 from emp
 where deptno = 10 and job = 'MANAGER';
 
 -- 10번 부서에 소속된 사원이거나 
 -- 직급이 매니저인 사람을 검색
 -- 사원명 부서번호 직급 출력
 select ename, deptno,job
 from emp
 where deptno = 10 or job = 'MANAGER';
 
 -- 부서번호가 10번이 아닌 사원의 사원이름 , 부서번호, 직급을 출력
 select ename, deptno, job
 from emp
 where not deptno = 10;
 -- where deptno <> 10;
 -- where deptno != 10;
 
 
 -- 2000에서 3000사이의 급여를 받는 사원
 select *
 from emp
 where sal between 2000 AND 3000; 
 --where 2000 <= sal AND sal <= 3000;
 
 -- 1987년에 입사한 시원을 출력해 봅시다.
 select *
 from emp
 where hiredate between '87/1/1' AND '87/12/31';
 
 -- 커미션이 300이거나 500이거나 1400 인 사원을 검색하기 위해서iN연산자를 사용해봅시다.
 select *
 from emp
 where comm = 300 or comm = 500 or comm = 1400;
 --where comm IN(300,500,1400);
 
 
 -- Like 패턴 검색 
 -- F로 시작하는 이름을 가진 사원을 검색
 select *
 from emp
 where ename LIKE '__A%';
 
 
 -- 이름의 두 번째 글자가 A인 사원을 검색
 select ename
 from emp
-- where ename like '_A%';
 where ename not like '%A%';  -- 문자 A가 포함되지 않는 직원들의 이름
 
 
 -- 커미션을 받지 않는 사원을 검색
 select *
 from emp
 where comm is not null;
 --where comm is null;
 
 
 select *
 from emp
 order by hiredate;
 
 
-- 급여컬럼 기준으로 오름차순
select *
from emp
order by sal desc;
--order by sal asc;   -- sal = sal asc이 두개는 같다.

-- 사원 이름순
select *
from emp
order by ename;

-- 입사일 순 정렬
select *
from emp
order by hiredate asc , sal desc; -- 이런것도 가능 
 
 
 
 