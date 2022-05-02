package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import databaseconnect.ConnectDB;
import entity.SanPham;

public class DAO_ThongKe {

	public List<SanPham> getSanpham() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select maSP,tenSP,soLuongTon,donGia from sanpham";
		List<SanPham> list =  new ArrayList<SanPham>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			SanPham sp = new SanPham(rs.getString("maSP"),rs.getString("tenSP"),Integer.parseInt(rs.getString("soLuongTon")) , Double.parseDouble(rs.getString("dongia")));
			list.add(sp);
		}
		return list;
	}

	public Map<String, String> getCountSP(List<String> list, String ngaybatdau, String ngayketthuc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select sum(soLuong) as tong from SanPham as sp join ChiTietHoaDon as cthd on sp.maSP = cthd.maSP join HoaDon as hd on hd.maHD= cthd.maHD where sp.maSP = ? and (ngayLapHD between ? and ?)";
		Map<String, String> map = new HashMap<String, String>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt  = con.prepareStatement(sql);
		stmt.setString(2, ngaybatdau);
		stmt.setString(3, ngayketthuc);
		for(String i: list) {
			stmt.setString(1, i);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("tong") == null) {
					map.put(i, null);
				}else {
					map.put(i, rs.getString("tong"));
				}
			}
		}
		return map;
	}

	public Map<String, String> getThongkeHDTheoNgay(String ngaybatdau, String ngayketthuc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select sum(tongTien) as tong,ngayLapHD from HoaDon where ngayLapHD between ? and ? "
				+ "group by ngayLapHD"
				+ " ORDER BY ngayLapHD ASC";
		Map<String,String> map = new HashMap<String, String>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, ngaybatdau);
		stmt.setString(2, ngayketthuc);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			map.put(rs.getString("ngayLapHD"), rs.getString("tong"));
		}
		return map;
	}

	public List<List<String>> searchHDTheoNgay(String ngaybatdau, String ngayketthuc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select maHD, tenNV,tenKH,kh.SDT, kh.diaChi,kh.email,ngayLapHD,tongTien from HoaDon as hd join NhanVien as nv "
				+ "on hd.maNV = nv.maNV join KhachHang as kh on hd.maKH = kh.maKH where ngayLapHD  between ? and ?";
		List<List<String>> list = new ArrayList<List<String>>();
		Connection con  = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, ngaybatdau);
		stmt.setString(2, ngayketthuc);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			List<String> item = new ArrayList<String>();
			item.add(rs.getString("maHD"));
			item.add(rs.getString("tenNV"));
			item.add(rs.getString("tenKH"));
			item.add(rs.getString("SDT"));
			item.add(rs.getString("diaChi"));
			item.add(rs.getString("email"));
			item.add(rs.getString("ngayLapHD"));
			item.add(rs.getString("tongTien"));
			list.add(item);
		}
		return list;
	}

}
