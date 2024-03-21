import java.util.LinkedList;
import java.util.Optional;

public class MobilePhone extends ProductGroup implements ProductInterface{

    private int memory;
    private double batteryPower;
    private int camera;
    private String color;

    private static LinkedList<MobilePhone> mobilePhone=new LinkedList<>();

    public MobilePhone(int id, double unitPrice, int discountRate, int stok, String name, Brand brand, int ram, double screenSize, int memory, double batteryPower, String  color, int camera) {
        super(id, unitPrice, discountRate, stok, name, brand, ram, screenSize);
        this.memory = memory;
        this.batteryPower = batteryPower;
        this.color = color;
        this.camera = camera;
    }

    public MobilePhone(){

    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(double batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public void menu() {
        System.out.println("1- Ürün Ekle\n" +
                "2- Ürün Listele\n" +
                "3- Ürün Sil\n" +
                "4- Ürün Filtrele");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value=input.nextInt();
        if(value==1) addProduct();
        if(value==2) getProducts();
        if(value==3) deleteProduct();
        if(value==4) brandFilter();
    }

    @Override
    public void addProduct() {
        System.out.print("Ürün Kodu : ");
        int productCode = input.nextInt();
        input.nextLine();
        System.out.print("Ürün Adı : ");
        String productName = input.nextLine();
        System.out.print("Ürün Birim Fiyat : ");
        double productPrice = input.nextDouble();
        System.out.print("Ürün İndirim Oranı : ");
        int discountRate = input.nextInt();
        System.out.print("Ürün Stok Miktarı : ");
        int productStok = input.nextInt();
        System.out.print("Ürün Ram Belleği : ");
        int productRam = input.nextInt();
        System.out.print("Ürün Ekran Boyutu : ");
        double productScreenSize = input.nextDouble();
        System.out.print("Ürün Hafızası : ");
        int productMemory = input.nextInt();
        System.out.print("Ürün Pil Gücü : ");
        double productBatteryPower = input.nextDouble();
        input.nextLine();
        System.out.print("Ürün Rengi : ");
        String productColor = input.nextLine();
        System.out.print("Ürün Kamerası : ");
        int productCamera = input.nextInt();
        System.out.println("Ürün Markası");
        Brand.getBrand();
        System.out.println("Marka Seçiniz : ");
        Brand brand = Brand.getBrand(input.nextInt());
        if(!checkID(productCode)){
            MobilePhone mobilePhone = new MobilePhone(productCode, productPrice, discountRate, productStok, productName, brand, productRam, productScreenSize, productMemory, productBatteryPower, productColor, productCamera);
            System.out.println("Cep telefonu başarıyla eklendi.");
            MobilePhone.mobilePhone.add(mobilePhone);
        }else{
            System.out.println("Girdiğiniz ürün kodunda ürün bulunmaktadır. Lütfen farklı bir ürün kodu giriniz.");
        }
    }

    @Override
    public void getProducts() {
        listProduct(null);
    }

    public void listProduct(LinkedList<MobilePhone> mobilePhoneList){
        if(mobilePhoneList==null) mobilePhoneList = mobilePhone;
        try{
            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Depolama   | Kamera   | Pil    | Renk   |");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (MobilePhone m:mobilePhoneList){
                System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-8s | %-6s | %-6s | \n",
                        m.getId(),m.getName(),m.getUnitPrice(),m.getBrand(),m.getStok(),
                        m.getDiscountRate(),m.getRam(),m.getScreenSize(),m.getMemory(), m.getCamera(), m.getBatteryPower(), m.getColor());
            }
            System.out.println();
        }catch (NullPointerException e){
            System.out.println("Ürün listesinde ekli ürün bulunmamaktadır.");
        }

    }

    @Override
    public void deleteProduct() {
        getProducts();
        System.out.print("Silinmesini istediğiniz ürünün Id numarasını giriniz : ");
        int id=input.nextInt();
        Optional<MobilePhone> stuff = mobilePhone.stream()
                .filter(x->x.getId()==id)
                .findFirst();
        stuff.ifPresent(notebook->mobilePhone.remove(notebook));
        System.out.println("Güncel cep telefonu listesi ");
        getProducts();
    }


    @Override
    public void brandFilter() {
        input.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter= input.nextLine();
        LinkedList<MobilePhone> filterMobilePhone=new LinkedList<>();
        for (MobilePhone m:mobilePhone){
            if(filter.equals(m.getBrand().getName())){
                filterMobilePhone.add(m);
            }
        }
        listProduct(filterMobilePhone);
    }

    @Override
    public boolean checkID(int id) {
        for(MobilePhone mp : mobilePhone){
            if(id == mp.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateProduct() {
        getProducts();
        System.out.print("Güncellemek istediğiniz ürünün Id numarasını giriniz : ");
        int id=input.nextInt();
        for(MobilePhone m:mobilePhone){
            if(id == m.getId()){
                input.nextLine();
                System.out.print("Ürün Adı : ");
                String productName = input.nextLine();
                System.out.print("Ürün Birim Fiyat : ");
                double productPrice = input.nextDouble();
                System.out.print("Ürün İndirim Oranı : ");
                int discountRate = input.nextInt();
                System.out.print("Ürün Stok Miktarı : ");
                int productStok = input.nextInt();
                System.out.println("Ürün Markası");
                Brand.getBrand();
                System.out.println("Marka Seçiniz : ");
                Brand brand = Brand.getBrand(input.nextInt());

                m.setName(productName);
                m.setUnitPrice(productPrice);
                m.setDiscountRate(discountRate);
                m.setStok(productStok);
                m.setBrand(brand);
                System.out.println(id + " Id numaralı ürün güncellenmiştir.");
            }
        }

    }
}
