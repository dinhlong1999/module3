package com.example.seminar_module3.repository;

import com.example.seminar_module3.model.HangThucPham;
import com.example.seminar_module3.model.HangThucPhamDTO;

import java.util.List;

public interface IHangThucPhamRepository {
    List<HangThucPhamDTO> hienThi();
    void xoaThucPham(String maHang);
    void themMoi(HangThucPham hangThucPham);
}
