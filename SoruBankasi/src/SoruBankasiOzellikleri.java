
import java.util.Scanner;

public class SoruBankasiOzellikleri {

    private final int KOLAY_SORU_PUANI = 5, ZOR_SORU_PUANI = 10;
    private int toplamPuan = 0, dogruCevapSayisi = 0;

    private String verilenCevap ;

    private int menuNumarasi = 0;
    private final int ANAMENU = 0, SORU_LISTELE = 1, SORU_DUZENLE = 2, SORU_SIL = 3, SORU_COZ = 4, YENI_SORU = 5, CIKIS = 6;


    Scanner input = new Scanner(System.in);
    SoruBankasi yeniSoruBankasi = new SoruBankasi();

    public SoruBankasiOzellikleri(){
        System.out.println("-------------------------------------------------------\n" +
                "SORU BANKASI\n Islem yapmak istediginiz numarayi seciniz:\n");
    }

    public int getToplamPuan() {
        return toplamPuan;
    }

    private void setToplamPuan(int toplamPuan) {
        this.toplamPuan = toplamPuan;
    }

    public int getDogruCevapSayisi() {
        return dogruCevapSayisi;
    }

    private void setDogruCevapSayisi(int dogruCevapSayisi) {
        this.dogruCevapSayisi = dogruCevapSayisi;
    }

    public void menuYazdir() {

        System.out.println(
                "0) Menu Yazdir\n" +
                "1) Soru Listele\n" +
                "2) Soru Duzenle\n" +
                "3) Soru Sil\n" +
                "4) Soru Cozmeye Basla\n" +
                "5) Soru Ekle\n" +
                "6) Cikis"
        );

                programiBaslat();
    }

    private void programiBaslat(){

        for (; ; ) {
            menuNumarasi = input.nextInt();
            switch (menuNumarasi) {
                case ANAMENU:       menuYazdir();                           break;
                case SORU_LISTELE:  sorulariListele();   menuYazdir();      break;
                case SORU_DUZENLE:  soruDuzenle();       menuYazdir();      break;
                case SORU_SIL:      soruSil();           menuYazdir();      break;
                case SORU_COZ:      soruYazdir();        menuYazdir();      break;
                case YENI_SORU:     yeniSoruEkle();      menuYazdir();      break;
                case CIKIS:         System.out.println("Cikis Yapildi!");   break;
            }
            if (menuNumarasi == 6)
                break;
            else if (menuNumarasi > 6 || menuNumarasi < 0) {
                System.out.print("Gecersiz Bir Sayi Girdiniz! Lutfen Tekrar Giriniz : ");
            }

        }
    }

    private void soruYazdir(){
        System.out.println("\nKOLAY SORULAR\n");
        for (int i = 0; i < yeniSoruBankasi.soruSayisi()/2; i++) {

            System.out.println((i+1) + ") " + soruGetir(i));

            verilenCevap = input.next();
            char cevapSikki = verilenCevap.charAt(0);

            if (cevapSikki == cevapGetir(i)){
                toplamPuan += KOLAY_SORU_PUANI;
                dogruCevapSayisi +=1;
            }else toplamPuan += 0;

        }
        System.out.println("\nZOR SORULAR\n");
        for (int i = yeniSoruBankasi.soruSayisi()/2; i < yeniSoruBankasi.soruSayisi(); i++) {

            System.out.println((i+1) + ") " + soruGetir(i));

            verilenCevap = input.next();
            char cevapSikki = verilenCevap.charAt(0);

            if (cevapSikki == cevapGetir(i)){
                toplamPuan += ZOR_SORU_PUANI;
                dogruCevapSayisi +=1;
            }else toplamPuan += 0;

        }
        ToplamPuanHesapla();
    }

    private void ToplamPuanHesapla(){

        System.out.println("\nToplam puaniniz : " + getToplamPuan() +"\nDogru cevap sayisi : " + getDogruCevapSayisi() + "" +
                "\nYanlis cevap sayisi : " + (yeniSoruBankasi.soruSayisi() -getDogruCevapSayisi()));
        setToplamPuan(0);
        setDogruCevapSayisi(0);

    }

    private String soruGetir(int soruNumarasi){

        return yeniSoruBankasi.soruGoruntule(soruNumarasi);
    }

    private char cevapGetir(int cevapNumarasi){

        return yeniSoruBankasi.cevaplariGoruntule(cevapNumarasi);

    }

    private void sorulariListele(){
    	
    	 System.out.println("\nKOLAY SORULAR\n");
         for (int i = 0; i < yeniSoruBankasi.soruSayisi()/2; i++) {

        	 System.out.println((i+1) + ") " + soruGetir(i) + "\n Dogru Cevap : " + cevapGetir(i) + "" +
                     "\n---------------------------------------------------------");
         }
         System.out.println("\nZOR SORULAR\n");
         for (int i = yeniSoruBankasi.soruSayisi()/2; i < yeniSoruBankasi.soruSayisi(); i++) {

        	 System.out.println((i+1) + ") " + soruGetir(i) + "\n Dogru Cevap : " + cevapGetir(i) + "" +
                     "\n---------------------------------------------------------");
         }    
    }

    private void soruDuzenle(){

        System.out.print("Duzenlenecek soru numarasini giriniz : ");

        for(;;){
            int soruNumarasi = input.nextInt() - 1;

            if (soruNumarasi < yeniSoruBankasi.soruSayisi() && soruNumarasi >= 0) {
                yeniSoruBankasi.soruVeCevapDegistir(soruNumarasi);
                break;
            }
            else if (soruNumarasi >= yeniSoruBankasi.soruSayisi() || soruNumarasi < 0) {
                System.out.print("Gecersiz Bir Sayi Girdiniz! Lutfen Tekrar Giriniz : ");
            }
        }
    }

    private void soruSil(){

        System.out.println("Silinecek soru numarasini giriniz : ");
        int soruNumarasi = input.nextInt() - 1;
        yeniSoruBankasi.soruSil(soruNumarasi);

    }

    private void yeniSoruEkle(){

        yeniSoruBankasi.soruEkle();
        System.out.println("Soru eklenmistir.");

    }

}
