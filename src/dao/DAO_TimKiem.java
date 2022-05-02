package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import databaseconnect.ConnectDB;

public class DAO_TimKiem {

	public List<List<String>> searchHoaDon(Map<String, String> mapTK) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> list= new ArrayList<>();
		String sql =  "select maHD,tenNV,tenKH,tongTien,ngayLapHD from NhanVien as nv "
			+ "join  HoaDon as hd on hd.maNV = nv.maNV join KhachHang as kh on kh.maKH = hd.maKH where ";
		Set<String> set = mapTK.keySet();
		for(String key: set) {
			if(key.equals("maHD") || key.equals("SDT")) {
				list.add(" " + key + " = ?");
			}else {
				list.add(" " + key + " like ?");
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<List<String>> ds = new ArrayList<List<String>>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int j = 1;
		for(String key: set) {
			stmt.setString(j, mapTK.get(key));
			j++;
		}
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			List<String> item  = new ArrayList<String>();
			item.add(rs.getString("maHD"));
			item.add(rs.getString("tenNV"));
			item.add(rs.getString("tenKH"));
			item.add(rs.getString("tongTien"));
			item.add(rs.getString("ngayLapHD"));
			ds.add(item);
		}
		return ds;
	}

	public List<List<String>> getDanhSachSP(String mahd) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select cthd.maSP, sp.tenSP, sp.donGia, cthd.soLuong from ChiTietHoaDon as"
				+ " cthd join SanPham as sp on cthd.maSP = sp.maSP where maHD = ?";
		List<List<String>> ds = new ArrayList<List<String>>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, mahd);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			List<String> item  = new ArrayList<String>();
			item.add(rs.getString("maSP"));
			item.add(rs.getString("tenSP"));
			item.add(rs.getString("donGia"));
			item.add(rs.getString("soLuong"));
			ds.add(item);
		}
		return ds;
	}

	public List<List<String>> searchDonDatHang(Map<String, String> mapTK) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select maDonDat,tenKH,ngayDat,ngayGiao,tongTien,tenTrangThai from KhachHang"
			+ " as kh join DonDatHang as d on d.maKH = kh.maKH join TrangThaiDonHang as tt on tt.maTrangThai = d.maTrangThai where ";
		ArrayList<String> list= new ArrayList<>();
		Set<String> set = mapTK.keySet();
		for(String key: set) {
			if(key.equals("maDonDat") || key.equals("kh.SDT")||key.equals("ngayDat")||key.equals("ngayGiao")) {
				list.add(" " + key + " = ?");
			}else {
				list.add(" " + key + " like ?");
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		sql = sql + String.join(" and ", arr);
		List<List<String>> ds = new ArrayList<List<String>>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int j = 1;
		for(String key: set) {
			stmt.setString(j, mapTK.get(key));
			j++;
		}
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			List<String> item  = new ArrayList<String>();
			item.add(rs.getString("maDonDat"));
			item.add(rs.getString("tenKH"));
			item.add(rs.getString("ngayDat"));
			item.add(rs.getString("ngayGiao"));
			item.add(rs.getString("tongTien"));
			
			item.add(rs.getString("tenTrangThai"));
			ds.add(item);
		}
		return ds;
	}

	public List<List<String>> getDanhSachSPDDH(String ma) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select tenSP,soLuong,sp.donGia,mucGiamGia from SanPham as sp join"
				+ " ChiTietDonDatHang as ctdd on ctdd.maSP = sp.maSP where maDonDat = ?";
		List<List<String>> ds = new ArrayList<List<String>>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, ma);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			List<String> item  = new ArrayList<String>();
			item.add(rs.getString("tenSP"));
			item.add(rs.getString("donGia"));
			item.add(rs.getString("soLuong"));
			item.add(rs.getString("mucGiamGia"));
			ds.add(item);
		}
		return ds;
	}

}
