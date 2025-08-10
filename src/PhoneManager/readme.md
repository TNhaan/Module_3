# Phân tích cấu trúc

## Abstract class Phone()

### x Fields

``` 
protected String id
protected String name
protected BigDecimal price
protected int warrantyMonths
protected String OS
protected String brand
```

### x Method

``` 
public abstract BigDecimal calculateTotalPrice()
public abstract void input (Scanner scanner)
public abstract void output()
```

## class NewPhone extends Phone

### x Fields

``` 
private int quantity;
```

### x Method

``` 
public void input(Scanner scanner);
public void output();
public BigDecimal calculateTotalPrice();
```

## Class OldPhone extends Phone implements Promotion

## x Fields

``` 
private int batteryPercentage
```

## x Method

``` 
public void input(Scanner scanner);
public BigDecimal calculateTotalPrice();
public void output();
public void promote(double percent);
```

## Interface Promotion

``` 
public interface Promotion {
    void promote(double percent);  // giảm giá theo %
}

```

## Class PhoneManager

### x Fields

``` 
static List<Phone> phoneList = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

```

### x Method

1. void menu()
2. void viewPhones()
3. void addPhone()
4. void updatePhone()
5. void deletePhone()
6. sortByPrice()
7. void calculateTotalPrice()
8. void applyPromotionForOldPhone(double percent)

## Class Main()

```
public class Main {
    public static void main(String[] args) {
        PhoneManager manager = new PhoneManager();
        manager.menu();
    }
}
 
```