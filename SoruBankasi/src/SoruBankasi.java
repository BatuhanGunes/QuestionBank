import java.util.ArrayList;
import java.util.Scanner;

public class SoruBankasi {

    private static ArrayList <String> sorular = new ArrayList<>();
    private static ArrayList <Character> cevaplar = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public SoruBankasi(){

        sorular.add("Turkiye'nin baskenti neresidir? \n a)Bursa b)Ankara c)Izmir d)Istanbul e)Kutahya");
        sorular.add("3 Buyuk Dince Kutsal Sayilan yer Neresidir?\n a)Mekke b)Kudus c)Roma d)istanbul");
        sorular.add("Romen Rakaminda Hangi Sayi Yoktur?\n a)0 b)50 c)100 d)1000");
        sorular.add("2003 yilinda Euro Vizyon Yarismasinda 1. olan sanatci kimdir? \n a)Athena b)Sertap Erener c)Sebnem Ferah d)Ajda Pekkan");
        sorular.add("Asagidaki ulkelerden hangisinin nufusu daha fazladir?\n a)Fransa b)ispanya c)ingiltere d)Almanya");
        sorular.add("Canakkale Hangi Savasin bir Cephesidir.\n a)Kurtulus Savasi b)1.Dunya Savasi c)2.Dunya Savasi d)Balkan Savasi");
        sorular.add("Halifelik ilk hangi padisah zamaninda Osmanlilara gecmistir? \n a)Fatih Sultan Mehmet b)kanuni Sultan Selim c)Osman Gazi d)Yavuz Sultan Selim");
        sorular.add("Hangisi 1923 sonrasi bir donem istanbul'un bir ilcesiydi?\n a)yalova b)gebze c)Corlu d)besiktas");
        sorular.add("islam inancina gore hangisi daha once yasamistir?\n a)Hz.isa b)Hz.Musa c)Hz.Muhammed d)Hz.Nuh");
        sorular.add("Yunanistan'in Baskenti neresidir? \n a)Selanik b)Atina C)Pire d)Roma");
        
        cevaplar.add('b');		//1
        cevaplar.add('b');		//2
        cevaplar.add('a');		//3
        cevaplar.add('b');		//4
        cevaplar.add('d');		//5
        cevaplar.add('b');		//6
        cevaplar.add('d');		//7
        cevaplar.add('a');		//8
        cevaplar.add('d');		//9
        cevaplar.add('b');		//10
        
    }

    public int soruSayisi(){

        return sorular.size();
    }

    public int cevapSayisi(){

        return cevaplar.size();
    }

    public String soruGoruntule(int soruNumarasi){

        return sorular.get(soruNumarasi);
    }

    public char cevaplariGoruntule(int cevapNumarasi){

        return cevaplar.get(cevapNumarasi);
    }

    public void soruVeCevapDegistir(int soruCevapNumarasi){

        soruDegistir(soruCevapNumarasi);
        cevapDegistir(soruCevapNumarasi);

        System.out.println("Soru Degistirilmistir.");
    }

    public void soruDegistir(int soruNumarasi){

        System.out.println("Yeni soruyu giriniz : ");
        String yeniSoru = input.nextLine();
        String [] secenekler = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < 5; i++) {
            System.out.print("\n"+secenekler[i]+" secenegini giriniz : ");
            secenekler[i] = input.nextLine();
        }
        sorular.set(soruNumarasi,yeniSoru +"\na)"+secenekler[0] + " b)"+secenekler[1]+"" +
                " c)"+secenekler[2]+" d)"+secenekler[3]+" e)"+secenekler[4]);

    }

    public void cevapDegistir(int cevapNumarasi){

        System.out.println("Dogru Cevabi giriniz : ");
        String dogruCevap = input.nextLine();
        char yeniCevap = dogruCevap.charAt(0);
        cevaplar.set(cevapNumarasi,yeniCevap);

    }

    public void soruSil(int soruNumarasi){

        sorular.remove(soruNumarasi);
        cevaplar.remove(soruNumarasi);

    }

    public void soruEkle(){
        System.out.println("Yeni soruyu giriniz : ");
        String yeniSoru = input.nextLine();
        String [] secenekler = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < 5; i++) {
            System.out.print("\n"+secenekler[i]+" secenegini giriniz : ");
            secenekler[i] = input.nextLine();
        }
        sorular.add(yeniSoru +"\na)"+secenekler[0] + " b)"+secenekler[1]+"" +
                " c)"+secenekler[2]+" d)"+secenekler[3]+" e)"+secenekler[4]);


        System.out.println("Dogru Cevabi giriniz : ");
        String dogruCevap = input.nextLine();
        char yeniCevap = dogruCevap.charAt(0);
        cevaplar.add(yeniCevap);

    }


}