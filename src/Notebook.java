import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class Notebook extends ProductGroup implements ProductInterface{

    private int harddisk;
    private static LinkedList<Notebook> notebooks=new LinkedList<>();

    public Notebook(int id, double unitPrice, int discountRate, int stok, String name, Brand brand, int ram, double screenSize, int harddisk) {
        super(id, unitPrice, discountRate, stok, name, brand, ram, screenSize);
        this.harddisk = harddisk;
    }

    public Notebook(){

    }


    public int getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(int harddisk) {
        this.harddisk = harddisk;
    }


    @Override
    public void menu() {
        System.out.println("1- Ürün Ekle\n" +
                "2- Ürün Listele\n" +
                "3- Ürün Sil\n" +
                "4- Ürün Filtrele\n"+
                "5- Ürün Güncelle");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value=input.nextInt();
        if(value==1) addProduct();
        if(value==2) getProducts();
        if(value==3) deleteProduct();
        if(value==4) brandFilter();
        if(value==5) updateProduct();
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
        System.out.print("Ürün Depolama Hafızası : ");
        int productHarddisk = input.nextInt();
        System.out.println("Ürün Markası");
        Brand.getBrand();
        System.out.println("Marka Seçiniz : ");
        Brand brand = Brand.getBrand(input.nextInt());
        if(!checkID(productCode)){
            Notebook notebook = new Notebook(productCode, productPrice, discountRate, productStok, productName, brand, productRam, productScreenSize, productHarddisk);
            System.out.println("Notebook başarıyla eklendi.");
            notebooks.add(notebook);
        }else{
            System.out.println("Girdiğiniz ürün kodunda ürün bulunmaktadır. Lütfen farklı bir ürün kodu giriniz.");
        }
    }


    @Override
    public void getProducts() {
        listProduct(null);
    }


    public void listProduct(LinkedList<Notebook> notebookList){
            if(notebookList==null) notebookList = notebooks;
            try{
                System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                for (Notebook n:notebookList){
                    System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                            n.getId(),n.getName(),n.getUnitPrice(),n.getBrand(),n.getStok(),
                            n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getHarddisk());
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
        Optional<Notebook> stuff = notebooks.stream()
                .filter(x->x.getId()==id)
                .findFirst();
        stuff.ifPresent(notebook->notebooks.remove(notebook));
        System.out.println("Güncel notebook listesi ");
        getProducts();
    }

    @Override
    public void updateProduct() {
        getProducts();
        System.out.print("Güncellemek istediğiniz ürünün Id numarasını giriniz : ");
        int id=input.nextInt();
        for(Notebook n:notebooks){
            if(id == n.getId()){
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

                n.setName(productName);
                n.setUnitPrice(productPrice);
                n.setDiscountRate(discountRate);
                n.setStok(productStok);
                n.setBrand(brand);
                System.out.println(id + " Id numaralı ürün güncellenmiştir.");
            }
        }

    }

    @Override
    public void brandFilter() {
        input.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter= input.nextLine();
        LinkedList<Notebook> filterNotebooks=new LinkedList<>();
        for (Notebook n:notebooks){
            if(filter.equals(n.getBrand().getName())){
                filterNotebooks.add(n);
            }
        }
        listProduct(filterNotebooks);
    }

    @Override
    public boolean checkID(int id){
        for(Notebook notebook : notebooks){
            if(id == notebook.getId()){
                return true;
            }
        }
        return false;
    }
}
