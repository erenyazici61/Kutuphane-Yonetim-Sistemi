import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class KutuphaneIslemleri {

    public static void main(String[] args) {
        tabloyuOlustur();

        Scanner okuyucu = new Scanner(System.in);

        System.out.print("Kitap ismini gir: ");
        String baslik = okuyucu.nextLine();

        System.out.print("Yazar ismini gir: ");
        String yazar = okuyucu.nextLine();

        kitapEkle(baslik, yazar);
        kitaplariListele();
    }

    public static void tabloyuOlustur() {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "CREATE TABLE IF NOT EXISTS Kitaplar (id INTEGER PRIMARY KEY AUTOINCREMENT, baslik TEXT, yazar TEXT)";
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Tablo hatasi: " + hata.getMessage());
        }
    }

    public static void kitapEkle(String baslik, String yazar) {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "INSERT INTO Kitaplar (baslik, yazar) VALUES ('" + baslik + "', '" + yazar + "')";
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            System.out.println("Kitap basariyla eklendi.");
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Hata: " + hata.getMessage());
        }
    }

    public static void kitaplariListele() {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "SELECT * FROM Kitaplar";
        try {
            Statement ifade = baglanti.createStatement();
            ResultSet sonuc = ifade.executeQuery(sql);
            System.out.println("--- Kayitli Kitaplar ---");
            while (sonuc.next()) {
                System.out.println("ID: " + sonuc.getInt("id") + " | Baslik: " + sonuc.getString("baslik") + " | Yazar: " + sonuc.getString("yazar"));
            }
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Listeleme hatasi: " + hata.getMessage());
        }
    }
}