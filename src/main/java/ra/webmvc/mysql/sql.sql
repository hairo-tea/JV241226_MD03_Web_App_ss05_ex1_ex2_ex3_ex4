create database studentManagement_db;
use studentManagement_db;

create table Students
(
    id           int primary key auto_increment,
    student_name varchar(100) not null,
    email        varchar(100) not null,
    birthday     date         not null,
    avgMark      double       not null
);

#procedure
DELIMITER &&
create procedure listStudent()
begin
select * from students;
end &&
DELIMITER &&

DELIMITER &&
create procedure addStudent(
    student_name_in varchar(100),
    email_in varchar(100),
    birthday_in date,
    avgMark_in double
)
begin
INSERT INTO Students(student_name, email, birthday, avgMark)
VALUES (student_name_in, email_in, birthday_in,
        avgMark_in);
end &&
DELIMITER &&

DELIMITER &&
create procedure findStudentId(id_in int)
begin
select * from Students where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure updateStudent(
    id_in int,
    student_name_in varchar(100),
    email_in varchar(100),
    birthday_in date,
    avgMark_in double
)
begin
update Students
set student_name = student_name_in,
    email        = email_in,
    birthday     = birthday_in,
    avgMark      = avgMark_in
where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure deleteStudent(id_in int)
begin
delete from Students where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure search_student_by_name(keyword varchar(100))
begin
SELECT * FROM Students where student_name LIKE CONCAT('%',keyword,'%');
end &&
DELIMITER &&

DELIMITER &&
CREATE PROCEDURE sort_by_id_ASC()
begin
select * from Students ORDER BY id ASC ;
end &&
DELIMITER &&

DELIMITER &&
create procedure sort_by_id_desc()
begin
select * from Students ORDER BY id desc ;
end &&
DELIMITER &&



INSERT INTO Students(student_name, email, birthday, avgMark)
values ('Nguyễn Văn A', 'nva@gmail.com', '1997-05-09', 8.0),
       ('Nguyễn Văn B', 'nvb@gmail.com', '1995-05-12', 8.2),
       ('Nguyễn Văn C', 'nvc@gmail.com', '1997-11-09', 7.0),
       ('Nguyễn Văn P', 'nvp@gmail.com', '1997-08-09', 8.1),
       ('Nguyễn Văn Y', 'nvy@gmail.com', '1997-07-09', 7.6);


