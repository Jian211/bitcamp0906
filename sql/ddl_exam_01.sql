-- 2021. 11.03  DDL_exam


create table phoneInfo_basic(
    idx            number(6),             -- primary key
    fr_name        varchar2(20) not null, -- 친구 이름
    fr_phonenumber varchar2(20) not null, -- 친구 전화번호
    fr_emial       varchar2(20),          -- 친구 이메일
    fr_address     varchar2(20),          -- 친구 주소
    fr_regdate     date default sysdate,  -- 등록 시간 
    
    constraint phoneInfo_basic_idx_pk primary key (idx)
);




create table phoneInfo_univ(
    idx         number(6),                                   
    fr_u_major  varchar2(20)  default 'N'  not null,    -- 대학친구의 전공 정보
    fr_u_year   number(1)     default 1    not null,    -- 대학친구의 학년
    fr_ref      number(7)                  not null,    -- 친구의 기본 정보 외래키

    constraint phoneInfo_idx_pk primary key (idx),
    constraint phoneInfo_univ_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx),
    constraint phoneInfo_univ_fr_u_year_ck check (fr_u_year between 0 and 5)
);




create table phoneInfo_com(
    idx             number(6),
    fr_c_company    varchar2(20)  default 'N'  not null,   -- 회사친구의 회사이름
    fr_ref          number(6)                  not null,   -- 친구의 기본 정보 외래키             
    
    constraint phoneInfo_com_idx_pk    primary key (idx),
    constraint phoneInfo_com_fr_ref_fk foreign key (fr_ref) references phoneInfo_basic (idx)
);



drop table phoneInfo_basic;
drop table phoneInfo_com;
drop table phoneInfo_univ; 
