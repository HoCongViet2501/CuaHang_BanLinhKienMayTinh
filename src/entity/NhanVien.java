package entity;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private boolean gioiTinh;
	private String sodienthoai;
	private String chucvu;
	private double luongcoban;
	private String diachi;
	private String matkhau;
	private String email;
	
	public NhanVien() {
		super();
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public double getLuongcoban() {
		return luongcoban;
	}
	public void setLuongcoban(double luongcoban) {
		this.luongcoban = luongcoban;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhanVien(String maNV, String tenNV, boolean gioiTinh, String sodienthoai, String chucvu, double luongcoban,
			String diachi, String matkhau, String email) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.sodienthoai = sodienthoai;
		this.chucvu = chucvu;
		this.luongcoban = luongcoban;
		this.diachi = diachi;
		this.matkhau = matkhau;
		this.email = email;
	}
	public NhanVien(String manv) {
		// TODO Auto-generated constructor stub
		super();
		this.maNV=manv;
	}
	
	public NhanVien(String maNV, String matkhau) {
		super();
		this.maNV = maNV;
		this.matkhau = matkhau;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", sodienthoai=" + sodienthoai
				+ ", chucvu=" + chucvu + ", luongcoban=" + luongcoban + ", diachi=" + diachi + ", matkhau=" + matkhau
				+ ", email=" + email + "]";
	}
	
}
