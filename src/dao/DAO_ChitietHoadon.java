package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import databaseconnect.ConnectDB;
import entity.ChiTietHoaDon;

public class DAO_ChitietHoadon {

	public boolean themSanphamvaoCTHD(ChiTietHoaDon cthd) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = ConnectDB.getConnection();
		String sql = "Insert into ChiTietHoaDon (maHD, maSP, soLuong, donGia, thanhTien) values (?,?,?,?,?) ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, cthd.getHoadon().getMahoadon());
			stmt.setString(2, cthd.getSanpham().getMaSP());
			stmt.setDouble(4, cthd.getDongia());
			stmt.setInt(3, cthd.getSoluong());
			stmt.setDouble(5, cthd.getTongTien());
			int n = stmt.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
