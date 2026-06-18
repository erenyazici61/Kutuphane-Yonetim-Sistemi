import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class KutuphaneIslemleri {

    public static void main(String[] args) {
        tablolariKur();
        Scanner okuyucu = new Scanner(System.in);
        boolean devam = true;

        while (devam) {
            System.out.println("\n--- KUTUPHANE SISTEMI ---");
            System.out.println("1- Kitap Ekle");
            System.out.println("2- Kitaplari Listele");
            System.out.println("3- Kitap Sil");
            System.out.println("4- Uye Ekle");
            System.out.println("5- Uyeleri Listele");
            System.out.println("6- Uye Sil");
            System.out.println("7- Kitap Odunc Ver");
            System.out.println("8- Odunc Verilenleri Listele");
            System.out.println("9- Odunc Kaydi Sil ");
            System.out.println("10- Cikis");
            System.out.print("Seciminiz: ");

            int secim = okuyucu.nextInt();
            okuyucu.nextLine();

            if (secim == 1) {
                System.out.print("Kitap ismini gir: ");
                String baslik = okuyucu.nextLine();
                System.out.print("Yazar ismini gir: ");
                String yazar = okuyucu.nextLine();
                kitapEkle(baslik, yazar);
            } else if (secim == 2) {
                kitaplariListele();
            } else if (secim == 3) {
                System.out.print("Silinecek Kitabin ID numarasini gir: ");
                int silinecekId = okuyucu.nextInt();
                kitapSil(silinecekId);
            } else if (secim == 4) {
                System.out.print("Uye Ad Soyad gir: ");
                String adSoyad = okuyucu.nextLine();
                uyeEkle(adSoyad);
            } else if (secim == 5) {
                uyeleriListele();
            } else if (secim == 6) {
                System.out.print("Silinecek Uyenin ID numarasini gir: ");
                int silinecekUyeId = okuyucu.nextInt();
                uyeSil(silinecekUyeId);
            } else if (secim == 7) {
                System.out.print("Odunc verilecek Kitabin ID numarasini gir: ");
                int kitapId = okuyucu.nextInt();
                System.out.print("Odunc alacak Uyenin ID numarasini gir: ");
                int uyeId = okuyucu.nextInt();
                kitapOduncVer(kitapId, uyeId);
            } else if (secim == 8) {
                oduncListele();
            } else if (secim == 9) {
                System.out.print("Silinecek Odunc Kaydinin (Iade) ID numarasini gir: ");
                int silinecekOduncId = okuyucu.nextInt();
                oduncSil(silinecekOduncId);
            } else if (secim == 10) {
                System.out.println("Sistemden cikiliyor...");
                devam = false;
            } else {
                System.out.println("Gecersiz secim!");
            }
        }
    }

    public static void tablolariKur() {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String kitapSQL = "CREATE TABLE IF NOT EXISTS Kitaplar (id INTEGER PRIMARY KEY AUTOINCREMENT, baslik TEXT, yazar TEXT)";
        String uyeSQL = "CREATE TABLE IF NOT EXISTS Uyeler (id INTEGER PRIMARY KEY AUTOINCREMENT, ad_soyad TEXT)";
        String oduncSQL = "CREATE TABLE IF NOT EXISTS Odunc (id INTEGER PRIMARY KEY AUTOINCREMENT, kitap_id INTEGER, uye_id INTEGER, FOREIGN KEY(kitap_id) REFERENCES Kitaplar(id), FOREIGN KEY(uye_id) REFERENCES Uyeler(id))";

        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(kitapSQL);
            ifade.execute(uyeSQL);
            ifade.execute(oduncSQL);
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

    public static void kitapSil(int id) {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "DELETE FROM Kitaplar WHERE id = " + id;
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            System.out.println("Kitap sistemden basariyla silindi.");
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Silme hatasi: " + hata.getMessage());
        }
    }

    public static void uyeEkle(String adSoyad) {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "INSERT INTO Uyeler (ad_soyad) VALUES ('" + adSoyad + "')";
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            System.out.println("Uye basariyla eklendi.");
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Hata: " + hata.getMessage());
        }
    }

    public static void uyeleriListele() {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "SELECT * FROM Uyeler";
        try {
            Statement ifade = baglanti.createStatement();
            ResultSet sonuc = ifade.executeQuery(sql);
            System.out.println("--- Kayitli Uyeler ---");
            while (sonuc.next()) {
                System.out.println("ID: " + sonuc.getInt("id") + " | Ad Soyad: " + sonuc.getString("ad_soyad"));
            }
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Listeleme hatasi: " + hata.getMessage());
        }
    }

    public static void uyeSil(int id) {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "DELETE FROM Uyeler WHERE id = " + id;
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            System.out.println("Uye sistemden basariyla silindi.");
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Silme hatasi: " + hata.getMessage());
        }
    }

    public static void kitapOduncVer(int kitapId, int uyeId) {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "INSERT INTO Odunc (kitap_id, uye_id) VALUES (" + kitapId + ", " + uyeId + ")";
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            System.out.println("Kitap basariyla odunc verildi.");
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Hata: " + hata.getMessage());
        }
    }

    public static void oduncListele() {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "SELECT * FROM Odunc";
        try {
            Statement ifade = baglanti.createStatement();
            ResultSet sonuc = ifade.executeQuery(sql);
            System.out.println("--- Odunc Verilen Kitaplarin Listesi ---");
            while (sonuc.next()) {
                System.out.println("Odunc ID: " + sonuc.getInt("id") + " | Kitap ID: " + sonuc.getInt("kitap_id") + " | Uye ID: " + sonuc.getInt("uye_id"));
            }
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Odunc listeleme hatasi: " + hata.getMessage());
        }
    }

    public static void oduncSil(int id) {
        Connection baglanti = VeritabaniBaglantisi.baglan();
        String sql = "DELETE FROM Odunc WHERE id = " + id;
        try {
            Statement ifade = baglanti.createStatement();
            ifade.execute(sql);
            System.out.println("Odunc kaydi basariyla silindi (Kitap iade alindi).");
            baglanti.close();
        } catch (Exception hata) {
            System.out.println("Odunc silme hatasi: " + hata.getMessage());
        }
    }
}