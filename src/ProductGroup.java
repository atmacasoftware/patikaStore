import java.util.Scanner;

public abstract class ProductGroup {
    private int id;
    private double unitPrice;
    private int discountRate;
    private int stok;
    private String name;
    private Brand brand;
    private int ram;
    private double screenSize;
    public Scanner input = new Scanner(System.in);

    public ProductGroup(int id, double unitPrice, int discountRate, int stok, String name, Brand brand, int ram, double screenSize) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stok = stok;
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public ProductGroup(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
