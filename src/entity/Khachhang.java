package entity;

public class Khachhang {
	private int maKH;
	private String tenKH;
	private String sodienthoai;
	private String diachi;
	private String email;
	public Khachhang() {
		// TODO Auto-generated constructor stub
	}
	public Khachhang(int maKH, String tenKH, String sodienthoai, String diachi, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.email = email;
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Khachhang [maKH=" + maKH + ", tenKH=" + tenKH + ", sodienthoai=" + sodienthoai + ", diachi=" + diachi
				+ ", email=" + email + "]";
	}
	
}
