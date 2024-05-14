public class BenhAn {
    private static int stt = 1;
    private String maba;
    private String mabn;
    private String ten;
    private String ngaynhapvien;
    private String ngayxuatvien;
    private String lidonhapvien;

    public BenhAn(int stt, String maba, String mabn, String ten, String ngaynhapvien, String ngayxuatvien, String lidonhapvien) {
        this.stt = stt;
        this.maba = maba;
        this.mabn = mabn;
        this.ten = ten;
        this.ngaynhapvien = ngaynhapvien;
        this.ngayxuatvien = ngayxuatvien;
        this.lidonhapvien = lidonhapvien;
    }

    public BenhAn() {

    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaba() {
        return maba;
    }

    public void setMaba(String maba) {
        this.maba = maba;
    }

    public String getMabn() {
        return mabn;
    }

    public void setMabn(String mabn) {
        this.mabn = mabn;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaynhapvien() {
        return ngaynhapvien;
    }

    public void setNgaynhapvien(String ngaynhapvien) {
        this.ngaynhapvien = ngaynhapvien;
    }

    public String getNgayxuatvien() {
        return ngayxuatvien;
    }

    public void setNgayxuatvien(String ngayxuatvien) {
        this.ngayxuatvien = ngayxuatvien;
    }

    public String getLidonhapvien() {
        return lidonhapvien;
    }

    public void setLidonhapvien(String lidonhapvien) {
        this.lidonhapvien = lidonhapvien;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "maba='" + maba + '\'' +
                ", mabn='" + mabn + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaynhapvien='" + ngaynhapvien + '\'' +
                ", ngayxuatvien='" + ngayxuatvien + '\'' +
                ", lidonhapvien='" + lidonhapvien + '\'' +
                '}';
    }
}
