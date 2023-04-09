package entity;

import java.sql.Date;
import java.util.Objects;

public class DonDatHang {
	private String maDonDatHang;
	private KhachHang maKhachHang;
	private Date ngayLap;
	
	
	public DonDatHang() {
		super();
	}


	public DonDatHang(String maDonDatHang, KhachHang maKhachHang, Date ngayLap) {
		super();
		this.maDonDatHang = maDonDatHang;
		this.maKhachHang = maKhachHang;
		this.ngayLap = ngayLap;
	}


	public String getMaDonDatHang() {
		return maDonDatHang;
	}


	public void setMaDonDatHang(String maDonDatHang) {
		this.maDonDatHang = maDonDatHang;
	}


	public KhachHang getKhachHang() {
		return maKhachHang;
	}


	public void setKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}


	public Date getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}


	
	
	@Override
	public int hashCode() {
		return Objects.hash(maDonDatHang);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonDatHang other = (DonDatHang) obj;
		return Objects.equals(maDonDatHang, other.maDonDatHang);
	}


	@Override
	public String toString() {
		return "DonDatHang [maDonDatHang=" + maDonDatHang + ", khachHang=" + maKhachHang + ", ngayLap=" + ngayLap + "]";
	}
	
	
	

}
