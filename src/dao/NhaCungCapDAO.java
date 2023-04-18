package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaCungCapLinhKien;

public class NhaCungCapDao {
	// Tìm số điện thoại
	public NhaCungCapLinhKien timSDT(String sdt) {
		NhaCungCapLinhKien ncc = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCapLinhKien where SoDienThoai = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdt);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String MaNhaCungCap = rs.getString("maNhaCungCap");
				String TenNCC = rs.getString("tenNhaCungCap");
				String DiaChi = rs.getString("diaChi");
				String SoDienThoai = rs.getString("sdtNCC");
				 ncc = new NhaCungCapLinhKien(MaNhaCungCap, TenNCC, DiaChi, SoDienThoai);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}

	public ArrayList<NhaCungCapLinhKien> timMNCC(String ma) {
		ArrayList<NhaCungCapLinhKien> ncc = new ArrayList<NhaCungCapLinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCapLinhKien where MaNhaCungCap = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String MaNhaCungCap = rs.getString("maNhaCungCap");
				String TenNCC = rs.getString("tenNhaCungCap");
				String DiaChi = rs.getString("diaChi");
				String SoDienThoai = rs.getString("sdtNCC");
				NhaCungCapLinhKien ncc1 = new NhaCungCapLinhKien(MaNhaCungCap, TenNCC, DiaChi, SoDienThoai);
				ncc.add(ncc1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}

	// Tìm theo tên nhà cung cấp
	public ArrayList<NhaCungCapLinhKien> timTNCC(String ten) {
		ArrayList<NhaCungCapLinhKien> ncc = new ArrayList<NhaCungCapLinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCapLinhKien where TenNCC = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String MaNhaCungCap = rs.getString("maNhaCungCap");
				String TenNCC = rs.getString("tenNhaCungCap");
				String DiaChi = rs.getString("diaChi");
				String SoDienThoai = rs.getString("sdtNCC");
				NhaCungCapLinhKien ncc1 = new NhaCungCapLinhKien(MaNhaCungCap, TenNCC, DiaChi, SoDienThoai);
				ncc.add(ncc1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}

	// Lấy ds nha cung cap
	public ArrayList<NhaCungCapLinhKien> getDSNCC() {
		ArrayList<NhaCungCapLinhKien> dsNCC = new ArrayList<NhaCungCapLinhKien>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from NhaCungCapLinhKien";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String MaNhaCungCap = rs.getString("maNhaCungCap");
				String TenNCC = rs.getString("tenNhaCungCap");
				String DiaChi = rs.getString("diaChi");
				String SoDienThoai = rs.getString("sdtNCC");
				NhaCungCapLinhKien ncc1 = new NhaCungCapLinhKien(MaNhaCungCap, TenNCC, DiaChi, SoDienThoai);
				dsNCC.add(ncc1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNCC;
	}

	// tạo nhà cung cấp mới
	public boolean create(NhaCungCapLinhKien ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhaCungCapLinhKien values(?,?,?,?)");
			stmt.setString(1, ncc.getMaNhaCungCap());
			stmt.setString(2, ncc.getTenNCC());
			stmt.setString(3, ncc.getDiaCHi());
			stmt.setString(4, ncc.getSoDienThoai());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// update nhà cung cấp mới
	public boolean update(NhaCungCapLinhKien ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update NhaCungCapLinhKien set TenNCC = ?, DiaChi = ?, SoDienThoai = ? where MaNhaCungCap = ?");
			stmt.setString(4, ncc.getMaNhaCungCap());
			stmt.setString(1, ncc.getTenNCC());
			stmt.setString(2, ncc.getDiaCHi());
			stmt.setString(3, ncc.getSoDienThoai());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// xóa nhà cung cấp
	public boolean deleteMNCC(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCapLinhKien where MaNhaCungCap = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public int mancc() {
		int maNCC = 0;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from NhaCungCapLinhKien";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maNCC = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maNCC;
	}
}
