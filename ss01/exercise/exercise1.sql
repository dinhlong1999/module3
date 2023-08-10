create database student_management ;

use student_management;

create table Teacher(
id int primary key auto_increment,
`name` varchar(200),
age int,
country varchar(50)
);

create table Class(
id int primary key auto_increment,
`name` varchar(200)
);

insert into teacher(`name`, age, country)
values ("Hau",19,"VN"),("long",19,"VN"),("Thien",19,"VN");


select * from class;

insert into class(`name`)
values ("codegym");

set sql_safe_updates = 0;
update class
set `name` = "pct"
where `name` = "codegym";
set sql_safe_updates = 1;

