/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBcontext1 {
 public  static String user = "sa";
     public  static String pass = "123456";
     public  static String url = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041;encrypt=true;trustServerCertificate=true";
      static {
     try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(DBcontext1.class.getName()).log(Level.SEVERE, null, ex);
     }
      }
      public static Connection getConnection(){
          Connection conn = null;
     try {
         conn = DriverManager.getConnection(url, user, pass);
     } catch (SQLException ex) {
         Logger.getLogger(DBcontext1.class.getName()).log(Level.SEVERE, null, ex);
     }
          return conn;
      }
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn!=null) {
            System.out.println("Kết nỗi thanh cônng");
        }else{
            System.out.println("kết nối thất bại");
        }
    }
}
