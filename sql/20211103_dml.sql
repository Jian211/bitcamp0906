--  21/11/03
--  DML : 데이터의 입력, 수정, 삭제 

--  테스트 테이블 생성
drop table dept01;

create table dept01
as
select * from dept where 1=0;   --  구조만 복사


--  데이터의 입력은 : insert into table_name ( column_name, ... )
--                  values( data, ... );
--  1. 입력하고자하는 컬럼의 갯수와 입력데이터의 갯수는 동일해야한다. 
--  2. 컬럼의 도메인(컬럼 속성)과 입력데이터의 타입이 일치해야한다. 
--  3. 컬럼의 제약 중, not null인 컬럼을 생략하면 안된다.

desc dept01;

insert into dept (dname, loc) values('개발팀','판교'); -- error! pk값은 null X!, 생략X

insert into dept01 
    (deptno, dname, loc)
values
    (10,'황희찬', '울버햄튼'); --  1,2의 내용참고


--  모든 컬럼의 데이터를 입력할 경우,
insert into dept01 -- ( column_name, ... ) 이 부분이 생략가능하다. 
values (10,'이강인','마요르카');

--------------------------------------------------------------------------
--  서브 쿼리를 이용한 데이터 입력

drop table dept02;

create table dept02
as
select * from dept where 1=0;   --  구조만 복사

select * from dept02;

--  서브쿼리를 이용해서 데이터 삽입.
insert into dept02 select * from dept;


