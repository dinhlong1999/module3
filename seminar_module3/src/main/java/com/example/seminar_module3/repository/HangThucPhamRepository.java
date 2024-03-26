package com.example.seminar_module3.repository;

import com.example.seminar_module3.model.HangThucPham;
import com.example.seminar_module3.model.HangThucPhamDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangThucPhamRepository implements  IHangThucPhamRepository{
    private static final String HIEN_THI = "select hang_thuc_pham.ma_hang_thuc_pham, hang_thuc_pham.ten_hang_thuc_pham, hang_thuc_pham.ngay_san_xuat, hang_thuc_pham.ngay_het_hang, loai_thuc_pham.ten_loai_thuc_pham, hang_thuc_pham.mo_ta\n" +
            "from hang_thuc_pham join loai_thuc_pham on hang_thuc_pham.ma_loai_thuc_pham = loai_thuc_pham.ma_loai_thuc_pham where da_xoa = 0;";
    private static final String XOA_THUC_PHAM = "UPDATE hang_thuc_pham SET da_xoa = 1 WHERE ma_hang_thuc_pham = ?";
    private static final String THEM_MOI = "INSERT INTO `seminar_module3`.`hang_thuc_pham` " +
            "(`ma_hang_thuc_pham`, `ten_hang_thuc_pham`, `ngay_san_xuat`, `ngay_het_hang`, `ma_loai_thuc_pham`, `mo_ta`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final ILoaiHangRepository loaiHangRepository = new LoaiHangRepository();
    @Override
    public List<HangThucPhamDTO> hienThi() {
        List<HangThucPhamDTO> hangThucPhamDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(HIEN_THI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String maHang = resultSet.getString("ma_hang_thuc_pham");
                String tenHang = resultSet.getString("ten_hang_thuc_pham");
                String ngaySanXuat = resultSet.getString("ngay_san_xuat");
                String ngayHetHan = resultSet.getString("ngay_het_hang");
                String tenLoai = resultSet.getString("ten_loai_thuc_pham");
                String moTa = resultSet.getString("mo_ta");
                hangThucPhamDTOList.add(new HangThucPhamDTO(maHang,tenHang,ngaySanXuat,ngayHetHan,tenLoai,moTa));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hangThucPhamDTOList;
    }

    @Override
    public void xoaThucPham(String maHang) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(XOA_THUC_PHAM);
            preparedStatement.setString(1,maHang);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void themMoi(HangThucPham hangThucPham) {
    Connection connection =BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(THEM_MOI);
            preparedStatement.setString(1,hangThucPham.getMaHang());
            preparedStatement.setString(2,hangThucPham.getTenHang());
            preparedStatement.setString(3,hangThucPham.getNgaySanXuat());
            preparedStatement.setString(4,hangThucPham.getNgayHetHan());
            preparedStatement.setInt(5,hangThucPham.getMaLoaiHang());
            preparedStatement.setString(6,hangThucPham.getMoTa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
