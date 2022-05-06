package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseconnect.ConnectDB;
import entity.ChiTietDonDatHang;
import entity.DonDatHang;
import entity.TrangThaiDonDat;

public class DAO_Dondathang {
	private Connection con;

	public DAO_Dondathang() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		this.con = ConnectDB.getConnection();
	}

	public int getMadonhang() {
		// TODO Auto-generated method stub
		int mahd = 0;
		String sql = "SELECT IDENT_CURRENT('DonDatHang')";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mahd = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mahd;
	}

	public TrangThaiDonDat getTrangthai(String tenTT) {
		// TODO Auto-generated method stub
		TrangThaiDonDat trangthai = new TrangThaiDonDat();
		String sql = "select * from TrangThaiDonHang where tenTrangThai = N'" + tenTT + "'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				trangthai.setMaTrangThai(rs.getString("maTrangThai"));
				trangthai.setTenTrangThai(rs.getString("tenTrangThai"));
			}
			return trangthai;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean insertDonhang(DonDatHang donhang) {
		// TODO Auto-generated method stub
		String sql = "insert into DonDatHang (maKH, maNV, ngayDat, ngayGiao,noiNhan,maTrangThai) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, donhang.getKhachHang().getMaKH());
			stmt.setString(2, donhang.getNhanvien().getMaNV());
			stmt.setDate(3, (Date) donhang.getNgaydat());
			stmt.setDate(4, (Date) donhang.getNgaygiao());
			stmt.setString(5, donhang.getNoiNhan());
			stmt.setString(6, donhang.getTrangThaiDonDat().getMaTrangThai());
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean capnhatTongtien(double tongtien) {
		String sql = "update DonDatHang\r\n" + "set tongTien = " + tongtien
				+ "where maDonDat = (SELECT IDENT_CURRENT('DonDatHang'))";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean themSanphamvaoCTHD(ChiTietDonDatHang chitietdonhang) {
		// TODO Auto-generated method stub
		String sql = "insert into ChiTietDonDatHang (maDonDat,maSP,soLuong,donGia,mucGiamGia) values (?,?,?,?,?) ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, chitietdonhang.getDondathang().getMaDonDat());
			stmt.setString(2, chitietdonhang.getSanpham().getMaSP());
			stmt.setDouble(4, chitietdonhang.getDongia());
			stmt.setInt(3, chitietdonhang.getSoluong());
			stmt.setDouble(5, chitietdonhang.getMucGiamGia());
			int n = stmt.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
