select C.`name`, count(*) as so_luong_hoc_vien
from class C
join student S on S.class_id= C.id
group by C.`name`;

select C.`name` , Max(S.`point`) as max_point
from class C
join student S on S.class_id = C.id
group by  C.`name`;

select C.`name` , avg(S.`point`) as max_point
from class C
join student S on S.class_id = C.id
group by  C.`name`;

select S.`name`, S.birthday, I.`name`, I.birthday
from student S
left join instructor I on I.id = S.id
union
select  S.`name`, S.birthday, I.`name`, I.birthday
from student S
right join instructor I on I.id = S.id;

select S.id, S.`name`, `point`
from student S
order by `point` desc
limit 3;









