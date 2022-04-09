package entity;

public class ChiTietDonDatHang {
	private DonDatHang dondathang;
	private SanPham sanpham;
	private int soluong;
	private double dongia;
	private double mucGiamGia;
	public ChiTietDonDatHang(DonDatHang dondathang, SanPham sanpham, int soluong, double dongia, double mucGiamGia) {
		super();
		this.dondathang = dondathang;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.mucGiamGia = mucGiamGia;
	}
	public DonDatHang getDondathang() {
		return dondathang;
	}
	public void setDondathang(DonDatHang dondathang) {
		this.dondathang = dondathang;
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
	public double getMucGiamGia() {
		return mucGiamGia;
	}
	public void setMucGiamGia(double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}
	@Override
	public String toString() {
		return "ChiTietDonDatHang [dondathang=" + dondathang + ", sanpham=" + sanpham + ", soluong=" + soluong
				+ ", dongia=" + dongia + ", mucGiamGia=" + mucGiamGia + "]";
	}
	
}
