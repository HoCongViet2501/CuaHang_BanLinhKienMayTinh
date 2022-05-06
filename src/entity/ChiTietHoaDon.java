package entity;

public class ChiTietHoaDon {
	private HoaDon hoadon;
	private SanPham sanpham;
	private int soluong;
	private double dongia;
	private double thanhTien;
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
		return thanhTien;
	}
	public void setTongTien(double tongTien) {
		this.thanhTien = tongTien;
	}
	public ChiTietHoaDon(HoaDon hoadon, SanPham sanpham, int soluong, double dongia) {
		super();
		this.hoadon = hoadon;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhTien = this.dongia*this.soluong;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoadon=" + hoadon + ", sanpham=" + sanpham + ", soluong=" + soluong + ", dongia="
				+ dongia + ", tongTien=" + thanhTien + "]";
	}
	
}
