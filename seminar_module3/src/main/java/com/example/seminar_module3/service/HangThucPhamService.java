package com.example.seminar_module3.service;

import com.example.seminar_module3.model.HangThucPham;
import com.example.seminar_module3.model.HangThucPhamDTO;
import com.example.seminar_module3.repository.HangThucPhamRepository;
import com.example.seminar_module3.repository.IHangThucPhamRepository;

import java.util.List;

public class HangThucPhamService implements  IHangThucPhamService{
    private static  final IHangThucPhamRepository hangThucPhamRepository = new HangThucPhamRepository();
    @Override
    public List<HangThucPhamDTO> hienThi() {
        return hangThucPhamRepository.hienThi();
    }

    @Override
    public void xoaThucPham(String maHang) {
        hangThucPhamRepository.xoaThucPham(maHang);
    }

    @Override
    public void themMoi(HangThucPham hangThucPham) {
        hangThucPhamRepository.themMoi(hangThucPham);
    }
}
