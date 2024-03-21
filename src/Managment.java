import java.util.*;

public class Managment {
    private Scanner input = new Scanner(System.in);


    public void start() {
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        while (true) {
            System.out.println("1 - Notebook İşlemleri\n2 - Cep Telefonu İşlemleri\n3 - Marka Listele\n4 - Çıkış Yap");
            try {
                System.out.print("Tercihiniz : ");
                int selectChoice = input.nextInt();
                switch (selectChoice) {
                    case 1:
                        Notebook notebook = new Notebook();
                        notebook.menu();
                        break;
                    case 2:
                        MobilePhone mobilePhone = new MobilePhone();
                        mobilePhone.menu();
                        break;
                    case 3:
                        Brand.getBrand();
                        System.out.println();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lütfen 1 - 3 arasında değer giriniz. Çıkmak için '0'");
                }
            } catch (InputMismatchException e) {
                System.out.println("Hatalı değer girdiniz. Lütfen tekrar deneyiniz.");
            }

        }
    }


}
