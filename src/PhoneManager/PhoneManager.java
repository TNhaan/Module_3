package PhoneManager;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManager {
    static ArrayList<Phone> phoneList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n===== MENU CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI =====");
            System.out.println("1. Xem danh sách điện thoại");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp theo giá");
            System.out.println("6. Tìm kiếm");
            System.out.println("7. Tính tổng tiền");
            System.out.println("8. Giảm giá cho điện thoại cũ");
            System.out.println("9. Thoát chương trình");
            System.out.print("==> Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> displayPhone();
                case 2 -> menuAddNew();
                case 3 -> updatePhoneById();
                case 4 -> deletePhoneById();
                case 5 -> sortByPrice();
                case 6 -> searchPhone();
                case 7 -> System.out.println("Em chưa hiểu bài toán này");
                case 8 -> discountOldPhones();
                case 9 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }


    private static void displayPhone() {
        int choose;
        while (true) {
            do {
                System.out.println("\n===== Màn Hình 1 =====\nDANH SÁCH ĐIỆN THOẠI");
                System.out.println("1. Điện thoại cũ");
                System.out.println("2. Điện thoại mới");
                System.out.println("3. Tất cả điện thoại");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        int count = 1;
                        for (Phone phone : phoneList) {
                            if (phone instanceof OldPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        count = 1;
                        for (Phone phone : phoneList) {
                            if (phone instanceof NewPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < phoneList.size(); i++) {
                            System.out.println("Thông tin nhân viên thứ " + (i + 1));
                            phoneList.get(i).output();
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuAddNew() {
        int choose;
        while (true) {
            do {
                System.out.println("\n===== Màn Hình 2 =====\nTHÊM MỚI ĐIỆN THOẠI");
                System.out.println("1. Điện thoại cũ");
                System.out.println("2. Điện thoại mới");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1 -> {
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input(scanner);
                        oldPhone.setId(getIdOldPhone());
                        phoneList.add(oldPhone);
                        System.out.println("Thêm điện thoại cũ thành công");
                    }

                    case 2 -> {
                        NewPhone newPhone = new NewPhone();
                        newPhone.input(scanner);
                        newPhone.setId(getIdNewPhone());
                        phoneList.add(newPhone);
                        System.out.println("Thêm điện thoại mới thành công");
                    }

                    case 3 -> {
                        return;
                    }

                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    public void updatePhoneById() {
        System.out.print("Nhập ID điện thoại cần cập nhật (VD: DTC001, DTM002): ");
        String idKey = scanner.nextLine().trim().toUpperCase();


        if (!idKey.matches("^DT[MC]\\d{3}$")) {
            System.out.println("ID không đúng định dạng (phải là DTCxxx hoặc DTMxxx).");
            return;
        }

        boolean found = false;

        for (Phone phone : phoneList) {
            if (phone.getId().equalsIgnoreCase(idKey)) {
                System.out.println("Tìm thấy điện thoại cần cập nhật:");
                phone.output();

                System.out.println("Nhập thông tin mới:");
                phone.input(scanner);

                System.out.println("Cập nhật thành công.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại có ID: " + idKey);
        }
    }

    public void deletePhoneById() {
        System.out.print("Nhập ID điện thoại cần xóa (VD: DTC001, DTM002): ");
        String idKey = scanner.nextLine().trim().toUpperCase();


        if (!idKey.matches("^DT[MC]\\d{3}$")) {
            System.out.println("ID không đúng định dạng (phải là DTCxxx hoặc DTMxxx).");
            return;
        }

        Phone foundPhone = null;

        for (Phone phone : phoneList) {
            if (phone.getId().equalsIgnoreCase(idKey)) {
                foundPhone = phone;
                break;
            }
        }

        if (foundPhone == null) {
            System.out.println("Không tìm thấy điện thoại có ID: " + idKey);
            return;
        }

        System.out.println("Tìm thấy điện thoại:");
        foundPhone.output();

        System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("Y")) {
            phoneList.remove(foundPhone);
            System.out.println("Xóa thành công điện thoại có ID: " + idKey);
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }

    private static void sortByPrice() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 5 =====\nSẮP XẾP THEO GIÁ");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1 -> {
                        phoneList.sort((phone1, phone2) -> phone1.getPrice().compareTo(phone2.getPrice()));

                        for (Phone phone : phoneList) {
                            System.out.printf("ID: %-5s |Tên sản phẩm: %-20s |Giá: %-10.3f \n|Bảo hành: %-2d tháng |OS: %-10s |Thương hiệu: %-10s", phone.id, phone.name, phone.price, phone.warrantyMonths, phone.OS, phone.brand);
                        }
                    }
                    case 2 -> {
                        phoneList.sort((phone1, phone2) -> phone2.getPrice().compareTo(phone1.getPrice()));
                        for (Phone phone : phoneList) {
                            System.out.printf("ID: %-5s |Tên sản phẩm: %-20s |Giá: %-10.3f \n|Bảo hành: %-2d tháng |OS: %-10s |Thương hiệu: %-10s", phone.id, phone.name, phone.price, phone.warrantyMonths, phone.OS, phone.brand);
                        }
                    }
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    public static void searchPhone() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 6 =====\nTÌM KIẾM ĐIỆN THOẠI");
                System.out.println("1. Điện thoại cũ");
                System.out.println("2. Điện thoại mới");
                System.out.println("3. Tất cả điện thoại");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1 -> searchOldPhone();

                    case 2 -> searchNewPhone();

                    case 3 -> searchAllPhone();
                    case 4 -> {
                        return;
                    }

                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void searchAllPhone() {
        while (true) {
            System.out.println("==> Tìm trong tất cả:");
            System.out.println("1. Theo khoảng giá");
            System.out.println("2. Theo tên");
            System.out.println("3. Theo hãng");
            System.out.println("4. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> searchByPrice(null);
                case 2 -> searchByName(null);
                case 3 -> searchByBrand(null);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void searchOldPhone() {
        while (true) {
            System.out.println("==> Tìm trong điện thoại cũ:");
            System.out.println("1. Theo khoảng giá");
            System.out.println("2. Theo tên");
            System.out.println("3. Theo hãng");
            System.out.println("4. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> searchByPrice("old");
                case 2 -> searchByName("old");
                case 3 -> searchByBrand("old");
                case 4 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void searchNewPhone() {
        while (true) {
            System.out.println("==> Tìm trong điện thoại mới:");
            System.out.println("1. Theo khoảng giá");
            System.out.println("2. Theo tên");
            System.out.println("3. Theo hãng");
            System.out.println("4. Quay lại");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> searchByPrice("new");
                case 2 -> searchByName("new");
                case 3 -> searchByBrand("new");
                case 4 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void discountOldPhones() {
        System.out.print("Nhập phần trăm giảm giá cho điện thoại cũ (%): ");
        double percent = Double.parseDouble(scanner.nextLine());

        boolean found = false;
        for (Phone phone : phoneList) {
            if (phone instanceof OldPhone) {
                Promotion promotion = (Promotion) phone;
                promotion.promote(percent);
                found = true;
            }
        }

        if (found) {
            System.out.println("Đã giảm giá " + percent + "% cho tất cả điện thoại cũ.");
        } else {
            System.out.println("Không có điện thoại cũ nào trong danh sách.");
        }
    }


    private static void searchByPrice(String type) {
        System.out.print("Nhập giá MIN: ");
        double min = scanner.nextDouble();

        System.out.print("Nhập giá MAX: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        boolean found = false;

        for (Phone phone : phoneList) {
            if (type == null) {
                if (phone.getPrice().compareTo(min) >= 0 && phone.getPrice().compareTo(max) <= 0) {
                    phone.output();
                    found = true;
                }
            } else if (type.equals("old") && phone instanceof OldPhone) {
                if (phone.getPrice().compareTo(min) >= 0 && phone.getPrice().compareTo(max) <= 0) {
                    phone.output();
                    found = true;
                }
            } else if (type.equals("new") && phone instanceof NewPhone) {
                if (phone.getPrice().compareTo(min) >= 0 && phone.getPrice().compareTo(max) <= 0) {
                    phone.output();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại trong khoảng giá.");
        }
    }


    private static void searchByName(String type) {
        System.out.print("Nhập từ khóa tên: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Phone phone : phoneList) {
            if (type == null) {
                if (phone.getName().toLowerCase().contains(keyword)) {
                    phone.output();
                    found = true;
                }
            } else if (type.equals("old") && phone instanceof OldPhone) {
                if (phone.getName().toLowerCase().contains(keyword)) {
                    phone.output();
                    found = true;
                }
            } else if (type.equals("new") && phone instanceof NewPhone) {
                if (phone.getName().toLowerCase().contains(keyword)) {
                    phone.output();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại phù hợp theo tên.");
        }
    }


    private static void searchByBrand(String type) {
        System.out.print("Nhập tên hãng: ");
        String brand = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Phone phone : phoneList) {
            if (type == null) {
                if (phone.getBrand().toLowerCase().contains(brand)) {
                    phone.output();
                    found = true;
                }
            } else if (type.equals("old") && phone instanceof OldPhone) {
                if (phone.getBrand().toLowerCase().contains(brand)) {
                    phone.output();
                    found = true;
                }
            } else if (type.equals("new") && phone instanceof NewPhone) {
                if (phone.getBrand().toLowerCase().contains(brand)) {
                    phone.output();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại phù hợp theo hãng.");
        }
    }


    private static ArrayList<OldPhone> getOldPhone() {
        ArrayList<OldPhone> oldPhoneList = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone instanceof OldPhone) {
                oldPhoneList.add((OldPhone) phone);
            }
        }
        return oldPhoneList;
    }

    private static ArrayList<NewPhone> getNewPhone() {
        ArrayList<NewPhone> newPhoneList = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone instanceof NewPhone) {
                newPhoneList.add((NewPhone) phone);
            }
        }
        return newPhoneList;
    }

    private static String getIdOldPhone() {
        ArrayList<OldPhone> oldPhoneList = getOldPhone();

        if (oldPhoneList.isEmpty()) return "DTC001";

        int max = Integer.parseInt(oldPhoneList.get(0).getId().substring(3));

        for (OldPhone oldPhone : oldPhoneList) {
            int id = Integer.parseInt(oldPhone.getId().substring(3));
            if (max < id) {
                max = id;
            }
        }

        return String.format("DTC%3d", max + 1).replace(" ", "0");
    }

    private static String getIdNewPhone() {
        ArrayList<NewPhone> newPhoneList = getNewPhone();

        if (newPhoneList.isEmpty()) return "DTM001";

        int max = Integer.parseInt(newPhoneList.get(0).getId().substring(3));

        for (NewPhone newPhone : newPhoneList) {
            int id = Integer.parseInt(newPhone.getId().substring(3));
            if (max < id) {
                max = id;
            }
        }

        return String.format("DTM%3d", max + 1).replace(" ", "0");
    }
}
