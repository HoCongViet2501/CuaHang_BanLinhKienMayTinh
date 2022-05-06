package entity;

import java.util.Arrays;

public class SanPham {
    
	private String maSP;
     private String tenSP;
     private int slton;
     private double donGia;
     private byte[] hinhAnh;
     private NhaCungCap nhaCungCap;
     private LoaiSanPham loaiSanPham;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSlton() {
		return slton;
	}
	public void setSlton(int slton) {
		this.slton = slton;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public byte[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public NhaCungCap getMaNCC() {
		return nhaCungCap;
	}
	public void setMaNCC(NhaCungCap maNCC) {
		this.nhaCungCap = maNCC;
	}
	public LoaiSanPham getMaLoaiSP() {
		return loaiSanPham;
	}
	public void setMaLoaiSP(LoaiSanPham maLoaiSP) {
		this.loaiSanPham = maLoaiSP;
	}
	 public SanPham(String maSP, String tenSP, int slton, double donGia, NhaCungCap nhaCungCap,
			LoaiSanPham loaiSanPham) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.slton = slton;
		this.donGia = donGia;
		this.nhaCungCap = nhaCungCap;
		this.loaiSanPham = loaiSanPham;
	}
	public SanPham(String maSP, String tenSP, int slton, double donGia, byte[] hinhAnh, NhaCungCap nhaCungCap,
			LoaiSanPham loaiSanPham) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.slton = slton;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
		this.loaiSanPham = loaiSanPham;
	}
	public SanPham(String maSP, String tenSP, int slton, double donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.slton = slton;
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", slton=" + slton + ", donGia=" + donGia + ", hinhAnh="
				+ Arrays.toString(hinhAnh) + ", maNCC=" + nhaCungCap + ", maLoaiSP=" + loaiSanPham + "]";
	}
	public SanPham() {
	}
	
     
}
