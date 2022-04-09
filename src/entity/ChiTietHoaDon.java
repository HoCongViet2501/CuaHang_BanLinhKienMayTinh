package entity;

public class ChiTietHoaDon {
	private HoaDon hoadon;
	private SanPham sanpham;
	private int soluong;
	private double dongia;
	private double tongTien;
	public HoaDon getHoadon() {
		return hoadon;
	}
	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public ChiTietHoaDon(HoaDon hoadon, SanPham sanpham, int soluong, double dongia, double tongTien) {
		super();
		this.hoadon = hoadon;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoadon=" + hoadon + ", sanpham=" + sanpham + ", soluong=" + soluong + ", dongia="
				+ dongia + ", tongTien=" + tongTien + "]";
	}
	
}
