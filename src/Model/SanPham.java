/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class SanPham {
    private String maSp;
    private String tenSp;
    private String maCC;
    private String anh;
    private String anhQr;
    private String loai;
    private String ChatLieu;
    private int Solg;
    private float donGia;
    private String ngayNhap;
    private boolean trangThai;
    private String moTa;
    private int maAnh;
    private int IdNcc;
    private int idLoai;
    private int idChatLieu;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, String maCC, String anh, String anhQr, String loai, String ChatLieu, int Solg, float donGia, String ngayNhap, boolean trangThai, String moTa, int maAnh, int IdNcc, int idLoai, int idChatLieu) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.maCC = maCC;
        this.anh = anh;
        this.anhQr = anhQr;
        this.loai = loai;
        this.ChatLieu = ChatLieu;
        this.Solg = Solg;
        this.donGia = donGia;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.maAnh = maAnh;
        this.IdNcc = IdNcc;
        this.idLoai = idLoai;
        this.idChatLieu = idChatLieu;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMaCC() {
        return maCC;
    }

    public void setMaCC(String maCC) {
        this.maCC = maCC;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getAnhQr() {
        return anhQr;
    }

    public void setAnhQr(String anhQr) {
        this.anhQr = anhQr;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public int getSolg() {
        return Solg;
    }

    public void setSolg(int Solg) {
        this.Solg = Solg;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaAnh() {
        return maAnh;
    }

    public void setMaAnh(int maAnh) {
        this.maAnh = maAnh;
    }

    public int getIdNcc() {
        return IdNcc;
    }

    public void setIdNcc(int IdNcc) {
        this.IdNcc = IdNcc;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }
    
   
    public  String gettrangThai(){
        return trangThai ? "Còn Hàng ": "Hết Hàng";
    }

  
}
