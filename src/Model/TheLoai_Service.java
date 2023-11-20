/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dbConect.DBcontext1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class TheLoai_Service {

    public ArrayList<TheLoai> getall() {
        ArrayList<TheLoai> lst = new ArrayList<>();
        try {
            String sql = " select * from SANPHAM_LoaiSP";
            Connection cn = DBcontext1.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setId_TheLoai(rs.getInt("MaLoaiSp"));
                tl.setTenTheloai(rs.getNString("TenLoaiSP"));
                lst.add(tl);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public int add(TheLoai tl) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "insert into SANPHAM_LoaiSP(TenLoaiSP) values(?)";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, tl.getTenTheloai());
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
            String sql = "delete from SANPHAM_LoaiSP where MaLoaiSp = ?";
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

    public int update(TheLoai tl) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "  update SANPHAM_ChatLieu set TenChatLieu = ?  where MaLoaiSp =? ";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, tl.getTenTheloai());
            stm.setInt(2, tl.getId_TheLoai());

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
}
