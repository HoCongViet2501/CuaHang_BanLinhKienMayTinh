package entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String diachi;
	private String sdt;
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public NhaCungCap(String maNCC, String tenNCC, String diachi, String sdt) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diachi=" + diachi + ", sdt=" + sdt + "]";
	}
	
}
