-- câu1: Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from `subject`
order by creadit desc
limit 1;
 
--  câu 2: Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.sub_id, s.sub_name, s.creadit, s.status,mark  from `subject` s
join mark m on s.sub_id = m.sub_id
where mark  in ( select max(mark) from mark);

-- câu 3: Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT 
    s.student_id,
    s.student_name,
    s.address,
    s.phone,
    s.`status`,
    AVG(mark) AS 'Diem_trung_binh'
FROM
    student s
        JOIN
    mark m ON m.student_id = s.student_id
GROUP BY s.student_id
ORDER BY 'Diem_trung_binh' DESC;
