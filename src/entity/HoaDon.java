package entity;

import java.util.Date;

public class HoaDon {
	private int mahoadon;
	private Khachhang khachHang;
	private NhanVien nhanVien;
	private String tenKH;
	private String sdt;
	private String tenSP;
	private Date ngayGiao;
	private String diaChiGiao;
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public Khachhang getMaKH() {
		return khachHang;
	}
	public void setMaKH(Khachhang maKH) {
		this.khachHang = maKH;
	}
	public NhanVien getManv() {
		return nhanVien;
	}
	public void setManv(NhanVien manv) {
		this.nhanVien = manv;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public Date getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	public String getDiaChiGiao() {
		return diaChiGiao;
	}
	public void setDiaChiGiao(String diaChiGiao) {
		this.diaChiGiao = diaChiGiao;
	}
	@Override
	public String toString() {
		return "HoaDon [mahoadon=" + mahoadon + ", maKH=" + khachHang + ", manv=" + nhanVien + ", tenKH=" + tenKH + ", sdt="
				+ sdt + ", tenSP=" + tenSP + ", ngayGiao=" + ngayGiao + ", diaChiGiao=" + diaChiGiao + "]";
	}
	public HoaDon(int mahoadon, Khachhang khachHang, NhanVien nhanVien, String tenKH, String sdt, String tenSP,
			Date ngayGiao, String diaChiGiao) {
		super();
		this.mahoadon = mahoadon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.tenSP = tenSP;
		this.ngayGiao = ngayGiao;
		this.diaChiGiao = diaChiGiao;
	}
	
	 
}
