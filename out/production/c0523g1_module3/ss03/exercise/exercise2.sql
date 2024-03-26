-- -------Thêm dữ liệu vào bảng customers------
insert into customers(customer_name,customer_age)
values ("Minh Quan", 10);
insert into customers(customer_name,customer_age)
values ("Ngoc Oanh", 20),("Hong Ha",50);

-- ---- --Thêm dữ liệu vào bảng orders-------
insert into orders(order_date,order_total_price,customer_id)
values("2006-03-21",null,1),("2006-03-23",null,2),("2006-03-16",null,1);

-- -------Thêm dữ liệu vào bảng products-----
insert into products(product_name,product_price)
values("May Giat",3),("Tu Lanh",5),("Dieu hoa",7),("Quat",1),("Bep dien",2);

-- -------Thêm dữ liệu vào bảng orders_detail---
insert into orders_detail(order_detail_quality,order_id,product_id)
values(3,1,1),(7,1,3),(2,1,4),(1,2,1),(8,3,1),(4,2,5),(3,2,3);
select * from orders_detail;

-- -----Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order---
select order_id, order_date, order_total_price from orders;

-- -----Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách---
SELECT 
    customers.customer_id,
    customers.customer_name,
    products.product_name
FROM
    orders_detail
        JOIN
    products ON products.product_id = orders_detail.product_id
        JOIN
    orders ON orders.order_id = orders_detail.order_id
        JOIN
    customers ON customers.customer_id = orders.customer_id;

-- ----Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào----
select * from customers
where customer_id not in (select customer_id from orders);

-- ----Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
--  Giá bán của từng loại được tính = odQTY*pPrice)-----
select orders.order_id, orders.order_date, SUM(orders_detail.order_detail_quality * products.product_price) as "Gia_tien"
from orders_detail
join orders on orders.order_id = orders_detail.order_id
join products on products.product_id = orders_detail.product_id
group by orders.order_id;










