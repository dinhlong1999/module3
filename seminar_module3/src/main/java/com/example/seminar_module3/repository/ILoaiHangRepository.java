package com.example.seminar_module3.repository;

import com.example.seminar_module3.model.LoaiHang;

import java.util.List;

public interface ILoaiHangRepository {
    List<LoaiHang> hienThi();
    int timMaLoaiHang(String name);
}
