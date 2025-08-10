package PhoneManager;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone(String id, String name, double price, int warrantyMonths, String OS, String brand, int quantity) {
        super(id, name, price, warrantyMonths, OS, brand);
        this.quantity = quantity;
    }

    public NewPhone() {
    }

    @Override
    public void input(Scanner scanner) {
        super.input(scanner);
        while (true) {
            System.out.println("Số lượng sản phẩm trong kho: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Không hợp lệ!");
                continue;
            } else {
                quantity = scanner.nextInt();
                scanner.nextLine();
            }
            break;
        }
    }

    @Override
    public void output() {
        System.out.printf("ID: %-5s |Tên sản phẩm: %-20s |Giá: %-10.0f |Số lượng: %-5d |Bảo hành: %-2d tháng |OS: %-10s |Thương hiệu: %-10s\n\n", id, name, price, quantity, warrantyMonths, OS, brand);
    }

    @Override
    public double calculateTotalPrice() {
        return (quantity) * price;
    }

}
