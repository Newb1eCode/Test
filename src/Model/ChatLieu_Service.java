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
public class ChatLieu_Service {
    public ArrayList<ChatLieu> getall(){
        ArrayList<ChatLieu> lst = new ArrayList<>();
        try {
            String sql =" select * from SANPHAM_ChatLieu";
            Connection cn = DBcontext1.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChatLieu cl = new ChatLieu();
                cl.setIDChatLieu(rs.getInt("MaChatLieu"));
                cl.setChatLieu(rs.getNString("TenChatLieu"));
                lst.add(cl);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
    public int add(ChatLieu cl) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "insert into SANPHAM_ChatLieu(TenChatLieu) values(?)";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, cl.getChatLieu());
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
            String sql = "delete from SANPHAM_ChatLieu where MaChatLieu = ?";
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
     public int update(ChatLieu cl) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "  update SANPHAM_ChatLieu set TenChatLieu = ?  where MaLoaiSp =? ";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, cl.getChatLieu());
            stm.setInt(2, cl.getIDChatLieu());
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
