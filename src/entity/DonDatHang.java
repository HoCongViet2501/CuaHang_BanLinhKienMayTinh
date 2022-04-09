package entity;

import java.util.Date;

public class DonDatHang {
	private int maDonDat;
	private Khachhang khachHang;
	private NhanVien nhanvien;
	private java.util.Date ngaydat;
	private java.util.Date ngaygiao;
	private java.util.Date ngayChuyen;
	private String noiNhan;
	public int getMaDonDat() {
		return maDonDat;
	}
	public void setMaDonDat(int maDonDat) {
		this.maDonDat = maDonDat;
	}
	public Khachhang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(Khachhang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public java.util.Date getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(java.util.Date ngaydat) {
		this.ngaydat = ngaydat;
	}
	public java.util.Date getNgaygiao() {
		return ngaygiao;
	}
	public void setNgaygiao(java.util.Date ngaygiao) {
		this.ngaygiao = ngaygiao;
	}
	public java.util.Date getNgayChuyen() {
		return ngayChuyen;
	}
	public void setNgayChuyen(java.util.Date ngayChuyen) {
		this.ngayChuyen = ngayChuyen;
	}
	public String getNoiNhan() {
		return noiNhan;
	}
	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}
	public DonDatHang(int maDonDat, Khachhang khachHang, NhanVien nhanvien, Date ngaydat, Date ngaygiao,
			Date ngayChuyen, String noiNhan) {
		super();
		this.maDonDat = maDonDat;
		this.khachHang = khachHang;
		this.nhanvien = nhanvien;
		this.ngaydat = ngaydat;
		this.ngaygiao = ngaygiao;
		this.ngayChuyen = ngayChuyen;
		this.noiNhan = noiNhan;
	}
	@Override
	public String toString() {
		return "DonDatHang [maDonDat=" + maDonDat + ", khachHang=" + khachHang + ", nhanvien=" + nhanvien + ", ngaydat="
				+ ngaydat + ", ngaygiao=" + ngaygiao + ", ngayChuyen=" + ngayChuyen + ", noiNhan=" + noiNhan + "]";
	}
	
}
