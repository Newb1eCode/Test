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
public class NhaCungCap_Service {
    public ArrayList<NhaCungCap> getall(){
        ArrayList<NhaCungCap> lst = new ArrayList<>();
        try {
            String sql =" select * from SANPHAM_NhaCungCap";
            Connection cn = DBcontext1.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhaCungCap ncc = new NhaCungCap();
                ncc.setIDNhaCC(rs.getInt("MaNhaCC"));
                ncc.setTenNhaCC(rs.getNString("TenNhaCC"));
                ncc.setEmail(rs.getNString("email"));
                ncc.setSdt(rs.getNString("sdt"));
                ncc.setDiaChi(rs.getNString("DiaChi"));
                lst.add(ncc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
    public int add(NhaCungCap ncc) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "insert into SANPHAM_NhaCungCap(TenNhaCC, email, sdt, DiaChi) values(?,?,?,?) ";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, ncc.getTenNhaCC());
            stm.setString(2, ncc.getEmail());
            stm.setString(3, ncc.getSdt());
            stm.setString(4, ncc.getDiaChi());
            
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
            String sql = "delete from SANPHAM_NhaCungCap where MaNhaCC = ?";
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
    
     public int update(NhaCungCap ncc) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "  update SANPHAM_NhaCungCap set TenNhaCC = ? ,DiaChi= ?, email = ?, sdt = ? where MaNhaCC =? ";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, ncc.getTenNhaCC());
            stm.setString(2, ncc.getEmail());
            stm.setString(3, ncc.getSdt());
            stm.setString(4, ncc.getDiaChi());
            stm.setInt(5, ncc.getIDNhaCC());
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
