create database ss02_bai_tap2;
use ss02_bai_tap2;

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(50),
customer_age int
);

create table `order`(
order_id int primary key auto_increment,
order_date date,
order_total_price double,
customer_id int,
foreign key(customer_id) references customer(customer_id)
);

create table `product`(
product_id int primary key auto_increment,
product_name varchar(50),
product_price varchar(50)
);

create table `order_detail`(
order_detail_quality int,
order_id int,
product_id int,
primary key(order_id, product_id),
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references `product`(product_id)
);

ALTER TABLE `ss02_bai_tap2`.`customer` 
RENAME TO  `ss02_bai_tap2`.`customers` ;

ALTER TABLE `ss02_bai_tap2`.`order` 
RENAME TO  `ss02_bai_tap2`.`orders` ;

ALTER TABLE `ss02_bai_tap2`.`order_detail` 
RENAME TO  `ss02_bai_tap2`.`orders_detail` ;

ALTER TABLE `ss02_bai_tap2`.`product` 
RENAME TO  `ss02_bai_tap2`.`products` ;
