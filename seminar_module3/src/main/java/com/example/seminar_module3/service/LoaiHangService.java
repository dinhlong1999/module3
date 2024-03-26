package com.example.seminar_module3.service;

import com.example.seminar_module3.model.LoaiHang;
import com.example.seminar_module3.repository.ILoaiHangRepository;
import com.example.seminar_module3.repository.LoaiHangRepository;

import java.util.List;

public class LoaiHangService implements ILoaiHangService {
    private static final ILoaiHangRepository loaiHangRepository = new LoaiHangRepository();
    @Override
    public List<LoaiHang> hienThi() {
        return loaiHangRepository.hienThi();
    }

    @Override
    public int timMaLoaiHang(String name) {
        return loaiHangRepository.timMaLoaiHang(name);
    }
}
