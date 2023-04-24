package entity;

public class ChiTietHoaDon {
    private LinhKien linhKien;
    private int soLuong;
    private HoaDon hoaDon;
    private DonDatHang donDatHang;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(LinhKien linhKien, int soLuong, HoaDon hoaDon, DonDatHang donDatHang) {
        this.linhKien = linhKien;
        this.soLuong = soLuong;
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

                ", hoaDon=" + hoaDon +
                ", donDatHang=" + donDatHang +
                '}';
    }
}
