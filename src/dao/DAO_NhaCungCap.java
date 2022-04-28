package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseconnect.ConnectDB;
import entity.NhaCungCap;

public class DAO_NhaCungCap {

	public List<NhaCungCap> getNhaCungCap() throws SQLException, ClassNotFoundException {
		String sql = "Select * from NhaCungCap";
		List<NhaCungCap> dsncc = new ArrayList<NhaCungCap>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"),rs.getString("tenNCC"),rs.getString("diaChi"),rs.getString("SDT"));
			dsncc.add(ncc);
		}
		return dsncc;
	}

	public boolean update(String mancc, String tenncc, String diachi, String sdt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "update NhaCungCap set tenNCC = ?, diaChi = ?, SDT=? where maNCC = ?";
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, tenncc);
		stmt.setString(2, diachi);
		stmt.setString(3, sdt);
		stmt.setString(4, mancc);
		stmt.executeUpdate();
		return true;
	}

	public boolean insert(String mancc, String tenncc, String diachi, String sdt) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "insert into NhaCungCap values(?,?,?,?)";
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, mancc);
		stmt.setString(2, tenncc);
		stmt.setString(3, diachi);
		stmt.setString(4, sdt);
		stmt.executeUpdate();
		return true;
	}

	public boolean delete(String mancc) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from NhaCungCap where maNCC = ?";
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, mancc);
		stmt.executeUpdate();
		return true;
	}

}
