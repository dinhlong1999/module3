create database manager_product;
use manager_product;

create table product(
id int auto_increment primary key,
`name` varchar(50) not null,
price int not null,
`describe` text,
producer varchar(255),
isDelete bit default 0
);

insert into product(`name`,price,`describe`,producer)
values ("Lenovo Legion 5",25000000,"black","Lenovo"),
("Asus TUF Dash",20000000,"White","Asus"),
("Macbook M1",30000000,"Pink","Apple");

select * from product;
select `name` from product;



