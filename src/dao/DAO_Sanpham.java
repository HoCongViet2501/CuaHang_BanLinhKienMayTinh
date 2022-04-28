package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import databaseconnect.ConnectDB;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.SanPham;


public class DAO_Sanpham {
	public List<SanPham> getSanPham(String ten) throws ClassNotFoundException{
		List<SanPham> dssp = new ArrayList<SanPham>();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from SanPham sp join NhaCungCap ncc on sp.maNCC=ncc.maNCC "
				+ "join LoaiSanPham lsp on sp.maLoaiSP=lsp.maLoaiSP where tenSP like N'%"+ten+"%'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SanPham sp=new SanPham();
				sp.setMaSP(rs.getString("maSP"));
				sp.setTenSP(rs.getString("tenSP"));
				sp.setDonGia(rs.getDouble("donGia"));
				sp.setSlton(rs.getInt("soLuongTon"));
				sp.setMaLoaiSP(new LoaiSanPham(rs.getString("maLoaiSP"), rs.getString("tenLoaiSP")));
				sp.setMaNCC(new NhaCungCap(rs.getString("maNCC"),rs.getString("tenNCC"),rs.getString("diaChi"),rs.getString("SDT")));
				dssp.add(sp);
			}
			return dssp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<NhaCungCap> getNhacungcap() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "Select * from NhaCungCap";
		List<NhaCungCap> dsNhacungcap = new ArrayList<NhaCungCap>();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			NhaCungCap nhacungcap = new NhaCungCap();
			nhacungcap.setMaNCC(rs.getString("maNCC"));
			nhacungcap.setTenNCC(rs.getString("tenNCC"));
			nhacungcap.setSdt(rs.getString("SDT"));
			nhacungcap.setDiachi(rs.getString("diaChi"));
			
			dsNhacungcap.add(nhacungcap);
		}
		return dsNhacungcap;
	}

	public boolean insertSanpham(SanPham sanpham, String path) throws ClassNotFoundException {
		// TODO Auto-generated method stub
			String sql = "Insert into sanpham(maSP,tenSP,soLuongTon,donGia,hinhAnh,maLoaiSP,maNCC)  values (?,?,?,?,?,?,?)";
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt;
			try {
				FileInputStream in = new FileInputStream(path);
				stmt = con.prepareStatement(sql);
				stmt.setString(1, sanpham.getMaSP());
				stmt.setString(2, sanpham.getTenSP());
				stmt.setDouble(4, sanpham.getDonGia());
				stmt.setInt(3, sanpham.getSlton());
				stmt.setBinaryStream(5, in);
				stmt.setString(6, sanpham.getMaLoaiSP().getMaLoaiSP());
				stmt.setString(7, sanpham.getMaNCC().getMaNCC());
				int n = stmt.executeUpdate();
				return n > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteSanpham(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "Delete from SanPham where maSP like '" + id+"'";
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int n = stmt.executeUpdate();
		return n > 0;
	}

	public boolean updateSanpham(SanPham sanpham, String path,String mancc,String maloai) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "Update SanPham set tenSP =?, soLuongTon=?,donGia=?,hinhAnh=?,maNCC=?,maLoaiSP=? where maSP like ?";
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt;
		try {
			FileInputStream in = new FileInputStream(path);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sanpham.getTenSP());
			stmt.setDouble(3, sanpham.getDonGia());
			stmt.setInt(2, sanpham.getSlton());
			stmt.setBinaryStream(4, in);
			stmt.setString(5,maloai);
			stmt.setString(6, mancc);
			stmt.setString(7, sanpham.getMaSP());
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public String getImg(String id) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		InputStream in;
		FileOutputStream out;
		String path = "";
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from SanPham  where maSP like '" + id+"'";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		File file = new File("mainpc.jpg");
		out = new FileOutputStream(file);
		if (rs.next()) {
			in = rs.getBinaryStream("hinhanh");
			byte[] buffer = new byte[1024];
			while (in.read(buffer) > 0) {
				out.write(buffer);
			}
			path = file.getAbsolutePath();
		}
		out.close();
		return path;
	}
}
