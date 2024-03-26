package com.example.seminar_module3.service;

import com.example.seminar_module3.model.LoaiHang;

import java.util.List;

public interface ILoaiHangService {
    List<LoaiHang> hienThi();
    int timMaLoaiHang(String name);
}
