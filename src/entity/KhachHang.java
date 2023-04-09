package entity;

public class KhachHang {
    private String maKH;
	private String tenKH;
	private int soDT;
	private String eMail;
	private String diaChi;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public KhachHang(String maKH, String tenKH, int soDT, String eMail, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soDT = soDT;
		this.eMail = eMail;
		this.diaChi = diaChi;
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", soDT=" + soDT + ", eMail=" + eMail + ", diaChi="
				+ diaChi + "]";
	}
}
