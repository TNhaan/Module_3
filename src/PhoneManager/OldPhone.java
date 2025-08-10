package PhoneManager;

import java.util.Scanner;

public class OldPhone extends Phone implements Promotion {
    private int batteryPercentage;

    public OldPhone(String id, String name, double price, int warrantyMonths, String OS, String brand, int batteryPercentage) {
        super(id, name, price, warrantyMonths, OS, brand);
        this.batteryPercentage = batteryPercentage;
    }

    public OldPhone() {
    }

    public void input(Scanner scanner) {
        super.input(scanner);
        while (true) {
            System.out.println("Nhập phần trăm pin: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Không hợp lệ!");
                continue;
            } else {
                batteryPercentage = scanner.nextInt();
                scanner.nextLine();
            }
            break;
        }
    }

    public void promote(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Phần trăm giảm giá không hợp lệ.");
            return;
        }

        Double discount = getPrice() * (percent / 100);
        setPrice(getPrice() - discount);
    }

    @Override
    public double calculateTotalPrice() {
        return batteryPercentage * price;
    }

    @Override
    public void output() {

        System.out.printf("ID: %-5s |Tên sản phẩm: %-20s |Giá: %-10.0f |Phần trăm pin: %-5d |Bảo hành: %-2d tháng |OS: %-10s |Thương hiệu: %-10s\n\n", id, name, price, batteryPercentage, warrantyMonths, OS, brand);
    }

}
