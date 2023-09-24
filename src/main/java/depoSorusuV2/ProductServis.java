package depoSorusuV2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductServis {

    static PojoUrun obje = new PojoUrun();
    static Scanner input = new Scanner(System.in);
    static Map <Integer, PojoUrun> urunler =new HashMap<>();



    public static void urunTanimlama(){




        System.out.print("Lütfen Ürün İsmi Giriniz = ");
        input.nextLine();
        String urunIsmi = input.nextLine();
        obje.setUrunIsmi(urunIsmi);

        System.out.print("Lütfen Ürün Üreticisini Giriniz = ");
        String uretici = input.nextLine();
        obje.setUretici(uretici);

        System.out.print("Lütfen Ürün Birimi Giriniz = ");
        String birim = input.nextLine();
        obje.setBirim(birim);

        System.out.print("Lütfen Ürün ID'si Giriniz = ");
        int id = input.nextInt();
        obje.setId(id);

        // Yeni bir PojoUrun nesnesi oluşturun
        PojoUrun urun = new PojoUrun(obje.getId(), obje.getUrunIsmi(), obje.getUretici(), obje.getMiktar(), obje.getBirim(), obje.getRaf());

        // Eğer aynı ID'de ürün zaten varsa uyarı verin
        if (urunler.containsKey(id)){
            System.out.println("Aynı ID Ürün Eklenemez");
        }else {
            urunler.put(urun.getId(), urun);
            System.out.println("Başarıyla Ürün Eklendi");
        }




    }




    public static void urunListele(){

        System.out.println("=============================================== ÜRÜN LİSTELEME ==============================================");
        System.out.printf("%-4s %20s %20s %20s %20s %20s \n", "İd", "İsmi", "Üreticisi", "Miktarı", "Birimi", "Raf"   );

        for (Map.Entry<Integer,PojoUrun> w: urunler.entrySet()) {

            PojoUrun urun = w.getValue();

            System.out.printf("%-4s %20s %14s %20s %20s %20s \n",urun.getId(), urun.getUrunIsmi(), urun.getUretici(), urun.getMiktar(), urun.getBirim(), urun.getRaf());
        }
    }



    public static void urunGirisi(){

        urunListele();
        System.out.print("Lütfen ID'si Olan Bir Ürün Giriniz = ");
        int idKontrol = input.nextInt();

        if (urunler.keySet().contains(idKontrol)){

            System.out.print("Lütfen Miktar Giriniz = ");
            int miktar = input.nextInt();

            PojoUrun urun = urunler.get(idKontrol);
            int mevcutMiktar = urun.getMiktar();
            urun.setMiktar(mevcutMiktar+miktar);

        }else {
            System.out.println("ID Eşleşmedi!.. Lütfen Olan Bir ID Giriniz");
        }



    }



    public static void urunuRafaKoy(){

        urunListele();
        System.out.print("Lütfen ID'si Olan Bir Ürün Giriniz = ");
        int idKontrol = input.nextInt();

        if (urunler.keySet().contains(idKontrol)){

            System.out.print("Lütfen Hangi Rafa Koymak İstediğinizi GiRİNİZ = ");
            input.nextLine();
            String raf = input.nextLine();
            obje.setRaf(raf);

            PojoUrun urun = urunler.get(idKontrol);
            urun.setRaf(raf);
            System.out.println("Ürün Rafa Koyuldu");
        }

    }


    public static void urunCikisi(){

        System.out.print("DENEME Lütfen ID'Sİ olan Bir Ürün Giriniz = ");
        int idKontrol = input.nextInt();

        if (urunler.containsKey(idKontrol)){

            System.out.print("Lütfen Kaç Adet Ürün Çıkışı Yapacağınızı Giriniz = ");
            int urunCikisi = input.nextInt();

            PojoUrun urun = urunler.get(idKontrol);
            urun.setMiktar(urun.getMiktar() - urunCikisi);
            System.out.println("Başarıyla Ürün Çıkışı Yapıldı");

        }else {
            System.out.println("ID Eşleşmedi!.. Lütfen Olan Bir ID Giriniz");
        }

    }



}
