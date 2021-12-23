INSERT INTO member
(userid,password,username)
VALUES (?,?,?);

-- limit index, count
select * from project.member limit 0, 2;
select * from member order by regdate desc limit ?,?;
select count(*) from member;

-- select 
select * from project.member;

-- delete
delete from project.member where idx = ?; 