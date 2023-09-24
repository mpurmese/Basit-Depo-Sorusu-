package depoSorusuV2;

import static depoSorusuV2.ProductServis.*;

public class Runner {

    public static void main(String[] args) {


        boolean dongu = true;
        do {
            try {
                System.out.println("===== Hoşgeldiniz =====");
                System.out.println("1- Ürün Tanımlama");
                System.out.println("2- Ürün Listeleme");
                System.out.println("3- Ürün Girişi");
                System.out.println("4- Ürün Rafa Koyma");
                System.out.println("5- Ürün Çıkışı");
                System.out.println("0- Çıkış");
                System.out.println("=======================");
                System.out.print("Lütfen Seçiminizi Giriniz = ");
                int secim = input.nextInt();

                switch (secim){
                    case 1:
                        urunTanimlama();
                        break;
                    case 2:
                        urunListele();
                        break;
                    case 3:
                        urunGirisi();
                        break;
                    case 4:
                        urunuRafaKoy();
                        break;
                    case 5:
                        urunCikisi();
                        break;
                    case 0:
                        System.out.println("Başarıyla Çıkış Yapıldı");
                        dongu = false;
                        break;
                    default:
                        System.out.println("Hatalı Seçim Lütfen 1-5 Arası Seçim Yapınız");

                }
            }catch (Exception e){
                System.out.println("Lütfen 1-5 Arası RAKAM Giriniz HARF Veya Özel Karakter Girmeyiniz");
                input.next();
            }

        }while (dongu);





    }

}
