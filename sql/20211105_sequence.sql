--  21.11.05

--  sequence : 숫자를 생성해주는 객체 
--             설정을 통하여 일련 번호를 생성 > 기본키가 대리키인 경우 입력 값으로 사용

--  sequence의 생성
--  create sequence q_name 설정....

--  시퀀스 생성!
create sequence test_seq;


--  부서 번호를 자동으로 부여해주는 시퀀스 객체를 만들어보자 
desc dept;
select * from dept; -- deptno가 10씩 증가함을 알 수 있따.

--  시작 값 10, 중가값 10, 10~99
create sequence dept_deptno_seq
    start with 10
    increment by 10
    MAXVALUE 99;
    
--  sequence 삭제
drop sequence dept_deptno_seq;


create sequence emp_empno_seq 
    start with   1
    increment by 1
    minvalue     1
    maxvalue     9999;


--  시퀸스의 값을 확인
--  현재 값
select dept_deptno_seq.currval from dual;

-- 다음(새로운) 값
select dept_deptno_seq.nextval from dual;





