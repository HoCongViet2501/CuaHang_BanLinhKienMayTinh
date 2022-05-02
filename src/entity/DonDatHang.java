package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DonDatHang {
	private int maDonDat;
	private Khachhang khachHang;
	private NhanVien nhanvien;
	private Date ngaydat;
	private Date ngaygiao;
	private String noiNhan;
	private double tongTien;
	private TrangThaiDonDat trangThaiDonDat;
	private List<ChiTietDonDatHang> listChiTietDonDatHang;
	public DonDatHang() {
		this.listChiTietDonDatHang=new ArrayList<ChiTietDonDatHang>();
		this.tongTien=0;
	}
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
	public Date getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}
	public Date getNgaygiao() {
		return ngaygiao;
	}
	public void setNgaygiao(Date ngaygiao) {
		this.ngaygiao = ngaygiao;
	}
	public String getNoiNhan() {
		return noiNhan;
	}
	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}

	public TrangThaiDonDat getTrangThaiDonDat() {
		return trangThaiDonDat;
	}
	public void setTrangThaiDonDat(TrangThaiDonDat trangThaiDonDat) {
		this.trangThaiDonDat = trangThaiDonDat;
	}
	
	public DonDatHang(int maDonDat, Khachhang khachHang, NhanVien nhanvien, Date ngaydat, Date ngaygiao, String noiNhan,
			TrangThaiDonDat trangThaiDonDat) {
		super();
		this.maDonDat = maDonDat;
		this.khachHang = khachHang;
		this.nhanvien = nhanvien;
		this.ngaydat = ngaydat;
		this.ngaygiao = ngaygiao;
		this.noiNhan = noiNhan;
		this.trangThaiDonDat = trangThaiDonDat;
		this.listChiTietDonDatHang=new ArrayList<ChiTietDonDatHang>();
		this.tongTien=0;
	}
	public void addChitietdonhang(DonDatHang donhang, SanPham sanpham, int soluong,double donGia, double mucGiamGia) {
		ChiTietDonDatHang ctdh = new ChiTietDonDatHang(donhang, sanpham, soluong,donGia, mucGiamGia);
		this.listChiTietDonDatHang.add(ctdh);
		this.tongTien +=(( ctdh.getSoluong() * ctdh.getDongia())-ctdh.getMucGiamGia());
	}
	public void removeChitietdonhang(int i) {
		double tientru = (listChiTietDonDatHang.get(i).getDongia() * listChiTietDonDatHang.get(i).getSoluong())-listChiTietDonDatHang.get(i).getMucGiamGia();
		listChiTietDonDatHang.remove(i);
		this.tongTien = this.tongTien-tientru;
	}
	
	public void updateChitietdonhang(int i, int soluong,double mucgiam) {
		double tientru =(listChiTietDonDatHang.get(i).getDongia() * listChiTietDonDatHang.get(i).getSoluong())-listChiTietDonDatHang.get(i).getMucGiamGia();
		this.tongTien -= tientru;
		listChiTietDonDatHang.get(i).setSoluong(soluong);
		listChiTietDonDatHang.get(i).setMucGiamGia(mucgiam);
		this.tongTien += (listChiTietDonDatHang.get(i).getDongia() * listChiTietDonDatHang.get(i).getSoluong()-listChiTietDonDatHang.get(i).getMucGiamGia()) ;
	}
	public double getTongTien() {
		return tongTien;
	}

}
