package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import databaseconnect.ConnectDB;
import entity.HoaDon;

public class DAO_Hoadon {

	public boolean insertHoadon(HoaDon hoadon) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
 	   	LocalDateTime now = LocalDateTime.now();
		Connection con = ConnectDB.getConnection(); 
		String sql = "Insert into hoadon (maKH,maNV,ngayLapHD,soTienNhan,tongTien) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, hoadon.getKhachHang().getMaKH());
			stmt.setString(2, hoadon.getNhanVien().getMaNV());
			stmt.setString(3, dtf.format(now));
			stmt.setDouble(4, hoadon.getTienNhan());
			stmt.setDouble(5, hoadon.getTongTien());
			int n = stmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean capnhatTongtien(double tongtien) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = ConnectDB.getConnection();
		String sql = "update HoaDon \r\n"
				+ "set tongTien = "+tongtien
				+ "where maHD = (SELECT IDENT_CURRENT('HoaDon'))";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int n = stmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	public int getMahoadon() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int mahd = 0;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT IDENT_CURRENT('HoaDon')";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				mahd = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mahd;
	}

}
