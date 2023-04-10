package entity;

public class DanhMucLinhKien {
	private int maDanhMuc;
	private String tenDanhMuc;
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public DanhMucLinhKien(int maDanhMuc, String tenDanhMuc) {
		setMaDanhMuc(maDanhMuc);
		setTenDanhMuc(tenDanhMuc);
	}
	public DanhMucLinhKien(){
		
	}
	public DanhMucLinhKien(int ma){
		setMaDanhMuc(ma);
	}

	
	
}
