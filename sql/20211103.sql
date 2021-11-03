-- 2021 11.31

-- DDL : 데이터 정의어, 객체 생성, 수정, 삭제 명령어
-- 테이블 생성 : create table
-- 테이블 수정 : alrter table
-- 테이블 삭제 : drop tabel

-- create table 테이블명(
--  컬럼이름 데이터 타입(size) 여기서 제약조건정의 가능(컬럼 레벨 정의)
--  ...
--  제약조건정의(테이블 레벨 정의)

-- 부서 테이블과 유사한 테이블을 정의
create table dept_test (
    deptno  number(2),
    dname   varchar2(20),
    loc     varchar2(20)
);

drop table dept_test;

--  사원 테이블과 유사한 구조의 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 emp01테이블 생성
--EMPNO    NOT NULL NUMBER(4)    
--ENAME             VARCHAR2(10) 
--sal               number(7,2)  

create table emp01 (
    empno   number(4),
    ename   varchar2(10),
    sal     number(7,2)
);

--  서브쿼를 이용해서 기존 테이블의 구조를 복사하고, 튜플을 복사
--  컬럼의 정의만 복사, 제약조건은 복사되지 않는다. 
--  용도로는 테스터 테이블 만들 때 등
create table emp02
as
select * from emp01;

desc emp02;


--  원하는 테이블
create table emp03
as
select empno, job from emp;

desc emp03;

--  원하는 데이터만 복사
create table emp04
as
select * from emp where deptno = 10;

desc emp04;
select * from emp04;


--  구조만 복사
select * from emp where 1=0;

create table emp05
as
select * from emp where 1=0;

desc emp05;
select * from emp05;




--  테이블 구조의 변경은 : alter table
--  컬럼 추가의 경우는 ADD(컬럼정의)

--  emp01 테이블에 문자 타입의 직급 칼럼을 추가해보자
alter table emp01
add(job varchar2(9));

select * from emp01;

alter table emp01
add(
    hiredate date,
    deptno   number(2)
);

desc emp01;


--  컬럼의 변경 : alter table {테이블 이름} modifiy (컬럼 정의);
desc emp01;
alter table emp01
modify(
    job varchar2(30) not null
);

desc emp01;

--  칼럼 삭제

--  emp01의 job칼럼을 삭제
desc emp01;
alter table emp01
drop column job;

desc emp02;

TRUNCATE table emp02;

rename emp02 to test;
desc test;


--------------------------------------------------------
--  제약조건확인
desc dept;
insert into dept(deptno, dname, loc) 
values ( 10, 'test', 'SEOUL');



-- 제약사항의 정의 : column 레벨과 table레벨에서 정의
--  column 레벨   :   컬럼 정으 ㅣ바로 뒤에 제약사항을 정의

--  사원 테이블과 유사한 구조의 사원번호, 사원명, 직급, 부서번호 4개의 칼롬으로 구성된
--  emp02 테이블을 생성하되 empno와 empname 칼럼에 not null 제약 조건 설정

create table emp02(
    empno   number(4)    not null,
    ename   varchar2(20) not null, 
    job     varchar2(9),
    deptno  number(2)
);

desc emp02;

insert into emp02   --  데이터 추가
values ( 10, 'test', null, null );

select * from emp02;


--  사원 테이블과 유사한 구조의
--  사원번호, 사원명, 직급, 부서번호 4개의 칼롬으로
--  구성된 emp03 테이블을 생성하되
--  사원번호를 유일키로 지정합시다.

drop table emp03;

create table emp03(
    empno   number(4) constraint uk_emp03_empno unique,
    ename   varchar(20) not null,
    job     varchar(9),
    deptno  number(2)
);

insert into emp03 values( 1000, 'test','MANAGER', 40 );
select * from emp03;

insert into emp03 values( 1000, 'test1','MANAGER2', 30 );


drop table emp04;

create table emp04(
    empno   number(4) constraint emp04_empno_pk primary key,
    ename   varchar(20) not null,
    job     varchar(9),
    deptno  number(2)
);

select * from emp04;
insert into emp04 values( 1000, 'test','MANAGER', 40 );
insert into emp04 values( 1000, 'test1','MANAGER2', 30 );


--  외래키 제약
drop table emp05;

create table emp05(
    empno   number(4) constraint emp05_empno_pk primary key,
    ename   varchar(20) not null,
    job     varchar(9),
    deptno  number(2) constraint emp05_deptno_fk references dept (deptno)
);

select * from emp05;
insert into emp05 values( 1000, 'test','MANAGER', 40 );
insert into emp05 values( 2000, 'test1','MANAGER2', 30 );


------------------------------------------------------------------
--  check 제약
drop table emp06;

create table emp06(
    empno   number(4) constraint emp06_empno_pk primary key,
    ename   varchar(20) not null,
    job     varchar(9),
    sal     number(7,2) constraint emp06_sal_ck check (sal between 400 and 5000),
    gender  char(1) constraint emp06_gender_ck check (gender in('M','F')),
    deptno  number(2) constraint emp06_deptno_fk references dept (deptno)
);

select * from emp06;
insert into emp06 values( 2000, 'test1','MANAGER2',30000 ,'M',30 );


--------------------------------------------------------------------
--  Default ( 속성 정의 정도? )
--  

create table dept01(
    deptno  number(2),
    dname   varchar(20),
    loc     varchar(20) default 'seoul',
    regDate date default SYSDATE
);
drop table dept01;

insert into dept01 (deptno, dname)
values(10,'손흥민');

insert into dept01 (deptno, dname, loc)
values(10,'손흥민','Newyork');

insert into dept01 (deptno, dname, loc, regdate)
values(10,'손흥민','Newyork', null);

select * from dept01;

---------------------------------------------------------------------
--  table level에서의 constraint
--  컬럼 정의 후 제약조건 정의
--  컬럼 레벨에서 해야하는 것 -> not null, default

drop table emp07;

create table emp07(
    empno   number(4),  -- primary key
    ename   varchar(20) not null,
    sal     number(7,2) constraint emp07_sal_ck check (sal between 500 and 5000),
    deptno  number(2),  -- foreign key
    
    ---------------- 테이블 레벨 제약 조건 정의-------------
    constraint emp07_empno_pk primary key (empno),
    constraint emp07_empno_fk foreign key (deptno) references dept(deptno)
);









