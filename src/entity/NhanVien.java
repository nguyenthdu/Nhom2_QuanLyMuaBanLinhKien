package entity;

import java.util.Date;

public class NhanVien {
    private String maNhanVien;
	private String hoTen;
	private Date ngaySinh;
	private String diaChi;
	private int soDT;
	private String eMail;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoDT() {
		return soDT;
	}
	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, String diaChi, int soDT, String eMail) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.eMail = eMail;
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

    public NhanVien() {
    }

    @Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi="
				+ diaChi + ", soDT=" + soDT + ", eMail=" + eMail + "]";
	}
}
