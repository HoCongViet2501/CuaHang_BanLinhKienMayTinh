package entity;

public class LoaiSanPham {
    private String maLoaiSP;
    private String tenLoaiSP;
	public String getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public String getTenLoaiSP() {
		return tenLoaiSP;
	}
	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}
	public LoaiSanPham(String maLoaiSP, String tenLoaiSP) {
		super();
		this.maLoaiSP = maLoaiSP;
		this.tenLoaiSP = tenLoaiSP;
	}
	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSP=" + maLoaiSP + ", tenLoaiSP=" + tenLoaiSP + "]";
	}
	public LoaiSanPham(String maLoaiSP) {
		super();
		this.maLoaiSP = maLoaiSP;
	}
	public LoaiSanPham() {
		// TODO Auto-generated constructor stub
		super();
		this.maLoaiSP=maLoaiSP;
	}
    
}
