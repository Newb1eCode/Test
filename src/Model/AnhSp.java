/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class AnhSp {
    private int ID_anh;
    private String TenAnh;
    private String tenAnhQr;

    public AnhSp() {
    }

    public AnhSp(int ID_anh, String TenAnh, String tenAnhQr) {
        this.ID_anh = ID_anh;
        this.TenAnh = TenAnh;
        this.tenAnhQr = tenAnhQr;
    }

    public int getID_anh() {
        return ID_anh;
    }

    public void setID_anh(int ID_anh) {
        this.ID_anh = ID_anh;
    }

    public String getTenAnh() {
        return TenAnh;
    }

    public void setTenAnh(String TenAnh) {
        this.TenAnh = TenAnh;
    }

    public String getTenAnhQr() {
        return tenAnhQr;
    }

    public void setTenAnhQr(String tenAnhQr) {
        this.tenAnhQr = tenAnhQr;
    }
    
}
