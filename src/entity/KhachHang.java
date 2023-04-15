package entity;

public class KhachHang {
    private String maKH;
	private String tenKH;
	private String soDT;
	private String eMail;
	private String diaChi;

	public KhachHang(String maKH, String tenKH, String soDT, String eMail, String diaChi) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.soDT = soDT;
		this.eMail = eMail;
		this.diaChi = diaChi;
	}

	public KhachHang(String maKH) {
		this.maKH = maKH;
	}

	public KhachHang() {
	}

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

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
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

	@Override
	public String toString() {
		return "KhachHang{" +
				"maKH='" + maKH + '\'' +
				", tenKH='" + tenKH + '\'' +
				", soDT='" + soDT + '\'' +
				", eMail='" + eMail + '\'' +
				", diaChi='" + diaChi + '\'' +
				'}';
	}
}
