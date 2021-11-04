-- 2021. 11.04  DDL_exam

desc phoneInfo_basic;

insert into phoneInfo_basic     
values( 0001 ,'손흥민', '01058325211', 'tot@gamil.com', 'lundon', sysdate );
insert into phoneInfo_basic     
values( 0002 ,'이강인', '01025216548', 'mayo@gamil.com', 'london', sysdate );


-- select
--  이름으로 검색
select * from phoneinfo_basic
where  fr_name like '%흥%';

--  전화번호 검색
select * from phoneinfo_basic
where fr_phonenumber like '%010%';

--  시스템 내부에서 관리자가 검색
--  예) 리스트 > 상세보기
select * from phoneinfo_basic where idx = 0002;




update  phoneInfo_basic
set     fr_name = 'son', fr_phonenumber = '010-7777-5555', fr_email = 'son@kakao.com', fr_address = '서울'
where   idx = 0001;



delete  phoneinfo_basic
where   idx = 0001;

--  친구 정보를 입력 : 기본정보 + 학교정보
insert into phoneinfo_basic --()
        values (3, '황희찬', '010-3333-1111', 'hh@gmail.com', 'LONDON', sysdate);
insert into phoneinfo_univ values(1,'축구',1,2);

select * from phoneinfo_univ;   --  이 테이블만으로는 의미가 없다. 

select *
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx = pu.fr_ref
;

select pb.fr_name, pb.fr_phonenumber, pu.fr_u_major, pu.fr_u_year
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx = pu.fr_ref
;

--  기본정보만 입력된 데이터도 출력 : outer join
select pb.fr_name,
       pb.fr_phonenumber,
       nvl(pu.fr_u_major,'입력정보없음') major,
       nvl(pu.fr_u_year,0) year,
       to_char(pb.fr_regdate, 'YYYY.MM.DD HH24:mm') regdate
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx = pu.idx(+);   -- outer join

--  update
update  phoneinfo_univ
set     fr_u_major = '야구',
        fr_u_year = 4
where   idx = 1;

select * from phoneinfo_univ;

--  delete
--  자식 테이블의 데이터를 먼저 삭제 
delete from phoneinfo_univ where idx = 1;
--  부모 테이블의 데이터를 삭제
delete from phoneinfo_basic where idx = 3;

select * from phoneinfo_univ;



--  insert
select idx from phoneinfo_basic;
insert into phoneinfo_basic
    values(4, '황의조', '010-2222-1111', 'h@gamil.com', 'seoul', sysdate);

select * from phoneinfo_com;
insert into phoneinfo_com
    values(1, 'NAVER', 4);

--  회사 친구 입력 : 기본 정보 입력 -> 회사정보 입력

--  select
select  pb.fr_name, 
        pb.fr_phonenumber, 
        pb.fr_email, 
        nvl(pc.fr_c_company,'입력데이터 없음') company , 
        to_char(pb.fr_regdate, 'yyyy.mm.dd HH24:mi') regdate
from    phoneinfo_basic pb, phoneinfo_com pc
where   pb.idx = pc.idx(+);

--  update
update  phoneinfo_com
set     fr_c_company = '쿠팡'
where   idx = 1;


--  delete

-- 자식테이블 행 먼저 삭제
delete from phoneinfo_com where idx = 1;

-- 부모테이블 행 삭제
delete from phoneinfo_basic where idx = 4;
    

select * from phoneinfo_basic;
-----------------------------------------------------------

--  전체 데이터 리스트 출력   :   테이블 3개 JOin
select pb.fr_name, pb.fr_phonenumber, pu.fr_u_major,pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
where pb.idx = pc.fr_ref(+) 
and   pb.idx = pu.fr_ref(+);


--  view 생성
create or replace view phoneinfo_view
as
select pb.fr_name, pb.fr_phonenumber, pu.fr_u_major,pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_com pc, phoneinfo_univ pu
where pb.idx = pc.fr_ref(+) 
and   pb.idx = pu.fr_ref(+);

select * from phoneinfo_view
where fr_name = 'son';


-- DDL 과 DCL, view 사용해보기 

desc phoneinfo_basic;

--  연습용 setting
    create table phone_test01 as (select * from phoneinfo_basic);
    create table phone_test02 as (select * from phoneinfo_com);
    create table phone_test03 as (select * from phoneinfo_univ);

    insert into phone_test01 values (5,'최우석','010-7584-3912','bale@coupang.com','인천',sysdate);
    insert into phone_test02 values (2,'coupang',5);    
    insert into phone_test03 values (2,'회사원',1,5);
    
    select * from phone_test01;
    select * from phone_test02;
    select * from phone_test03;
    
--  새로들어온 사원 최우석의 관한 정보를 전부 출력해라.
    select  * 
    from    phone_test01 p1,phone_test02 p2,phone_test03 p3
    where   p1.idx = p2.fr_ref
    and     p1.idx = p3.fr_ref
    and     p1.fr_name = '최우석';
    

--  핸드폰 번호, 지역을 제외한 모든 정보를 담은 view 테이블을 생성하라
    create table test04
    as (select * from phone_test01 where 1=0);
    
    select * from
    
    create or replace view test05
    as  (select  * from phone_test01); 
    
    select * from test05;


