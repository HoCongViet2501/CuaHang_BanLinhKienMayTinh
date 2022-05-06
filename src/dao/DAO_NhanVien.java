package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import databaseconnect.ConnectDB;
import entity.NhanVien;

public class DAO_NhanVien {

	public ArrayList<NhanVien> getDSNV() throws ClassNotFoundException {
		String sql = "select * from nhanvien";
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			Connection connection = ConnectDB.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getString("maNV"));
				nv.setTenNV(rs.getString("tenNV"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setSodienthoai(rs.getString("SDT"));
				nv.setLuongcoban(rs.getDouble("luongCoBan"));
				nv.setChucvu(rs.getString("chucVu"));
				nv.setDiachi(rs.getString("diaChi"));
				
				nv.setMatkhau(rs.getString("matKhau"));
				nv.setEmail(rs.getString("email"));
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsnv;
	}

	public boolean delete(String manv) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "delete from NhanVien where maNV=?";
		Connection conn = ConnectDB.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, manv);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(NhanVien nv) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "update nhanvien set tenNV=?,gioiTinh=?, SDT=?,chucVu=?,luongCoBan=?,diachi=?,matKhau=?,email=? where maNV=? ";
		Connection conn = ConnectDB.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nv.getTenNV());
			ps.setString(3, nv.getSodienthoai());
			ps.setBoolean(2, nv.getGioiTinh());
			ps.setString(4, nv.getChucvu());
			ps.setDouble(5, nv.getLuongcoban());
			ps.setString(6, nv.getDiachi());
			ps.setString(7, nv.getMatkhau());
			ps.setString(8, nv.getEmail());
			ps.setString(9, nv.getMaNV());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean insert(NhanVien nv) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "insert into NhanVien values (?,?,?,?,?,?,?,?,?) ";
		Connection conn = ConnectDB.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nv.getMaNV());
			ps.setString(2, nv.getTenNV());
			ps.setBoolean(3, nv.getGioiTinh());
			ps.setString(4, nv.getSodienthoai());
			ps.setString(5, nv.getChucvu());
			ps.setDouble(6, nv.getLuongcoban());
			ps.setString(7, nv.getDiachi());
			ps.setString(9, nv.getEmail());
			ps.setString(8, nv.getMatkhau());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

}
