create database practice_s12;
use practice_s12;

create table users(
id int not null auto_increment primary key,
`name` varchar(120) not null,
email varchar(220) not null,
country varchar(120)
);

insert into users(`name`,email,country)
values ('Minh','minh@codegym.vn','Viet Nam'),
('Kante','kante@che.uk','Kenia');
 
 delimiter //
 create procedure get_user_by_id(id int )
 begin
	select users.`name`, users.email, users.country 
    from users where users.id = id;
end //
delimiter ;
  
  call get_user_by_id(1);
  
  delimiter //
  create procedure insert_user(user_name varchar(50),user_email varchar(50), user_country varchar(50))
  begin
  insert into users(`name`,email,country)
  values(user_name,user_email,user_country);
  end //
  delimiter ;
  
  call insert_user("hung","hungmap@gmail.com","Da Nang");
  
  create table user_Permision(
  permision_id int(11),
  user_id int(11)
  );
  
  create table permision(
  id int(11) primary key,
  `name` varchar(50)
  );
  
  insert into permision(id,`name`)
  values(1,"add"),
  (2,"edit"),
    (3,"delete"),
      (4,"view");

create table employee(
	id int(3) primary key not null auto_increment,
    `name` varchar(120) not null,
    salary int(220) not null,
    created_Date datetime
);  

delimiter //
create procedure get_all_user()
begin 
select id, `name`, email, country 
from users 
where is_delete = 0;
end //
delimiter ;

call get_all_user();

delimiter //
create procedure edit_user(id_update int, name_update varchar(255), email_update varchar(255), country_update varchar(255))
begin
update users
set `name` = name_update, email = email_update, country = country_update
where id = id_update;
end //
delimiter ;

call edit_user(3, "long","long1110dn@gmail.com","ĐN");

delimiter //
create procedure delete_user(id_delete int)
begin
update users
set is_delete = 1 
where id = id_delete;
end //
delimiter ;

call delete_user(14);


