public class Menu {
    public static void main(String[] args) {
        QuanLiBenhAn quanLiBenhAn = new QuanLiBenhAn();
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÍ BỆNH ÁN");
            System.out.println("Chọn chức năng theo số ( để tiếp tục )");
            System.out.println("1 Thêm mới");
            System.out.println("2 Xoá");
            System.out.println("3 Xem danh sách bệnh án");
            System.out.println("4 Thoát");
            ;
            System.out.println("Chọn chức năng:");
            int choice = Input.getInt();
            switch (choice) {
                case 1:
                    quanLiBenhAn.themBenhAn();
                    break;
                case 2:
                    quanLiBenhAn.xoaBenhAn();
                    break;
                case 3:
                    quanLiBenhAn.hienThiDS();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(9);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
