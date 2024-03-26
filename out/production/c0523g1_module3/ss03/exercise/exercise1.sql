-- ----Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’---------- -- 
select * from student
where student_name like "H%";

-- ------Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.-----
select * from class_room
where Month(start_date) =12;

-- -------Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.----
select * from `subject`
where creadit > 3 and creadit < 5;

-- ------Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.------
set sql_safe_updates = 0;
update student
set class_id = 2
where student_name = "Hung";
set sql_safe_updates = 1;


-- ---------Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần
-- . nếu trùng sắp theo tên tăng dần.-------
SELECT 
    student.student_name, `subject`.sub_name, mark.mark
FROM
    mark
        JOIN
    student ON student.student_id = mark.student_id
        JOIN
    `subject` ON `subject`.sub_id = mark.mark_id
ORDER BY mark.mark DESC , student_name;
