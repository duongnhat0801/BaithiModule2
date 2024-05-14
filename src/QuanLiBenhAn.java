import java.io.*;
import java.util.ArrayList;

public class QuanLiBenhAn extends BenhAn {
    private final ArrayList<QuanLiBenhAn> quanLiBenhAns = new ArrayList<>();
    private static QuanLiBenhAn instance = null;

    QuanLiBenhAn(
    ) {
        super();
    }

    public static QuanLiBenhAn getInstance() {
        if (instance == null) {
            instance = new QuanLiBenhAn();
        }
        return instance;
    }

    public void themBenhAn() {
        System.out.println("Vui lòng nhập bệnh án mới");
        String maba = Input.getString();
        while (!validateMaBA(maba)) {
            maba = Input.getString();
        }
        System.out.println("Vui lòng nhập mã bệnh nhân");
        String mabn = Input.getString();
        while (!validateMaBN(mabn)) {
            mabn = Input.getString();
        }
        System.out.println("Vui lòng nhập tên: ");
        String ten = Input.getString();
        while (!validatenName(ten)) {
            ten = Input.getString();
        }
        System.out.println("Vui lòng nhập ngày nhập viện:");
        String ngaynhapvien = Input.getString();
        while (!validatenNgayNhapVien(ngaynhapvien)) {
            ngaynhapvien = Input.getString();
        }
        System.out.println("Vui lòng nhập ngày ra viện");
        String ngayravien = Input.getString();
        while (!validateNgayRaVien(ngayravien)) {
            ngayravien = Input.getString();
        }
        System.out.println("Vui lòng nhập lí do vào viện: ");
        String lidovaovien =Input.getString();

        quanLiBenhAns.add(new QuanLiBenhAn());
    }

    private boolean validateNgayRaVien(String ngayravien) {
        String str = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";
        return ngayravien.matches(str);
    }

    private boolean validatenNgayNhapVien(String ngaynhapvien) {
        String str = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";
        return ngaynhapvien.matches(str);
    }

    private boolean validatenName(String ten) {
        if (ten.isEmpty()) {
            System.out.println("Tên không được để trống");
            return false;
        }
        return true;
    }

    private boolean validateMaBN(String mabn) {
        if (mabn.isEmpty()) {
            System.out.println("Mã bênh nhân không được để trống");
            System.out.println("VD: BN-XXX");
            return false;
        }
        return true;
    }


    private boolean validateMaBA(String maba) {
        if (maba.isEmpty()) {
            System.out.println("Mã bênh án không được để trống");
            System.out.println("VD: BA-XXX");
            return false;
        }
        if (findIndexByMaBA(maba) != -1) {
            System.out.println("Mã bệnh án đã tồn tại");
            return false;
        }
        return true;
    }

    private int findIndexByMaBA(String maba) {
        for (int i = 0; i < quanLiBenhAns.size(); i++) {
            if (quanLiBenhAns.get(i).getMaba().equals(maba)) {
                return i;
            }
        }
        return -1;
    }


    public void xoaBenhAn() {
        System.out.println("Vui lòng nhập mã bệnh án muốn xoá");
        String maba = Input.getString();
        if (maba.isEmpty()) {
            return;
        }
        int index = findIndexByMaBA(maba);
        if (index == -1) {
            System.out.println("Không tìm thấy bệnh án với mã tương ứng");
            xoaBenhAn();
            return;
        }
        System.out.println(quanLiBenhAns.get(index));
        System.out.println("Bạn có chắc muốn xoá . Nhấn Y để xoá");
        String Y = Input.getString();
        if (Y.equals("Y")) {
            quanLiBenhAns.remove(index);
        }
    }

    public void hienThiDS() {
        if (quanLiBenhAns.isEmpty()) {
            System.out.println("Danh sách trống , vui lòng nhập vào ");
            return;
        }
        int pageSize = 5;
        int current = 0;
        while (true) {
            for (int i = current; i < (current + pageSize); i++) {
                if (i >= quanLiBenhAns.size()) {
                    return;
                }
                System.out.println(quanLiBenhAns.get(i));
            }
            current += pageSize;
            System.out.println("Enter để sang trang mới");
            Input.getString();
        }
    }

    public void docDanhSachTuFile() throws IOException {
        File file = new File("data/medical_records.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        quanLiBenhAns.clear();
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            QuanLiBenhAn quanLiBenhAn = new QuanLiBenhAn();
            quanLiBenhAn.setMaba(data[0]);
            quanLiBenhAn.setMabn(data[1]);
            quanLiBenhAn.setTen(data[2]);
            quanLiBenhAn.setNgaynhapvien(data[3]);
            quanLiBenhAn.setNgayxuatvien(data[4]);
            quanLiBenhAn.setLidonhapvien(data[5]);
            quanLiBenhAns.add(quanLiBenhAn);
        }
    }

    public void vietDanhSachTuFile() throws IOException {
        File file = new File("data/medical_records.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        if (quanLiBenhAns.isEmpty()) {
            System.out.println("Chưa có bệnh án nào");
            return;
        }
        for (QuanLiBenhAn quanLiBenhAn : quanLiBenhAns) {
            String line = quanLiBenhAn.getStt() + "," + quanLiBenhAn.getMaba() + "," + quanLiBenhAn.getMabn() + "," + quanLiBenhAn.getTen() + "," + quanLiBenhAn.getNgaynhapvien() + "," + quanLiBenhAn.getNgayxuatvien() + "," + quanLiBenhAn.getLidonhapvien();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}

