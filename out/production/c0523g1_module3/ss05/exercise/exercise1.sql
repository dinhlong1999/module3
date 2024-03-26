-- --Tạo database---
create database demo;
use demo;

-- ---Tạo bảng -----
create table products(
product_id int primary key auto_increment,
product_code varchar(50),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(100),
pruduct_status varchar(50)
);
insert into products(product_code, product_name,product_price, product_amount, product_description, pruduct_status)
values("PR-123", "IPHONE 15", 32000000, 10,"Not arrived","order"),
	  ("PR-456", "IPHONE 14 Pro max ", 22000000, 15,"in stock","open sale"),
	  ("PR-789", "IPHONE 14 Pro", 12000000, 6,"in stock","open sale");
      
-- ---câu 1: tạo unique index----
create unique index index_product_code on products(product_code);
drop index index_product_code  on products;
create unique index index_composite_product on products(product_name, product_price);
explain select product_id, product_code, product_name, product_price 
from products
where product_code = "PR-789";

-- --- --Câu 2: tạo view---
create view view_product as 
select product_code, product_name, product_price, pruduct_status
from products;

update view_product
set product_name = "iphone 13" 
where product_name = "IPHONE 14 Pro";

update view_product
set pruduct_status = "End offline"
where product_name = "iphone 13";

drop view view_product;

-- ----Câu 3: tạo stored procedure----

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_all_product()
begin 
	select * 
    from products;
end //
delimiter ;
call get_all_product;

-- ---Tạo store procedure thêm một sản phẩm mới--
delimiter //
create procedure add_product( product_code varchar(50), product_name varchar(50),product_price double,product_amount int,product_description varchar(100),pruduct_status varchar(50))
begin 
	insert into products (product_code,product_name, product_price, product_amount, product_description, pruduct_status)
    values( product_code,product_name, product_price, product_amount, product_description, pruduct_status);
end //
delimiter ;
call add_product( "PR-999", "IPHONE 15 Pro", 30000000, 5,"Not arrived","order");

-- ---Tạo store procedure sửa thông tin sản phẩm theo id;
delimiter //
create procedure edit_product( id_edit int,  name_edit varchar(50))
begin
	update products
    set product_name = name_edit
    where product_id = id_edit;
end //
delimiter ;
call edit_product(4, "IPHONE 12")

-- ----Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product( id_delete int)
begin 
	delete from products
    where product_id = id_delete;
end //
delimiter ;    
call delete_product(4);

-- ---- xoá store procedure-----
drop procedure delete_product;















