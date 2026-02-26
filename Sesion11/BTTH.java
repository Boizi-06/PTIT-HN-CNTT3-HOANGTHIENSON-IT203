package Sesion11;

// Interface IMixable
interface IMixable {
    void mix();
}

// Abstract class Drink
abstract class Drink {
    protected String id;
    protected String name;
    protected double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.println("Ma: " + id);
        System.out.println("Ten: " + name);
        System.out.println("Gia goc: " + price);
    }
}

// Class Coffee
class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    public double calculatePrice() {
        if (hasMilk) {
            return price + 5000;
        }
        return price;
    }

    public void displayInfo() {
        super.displayInfo();
        if (hasMilk) {
            System.out.println("Loai: Co sua");
        } else {
            System.out.println("Loai: Den da");
        }
    }
}

// Class FruitJuice
class FruitJuice extends Drink implements IMixable {
    private int discountPercent;

    public FruitJuice(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    public double calculatePrice() {
        return price - (price * discountPercent / 100.0);
    }

    public void mix() {
        System.out.println("Dang ep trai cay tuoi...");
    }
}

public class BTTH {
    public static void main(String[] args) {

        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("CF01", "Bac siu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nuoc cam", 40000, 10);
        drinks[2] = null;

        for (int i = 0; i < drinks.length; i++) {

            if (drinks[i] != null) {

                drinks[i].displayInfo();
                System.out.println("Thanh tien: " + drinks[i].calculatePrice());

                if (drinks[i] instanceof IMixable) {
                    ((IMixable) drinks[i]).mix();
                }

                System.out.println("--------------------");
            }
        }
    }
}