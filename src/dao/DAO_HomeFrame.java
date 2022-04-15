package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseconnect.ConnectDB;


public class DAO_HomeFrame {
     public String getTenNV(String manv) throws ClassNotFoundException {
    	 Connection con=ConnectDB.getConnection();
    	 String sql="select tenNV from nhanvien where maNV='"+manv+"'";
    	 String tennv=null;
    	 
    	 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			    tennv=rs.getString("tenNV");
			}
			return tennv;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    	 
     }
     public String getChucVu(String manv) throws ClassNotFoundException {
    	 Connection con=ConnectDB.getConnection();
    	 String sql="select chucvu from nhanvien where maNV='"+manv+"'";
    	 PreparedStatement ps=null;
    	 String chucvu=null;
    	 try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				chucvu=rs.getString("chucVu");
			}
			return chucvu;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
     }
}
