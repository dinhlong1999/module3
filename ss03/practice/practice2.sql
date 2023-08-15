select * from student;
select * from student
where `status` = true;
select * from subject
where creadit < 10;

select S.student_id, S.student_name, C.class_name
from student S jostudentin class_room C on S.class_id = c.class_id
where C.class_name = "A1";

select S.student_id, S. student_name, sub.sub_name, m.mark
from student S join mark m on S.student_id = m.student_id join subject sub on m.sub_id = sub.sub_id
where sub.sub_name = "CF";