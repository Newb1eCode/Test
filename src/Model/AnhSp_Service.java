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
public class AnhSp_Service {
    public ArrayList<AnhSp> getall(){
        ArrayList<AnhSp> lst = new ArrayList<>();
        try {
            String sql =" select * from SANPHAM_AnhSP";
            Connection cn = DBcontext1.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                AnhSp a = new AnhSp();
                a.setID_anh(rs.getInt("MaAnh"));
                a.setTenAnh(rs.getNString("TenAnh"));
                a.setTenAnhQr(rs.getNString("TenAnhQR"));
                lst.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
    
    public int add(AnhSp a) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "insert into SANPHAM_AnhSP(TenAnh, TenAnhQR) values(?,?)";
            conn = DBcontext1.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, a.getTenAnh());
            stm.setString(2, a.getTenAnhQr());
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
