select `address`,  count(student_id) as so_luong_hoc_vien
from student
group by `address`;

select S.student_id, S.student_name, avg(mark)
from student S 
join mark M on M.student_id = S.student_id
group by s.student_id, s.student_name
having avg(mark) > 15;

select S.student_id, S.student_name, avg(mark)
from student S 
join mark M on M.student_id = S.student_id
group by s.student_id, s.student_name
having avg(mark) >= All(select avg(mark) from mark group by mark.student_id);