/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dbConect.DBcontext1;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class SanPham_service {

    ArrayList<SanPham> ls = new ArrayList<>();

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> lst = new ArrayList<>();
        try {
            String sql = "select *,b.TenNhaCC as NhaCungCap, c.TenLoaiSP as Loai,d.TenChatLieu as ChatLieu   from SanPham a  inner join SANPHAM_NhaCungCap b on  a.MaNhaCC = b.MaNhaCC\n"
                    + "inner join SANPHAM_LoaiSP c on a.MaLoaiSp = c.MaLoaiSp \n"
                    + "inner join SANPHAM_ChatLieu d on a.MaChatLieu = d.MaChatLieu";

            Connection cnn = DBcontext1.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("MaSanPham"));
                sp.setTenSp(rs.getNString("TenSanPham"));
                sp.setMaCC(rs.getNString("NhaCungCap"));
                sp.setAnh(rs.getNString("TenAnh"));
                sp.setLoai(rs.getNString("Loai"));
                sp.setChatLieu(rs.getNString("ChatLieu"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setSolg(rs.getInt("SoLuong"));
                sp.setMoTa(rs.getNString("MoTa"));
                sp.setNgayNhap(String.valueOf(rs.getDate("NgayNhap")));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setIdChatLieu(rs.getInt("MaChatLieu"));
//                sp.setMaAnh(rs.getInt("MaAnh"));
                sp.setIdNcc(rs.getInt("MaNhaCC"));
                sp.setIdLoai(rs.getInt("MaLoaiSp"));
                lst.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public int add(SanPham sp) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "INSERT [dbo].[SanPham] ([MaSanPham], [TenAnh], [MaNhaCC], [SoLuong], [MaLoaiSp], [TrangThai], [NgayNhap], [DonGia], [MoTa], [TenSanPham],[MaChatLieu] ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, sp.getMaSp());
            stm.setString(2, sp.getAnh());
            stm.setInt(3, sp.getIdNcc());
            stm.setInt(4, sp.getSolg());
            stm.setInt(5, sp.getIdLoai());
            stm.setBoolean(6, sp.isTrangThai());
            stm.setString(7, sp.getNgayNhap());
            stm.setFloat(8, sp.getDonGia());
            stm.setString(9, sp.getMoTa());
            stm.setString(10, sp.getTenSp());
            stm.setInt(11, sp.getIdChatLieu());
            if (stm.executeUpdate() > 0) {
                System.out.println("add Thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }

    public int del(String id) {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "delete from SanPham where MaSanPham = ?";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            if (stm.executeUpdate() > 0) {
                System.out.println("Xoa Thanh cong");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }

    public int update(SanPham sp) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = " update SanPham set SoLuong =?, TrangThai =?, NgayNhap = ?, DonGia = ?,MoTa = ?, TenSanPham=?, TenAnh =? ,MaChatLieu = ?, MaLoaiSp = ?, MaNhaCC =?\n"
                    + " where MaSanPham = ?";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(11, sp.getMaSp());
            stm.setString(7, sp.getAnh());
            stm.setInt(10, sp.getIdNcc());
            stm.setInt(1, sp.getSolg());
            stm.setInt(9, sp.getIdLoai());
            stm.setBoolean(2, sp.isTrangThai());
            stm.setString(3, sp.getNgayNhap());
            stm.setFloat(4, sp.getDonGia());
            stm.setString(5, sp.getMoTa());
            stm.setString(6, sp.getTenSp());
            stm.setInt(8, sp.getIdChatLieu());
            if (stm.executeUpdate() > 0) {
                System.out.println("Sửa Thành Công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }
    

    public ArrayList<SanPham> getSP(String Id) {
        ArrayList<SanPham> lst2 = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
//        SanPham sp = new SanPham();
        try {
            String sql = "select *,b.TenNhaCC as NhaCungCap, c.TenLoaiSP as Loai,d.TenChatLieu as ChatLieu ,e.TenAnh as Anh,e.TenAnhQR as AnhQR  from SanPham a  inner join SANPHAM_NhaCungCap b on  a.MaNhaCC = b.MaNhaCC\n"
                    + "inner join SANPHAM_LoaiSP c on a.MaLoaiSp = c.MaLoaiSp \n"
                    + "inner join SANPHAM_ChatLieu d on a.MaChatLieu = d.MaChatLieu\n"
                    + "inner join SANPHAM_AnhSP e on a.MaAnh = e.MaAnh where where a.TenSanPham like  N'%?%'";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
//            stm.setString(1, Id);
            rs = stm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
//                sp.setMaSp(rs.getString("MaSanPham"));
//                sp.setTenSp(rs.getNString("TenSanPham"));
//                sp.setMaCC(rs.getNString("NhaCungCap"));
//                sp.setAnh(rs.getNString("Anh"));
//                sp.setAnhQr(rs.getNString("AnhQR"));
//                sp.setLoai(rs.getNString("Loai"));
//                sp.setChatLieu(rs.getNString("ChatLieu"));
//                sp.setDonGia(rs.getFloat("DonGia"));
//                sp.setSolg(rs.getInt("SoLuong"));
//                sp.setMoTa(rs.getNString("MoTa"));
//                sp.setNgayNhap(rs.getDate("NgayNhap"));
//                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setMaSp(rs.getString(1));
                sp.setTenSp(rs.getNString(2));
                sp.setMaCC(rs.getNString(3));
                sp.setAnh(rs.getNString(4));
                sp.setAnhQr(rs.getNString(5));
                sp.setLoai(rs.getNString(6));
                sp.setChatLieu(rs.getNString(7));
                sp.setDonGia(rs.getFloat(8));
                sp.setSolg(rs.getInt(9));
                sp.setMoTa(rs.getNString(10));
                sp.setNgayNhap(String.valueOf(rs.getDate(11)));
                sp.setTrangThai(rs.getBoolean(12));
                lst2.add(sp);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                rs.close();
                stm.close();
            } catch (Exception e) {
            }
        }
        return lst2;
    }
}
