package com.example.seminar_module3.repository;

import com.example.seminar_module3.model.LoaiHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiHangRepository implements  ILoaiHangRepository{
    private static final String HIEN_THI = "select * from loai_thuc_pham;";
    private static final String TIM_TEN = "select ma_loai_thuc_pham from loai_thuc_pham where ten_loai_thuc_pham =?;";
    @Override
    public List<LoaiHang> hienThi() {
        List<LoaiHang> loaiHang = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(HIEN_THI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maLoai = resultSet.getInt("ma_loai_thuc_pham");
                String tenLoai = resultSet.getString("ten_loai_thuc_pham");
                loaiHang.add(new LoaiHang(maLoai,tenLoai));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loaiHang;
    }

    @Override
    public int timMaLoaiHang(String name) {
        int maLoaiHang = 0;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(TIM_TEN);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                maLoaiHang = resultSet.getInt("ma_loai_thuc_pham");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maLoaiHang;
    }
}
