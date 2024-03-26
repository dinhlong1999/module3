package com.example.seminar_module3.service;

import com.example.seminar_module3.model.HangThucPham;
import com.example.seminar_module3.model.HangThucPhamDTO;

import java.util.List;

public interface IHangThucPhamService {
    List<HangThucPhamDTO> hienThi();
    void xoaThucPham(String maHang);
    void themMoi(HangThucPham hangThucPham);
}
