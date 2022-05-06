package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import databaseconnect.ConnectDB;
import entity.Khachhang;

public class DAO_Khachhang {

	public List<Khachhang> kiemtratontaiKhachhang(Khachhang khachhang) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Khachhang> dsKhachhang = new ArrayList<Khachhang>();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from KhachHang where tenKH = N'"+khachhang.getTenKH()+"' and SDT = '"+khachhang.getSodienthoai() +"' and diaChi = '"+khachhang.getDiachi()+"' and email ='"+khachhang.getEmail()+"'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				khachhang.setMaKH(rs.getInt("maKH"));
				dsKhachhang.add(khachhang);
			}
			return dsKhachhang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean insertKhachhang(Khachhang khachhang) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = ConnectDB.getConnection();
		String sql = "Insert into KhachHang (tenKH, SDT, diaChi, email) values (?,?,?,?) ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, khachhang.getTenKH());
			stmt.setString(2, khachhang.getSodienthoai());
			stmt.setString(3, khachhang.getDiachi());
			stmt.setString(4, khachhang.getEmail());
			int n = stmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Khachhang getKhachhang(String sodienthoai) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Khachhang khachhang = new Khachhang();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from KhachHang where SDT = '"+sodienthoai+"'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				khachhang.setTenKH(rs.getString("tenKH"));
				khachhang.setSodienthoai(rs.getString("SDT"));
				khachhang.setDiachi(rs.getString("diaChi"));
				khachhang.setEmail(rs.getString("email"));
				khachhang.setMaKH(rs.getInt("maKH"));
			}
			return khachhang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Khachhang> getKhachhangs() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from KhachHang";
		ArrayList<Khachhang> dskh=new ArrayList<Khachhang>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Khachhang khachhang = new Khachhang();
				khachhang.setMaKH(rs.getInt("maKH"));
				khachhang.setTenKH(rs.getString("tenKH"));
				khachhang.setSodienthoai(rs.getString("SDT"));
				khachhang.setDiachi(rs.getString("diaChi"));
				khachhang.setEmail(rs.getString("email"));
				dskh.add(khachhang);
			}
			return dskh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
