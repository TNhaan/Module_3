package PhoneManager;

import java.util.Scanner;

public abstract class Phone {
    protected String id;
    protected String name;
    protected Double price;
    protected int warrantyMonths;
    protected String OS;
    protected String brand;

    public Phone(String id, String name, double price, int warrantyMonths, String OS, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
        this.OS = OS;
        this.brand = brand;
    }

    public Phone() {
    }

    public abstract double calculateTotalPrice();

    public void input(Scanner scanner) {
        while (true) {
            System.out.println("Nhập tên sản phẩm: ");
            name = scanner.nextLine();
            if (!checkInput(this.name)) {
                System.out.println("Tên không hợp lệ!");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Nhập giá sản phẩm: ");
            if (!scanner.hasNextBigDecimal()) {
                System.out.println("Không hợp lệ!");
                continue;
            } else {
                price = scanner.nextDouble();
            }
            break;
        }

        while (true) {
            System.out.println("Nhập thời gian bảo hành: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Không hợp lệ!");
                continue;
            } else {
                warrantyMonths = scanner.nextInt();
                scanner.nextLine();
            }
            break;
        }

        while (true) {
            System.out.println("Nhập hệ điều hành: ");
            OS = scanner.nextLine().toUpperCase();
            if (!OS.equals("IOS") & !OS.equals("ANDROID")) {
                System.out.println("Hệ điều hành không hợp lệ (IOS/ANDROID)!");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Nhập thương hiệu sản phẩm: ");
            brand = scanner.nextLine();
            if (!checkInput(this.brand)) {
                System.out.println("Tên thương hiệu không hợp lệ!");
                continue;
            }
            break;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public abstract void output();

    public boolean checkInput(String input) {
        return input.matches("^[\\p{L}\\s0-9]+$");
    }
}
