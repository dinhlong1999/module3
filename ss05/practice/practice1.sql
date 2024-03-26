DELIMITER //
create procedure findAllCustomers()
begin
	select * from customers where customerNumber = 175;
end //
    DELIMITER ;
    
    call findAllCustomers();
drop procedure if exists `findAllCustomers`;

DELIMITER //
create procedure getCusByid(in cusNum int(11))
begin 
	select * from customers where customerNumber = cusNum;
end //
DELIMITER ;

call getCusByid(175);

DELIMITER //
create procedure GetCustomersCountBycity(
in in_city varchar(50),
out total int)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
    end //
    DELIMITER ;
call GetCustomersCountByCity("Lyon", @total);
select @total;


DELIMITER //
create procedure SetCounter(
inout counter int,
in inc int
)
begin
set counter = counter + inc;
end //
DELIMITER ;

set @counter = 1; 
call SetCounter(@counter,1);
call SetCounter(@counter,1);
call SetCounter(@counter,5);
select @counter;

create view customer_views as
select customerNumber, customerName, phone
from customers;
select * from customer_views;
create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = "Nantes";
drop view customer_view;
drop view customer_views;















