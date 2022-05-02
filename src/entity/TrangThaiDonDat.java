package entity;

public class TrangThaiDonDat {
	private String maTrangThai;
	private String tenTrangThai;
	public String getMaTrangThai() {
		return maTrangThai;
	}
	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public TrangThaiDonDat(String maTrangThai, String tenTrangThai) {
		super();
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
	}
	public TrangThaiDonDat() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	public String toString() {
		return "TrangThaiDonDat [maTrangThai=" + maTrangThai + ", tenTrangThai=" + tenTrangThai + "]";
	}
	

}
