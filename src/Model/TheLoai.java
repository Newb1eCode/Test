/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class TheLoai {
    private int Id_TheLoai;
    private String TenTheloai;

    public TheLoai() {
    }

    public TheLoai(int Id_TheLoai, String TenTheloai) {
        this.Id_TheLoai = Id_TheLoai;
        this.TenTheloai = TenTheloai;
    }

    public int getId_TheLoai() {
        return Id_TheLoai;
    }

    public void setId_TheLoai(int Id_TheLoai) {
        this.Id_TheLoai = Id_TheLoai;
    }

    public String getTenTheloai() {
        return TenTheloai;
    }

    public void setTenTheloai(String TenTheloai) {
        this.TenTheloai = TenTheloai;
    }
    
}
