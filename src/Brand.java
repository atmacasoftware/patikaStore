import java.util.TreeSet;

public class Brand implements Comparable<Brand>{
    private int id;
    private String name;

    private static TreeSet<Brand> brandList=new TreeSet<>(Brand::compareTo);

    public Brand(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Brand(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Brand b) {
        return this.getId() - b.getId();
    }

    static {
        addBrands();
    }

    public static void addBrands(){
        brandList.add(new Brand(1, "Samsung"));
        brandList.add(new Brand(2, "Lenovo"));
        brandList.add(new Brand(3, "Apple"));
        brandList.add(new Brand(4, "Huawei"));
        brandList.add(new Brand(5, "Casper"));
        brandList.add(new Brand(6, "Asus"));
        brandList.add(new Brand(7, "HP"));
        brandList.add(new Brand(8, "Xiaomi"));
        brandList.add(new Brand(8, "Monster"));
    }

    public static void getBrand(){
        System.out.println("Marka Listesi ");
        for (Brand brand : brandList) {
            System.out.println(brand.id + " " + brand.getName());
        }
        System.out.println("----------------------------");
    }

    public static Brand getBrand(int id){
        for(Brand b:brandList){
            if(id==b.getId()){
                return b;
            }
        }
        return null;
    }

}
