package entity;

import java.util.List;

public class ChiTietHoaDon {
    private LinhKien linhKien;
    private int soLuong;
    private double khuyenMai;
    private HoaDon hoaDon;
    private DonDatHang donDatHang;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(LinhKien linhKien, int soLuong, double khuyenMai, HoaDon hoaDon, DonDatHang donDatHang) {
        this.linhKien = linhKien;
        this.soLuong = soLuong;
        this.khuyenMai = khuyenMai;
        this.hoaDon = hoaDon;
        this.donDatHang = donDatHang;
    }

    public LinhKien getLinhKien() {
        return linhKien;
    }

    public void setLinhKien(LinhKien linhKien) {
        this.linhKien = linhKien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(double khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public DonDatHang getDonDatHang() {
        return donDatHang;
    }

    public void setDonDatHang(DonDatHang donDatHang) {
        this.donDatHang = donDatHang;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "linhKien=" + linhKien +
                ", soLuong=" + soLuong +
                ", khuyenMai=" + khuyenMai +
                ", hoaDon=" + hoaDon +
                ", donDatHang=" + donDatHang +
                '}';
    }
}
