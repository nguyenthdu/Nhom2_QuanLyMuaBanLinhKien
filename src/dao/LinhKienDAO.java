package dao;

import connectDB.ConnectDB;
import entity.DanhMucLinhKien;
import entity.LinhKien;
import entity.NhaCungCapLinhKien;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

public class LinhKienDAO {
    public ArrayList <LinhKien> layThongTin(){
        ArrayList <LinhKien> dsLinhKien = new ArrayList<LinhKien>();
        try {
            /*
            Ket noi SQL
             */
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            /*
            Thuc thi cau lenh SQL
             */
            String SQL = "SELECT * FROM LinhKien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                String maLK = rs.getString(1);
                String tenLK = rs.getString(2);
                int soLuong = rs.getInt(3);
                double giaBan = rs.getDouble(4);
                int thoiGianBH = rs.getInt(5);
                DanhMucLinhKien danhMuc = new DanhMucLinhKien(rs.getString(6));
                NhaCungCapLinhKien nhaCungCap = new NhaCungCapLinhKien(rs.getString(7));
                LinhKien lk = new LinhKien(maLK, tenLK,soLuong,giaBan,thoiGianBH,danhMuc,nhaCungCap);
                dsLinhKien.add(lk);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dsLinhKien;
    }
}
