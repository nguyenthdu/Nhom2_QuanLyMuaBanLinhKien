package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHangDAO {
	// Tìm khách hàng theo sđt
	public KhachHang getKHSDT(String soDTh) {
		KhachHang kh = null ;
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang where sdtKH = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, soDTh);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String maKH = rs.getString("maKhachHang");
				String tenKH = rs.getString("tenKhachHang");
				String soDT = rs.getString("sdtKH");
				String eMail = rs.getString("email");
				String diaChi = rs.getString("diaChiKH");
				kh = new KhachHang(maKH, tenKH, soDT, eMail, diaChi);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// Tìm khách hàng theo ten
	public ArrayList<KhachHang> getTKH(String ten) {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang where tenKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("maKhachHang");
				String tenKH = rs.getString("tenKhachHang");
				String soDT = rs.getString("sdtKH");
				String eMail = rs.getString("email");
				String diaChi = rs.getString("diaChiKH");
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDT, eMail, diaChi);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// Tìm khách hàng theo ma
	public ArrayList<KhachHang> getMKH(String ma) {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang where maKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("maKhachHang");
				String tenKH = rs.getString("tenKhachHang");
				String soDT = rs.getString("sdtKH");
				String eMail = rs.getString("email");
				String diaChi = rs.getString("diaChiKH");
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDT, eMail, diaChi);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// lay tat ca cac khách hàng
	public ArrayList<KhachHang> getDSKH() {
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		java.sql.Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from KhachHang";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString("maKhachHang");
				String tenKH = rs.getString("tenKhachHang");
				String soDT = rs.getString("sdtKH");
				String eMail = rs.getString("email");
				String diaChi = rs.getString("diaChiKH");
				KhachHang kh1 = new KhachHang(maKH, tenKH, soDT, eMail, diaChi);
				kh.add(kh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	// thêm khách hàng
	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getSoDT());
			stmt.setString(5, kh.geteMail());
			stmt.setString(4, kh.getDiaChi());

			return stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKhachHang = ?");
			stmt.setString(1, maKH);
			// hdBH_Dao.deleteMKH(maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;

	}

	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update KhachHang set tenKhachHang = ?,diaChiKH = ?, sdtKH=?,ngaySinhKH = ? where maKhachHang = ?");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getSoDT());
			stmt.setString(5, kh.geteMail());
			stmt.setString(4, kh.getDiaChi());
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public int makh() {
		int mkh = 0;
		try {
			ConnectDB.getInstance();
			java.sql.Connection con = ConnectDB.getConnection();
			String sql = "select count(*) from KhachHang";
			java.sql.Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				mkh = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mkh;
	}
}
