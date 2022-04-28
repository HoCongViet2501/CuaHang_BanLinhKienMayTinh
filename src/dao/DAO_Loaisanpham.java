package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseconnect.ConnectDB;
import entity.LoaiSanPham;


public class DAO_Loaisanpham {
	public static List<LoaiSanPham> getLoaiSanPham() throws SQLException, ClassNotFoundException {
		String sql = "Select * from loaisanpham";
		List<LoaiSanPham> dslsp = new ArrayList<LoaiSanPham>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			LoaiSanPham loaisp = new LoaiSanPham();
			loaisp.setMaLoaiSP(rs.getString("maLoaiSP"));
			loaisp.setTenLoaiSP(rs.getString("tenLoaiSP"));
			dslsp.add(loaisp);
		}
		return dslsp;
	}

	public static boolean insert(String maLoaiSP, String tenLoaiSP) throws ClassNotFoundException {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "insert into loaisanpham values(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maLoaiSP);
			stmt.setString(2, tenLoaiSP);
			stmt.executeUpdate();
			return true;
		} catch (SQLException err) {
			// TODO: handle exception
			System.out.println(err);
			return false;
		}
	}

	public static boolean delete(String maLoaiSP) throws ClassNotFoundException {
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "delete from LoaiSanPham where maLoaiSP=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maLoaiSP);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public static boolean updateLoaiSanPham(String maLSP, String tenLoaiSP) throws ClassNotFoundException {
		String sql = "update LoaiSanPham set tenLoaiSP = ? where  maLoaiSP= ?";
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tenLoaiSP);
			stmt.setString(2, maLSP);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
