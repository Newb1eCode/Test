/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap {
    private int IDNhaCC;
    private String TenNhaCC ;
    private String email;
    private String sdt;
    private String DiaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(int IDNhaCC, String TenNhaCC, String email, String sdt, String DiaChi) {
        this.IDNhaCC = IDNhaCC;
        this.TenNhaCC = TenNhaCC;
        this.email = email;
        this.sdt = sdt;
        this.DiaChi = DiaChi;
    }

    public int getIDNhaCC() {
        return IDNhaCC;
    }

    public void setIDNhaCC(int IDNhaCC) {
        this.IDNhaCC = IDNhaCC;
    }

    public String getTenNhaCC() {
        return TenNhaCC;
    }

    public void setTenNhaCC(String TenNhaCC) {
        this.TenNhaCC = TenNhaCC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}
