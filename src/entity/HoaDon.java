package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HoaDon {
	private int mahoadon;
	private Khachhang khachHang;
	private NhanVien nhanVien;
	private Date ngayLapHD;
	private double tienNhan;
	private double tongTien;
	public HoaDon(int mahoadon, Khachhang khachHang, NhanVien nhanVien, Date ngayLapHD, double tienNhan,
			double tongTien) {
		super();
		this.mahoadon = mahoadon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHD = ngayLapHD;
		this.tienNhan = tienNhan;
		this.tongTien = tongTien;
	}
	

	List<ChiTietHoaDon> dsChiTietHoaDon;
	
	public HoaDon() {
		dsChiTietHoaDon=new ArrayList<ChiTietHoaDon>();
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	
	public Khachhang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(Khachhang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public double getTienNhan() {
		return tienNhan;
	}
	public void setTienNhan(double tienNhan) {
		this.tienNhan = tienNhan;
	}
	
	public void removeChitietHoadon(int i) {
		double tientru = (dsChiTietHoaDon.get(i).getDongia() * dsChiTietHoaDon.get(i).getSoluong()) ;
		dsChiTietHoaDon.remove(i);
		this.tongTien -= tientru;
	}
	public void addChitietHoadon(HoaDon hoadon, SanPham sanpham, int soluong, double dongia) {
		// TODO Auto-generated method stub
		ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon, sanpham, soluong, dongia);
		dsChiTietHoaDon.add(cthd);
		this.tongTien += (cthd.getDongia()*cthd.getSoluong());
	}
	public void updateChitietHoadon(int i, int soluong) {
		double tientru = (dsChiTietHoaDon.get(i).getDongia() * dsChiTietHoaDon.get(i).getSoluong()) ;
		this.tongTien -= tientru;
		dsChiTietHoaDon.get(i).setSoluong(soluong);
		this.tongTien += (dsChiTietHoaDon.get(i).getDongia() * dsChiTietHoaDon.get(i).getSoluong()) ;
	}
	 
}
