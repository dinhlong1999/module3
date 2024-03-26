package com.example.seminar_module3.controller;

import com.example.seminar_module3.model.HangThucPham;
import com.example.seminar_module3.model.HangThucPhamDTO;
import com.example.seminar_module3.model.LoaiHang;
import com.example.seminar_module3.repository.ILoaiHangRepository;
import com.example.seminar_module3.service.HangThucPhamService;
import com.example.seminar_module3.service.IHangThucPhamService;
import com.example.seminar_module3.service.ILoaiHangService;
import com.example.seminar_module3.service.LoaiHangService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoaiHangServlet", value = "/loaiHang")
public class LoaiHangServlet extends HttpServlet {
    private static final IHangThucPhamService hangThucPhamService = new HangThucPhamService();
    private static final ILoaiHangService hangService = new LoaiHangService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                taoThucPham(request,response);
                break;
            default:
                hienThiTatCa(request,response);
                break;
        }
    }

    private void taoThucPham(HttpServletRequest request, HttpServletResponse response) {
        List<LoaiHang> loaiHang = hangService.hienThi();
        request.setAttribute("loaiHang",loaiHang);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showFormCreate.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void hienThiTatCa(HttpServletRequest request, HttpServletResponse response) {
        List<HangThucPhamDTO> thucphamDTO = hangThucPhamService.hienThi();
        List<LoaiHang> loaiHang = hangService.hienThi();
        request.setAttribute("thucphamDTO",thucphamDTO);
        request.setAttribute("loaiHang",loaiHang);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                delete(request,response);
                break;
            case "create":
                create(request,response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String maThucPham = request.getParameter("maThucPham");
        String tenThucPham = request.getParameter("tenThucPham");
        String ngaySanXuat = request.getParameter("ngaySanXuat");
        String ngayHetHang = request.getParameter("ngayHetHan");
        String loaiThucPham = request.getParameter("loaiThucPham");
        int maLoai = hangService.timMaLoaiHang(loaiThucPham);
        String mota = request.getParameter("moTa");
        HangThucPham hangThucPham = new HangThucPham(maThucPham,tenThucPham,ngaySanXuat,ngayHetHang,maLoai,mota);
        hangThucPhamService.themMoi(hangThucPham);
//        try {
//            response.sendRedirect("loaiHang");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        request.setAttribute("message","Them moi thanh cong");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showFormCreate.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String maHang = request.getParameter("id");
        hangThucPhamService.xoaThucPham(maHang);
        try {
            response.sendRedirect("loaiHang");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}