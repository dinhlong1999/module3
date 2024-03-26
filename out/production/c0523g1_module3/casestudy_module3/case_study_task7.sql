--  câu16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
-- Tạo view(bảng ảo) để không ảnh hưởng đến bảng chính
set sql_safe_updates = 1;
CREATE VIEW view_xoa_nhan_vien AS
    SELECT 
        nhan_vien.ma_nhan_vien, nhan_vien.ho_ten
    FROM
        nhan_vien
            LEFT JOIN
        hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
    WHERE
        nhan_vien.ma_nhan_vien NOT IN (SELECT 
                ma_nhan_vien
            FROM
                hop_dong
            WHERE
                YEAR(ngay_lam_hop_dong) BETWEEN 2019 AND 2021)
                group by nhan_vien.ma_nhan_vien;
                
-- tạo 1 cột để hiển thị nhân viên xoá                
alter table nhan_vien
add column nhan_vien_xoa boolean default false;

-- ---thay đổi giá trị nhân viên bị xoá thành true;
UPDATE nhan_vien 
SET 
    nhan_vien_xoa = TRUE
WHERE
    ma_nhan_vien IN (SELECT 
            ma_nhan_vien
        FROM
            view_xoa_nhan_vien);

-- câu 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
CREATE VIEW view_cap_nhat_khach_hang AS
    SELECT 
        khach_hang.ma_khach_hang,
        khach_hang.ho_ten,
        khach_hang.ma_loai_khach,
        chi_phi_thue + SUM(IFNULL(so_luong * gia, 0)) AS Tong_tien
    FROM
        khach_hang
            JOIN
        hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
            JOIN
        hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            JOIN
        dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
            JOIN
        dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
            JOIN
        loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
            AND loai_khach.ten_loai_khach = 'Platinium'
    WHERE
        YEAR(hop_dong.ngay_lam_hop_dong) = 2021
    GROUP BY khach_hang.ma_khach_hang
    HAVING Tong_tien > 10000000;

update khach_hang
set ma_loai_khach = 1 
where ma_khach_hang = (select ma_khach_hang from view_cap_nhat_khach_hang);

-- câu 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
set sql_safe_updates = 1;
CREATE VIEW view_khach_hang_can_xoa AS
    SELECT 
        khach_hang.ma_khach_hang, khach_hang.ho_ten
    FROM
        khach_hang
            JOIN
        hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
            AND YEAR(hop_dong.ngay_lam_hop_dong) < 2021
    GROUP BY khach_hang.ma_khach_hang;

-- --Tạo 1 cột để note những khách hàng cần xoá
alter table khach_hang
add column khach_hang_can_xoa boolean default false;

-- --Thay đổi giá trị thành true cho khách hàng;
update khach_hang
set khach_hang_can_xoa = true 
where ma_khach_hang in (select ma_khach_hang from view_khach_hang_can_xoa); 

-- câu 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
CREATE VIEW view_tang_gia_dich_vu_di_kem AS
    SELECT 
        dich_vu_di_kem.ma_dich_vu_di_kem,
        dich_vu_di_kem.ten_dich_vu_di_kem,
        SUM(hop_dong_chi_tiet.so_luong)
    FROM
        hop_dong_chi_tiet
            JOIN
        dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
            JOIN
        hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
            AND YEAR(ngay_lam_hop_dong) = 2020
    WHERE
        hop_dong_chi_tiet.so_luong > 10
    GROUP BY hop_dong_chi_tiet.ma_hop_dong_chi_tiet;

update dich_vu_di_kem
set gia = gia * 2
where ma_dich_vu_di_kem = ( select ma_dich_vu_di_kem from view_tang_gia_dich_vu_di_kem);

-- câu 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
 SELECT 
    ma_nhan_vien as id,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    nhan_vien 
UNION SELECT 
    ma_khach_hang,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    khach_hang;












