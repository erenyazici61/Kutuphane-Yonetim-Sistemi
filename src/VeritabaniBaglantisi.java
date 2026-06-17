import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeritabaniBaglantisi {

    private static final String URL = "jdbc:sqlite:kutuphane.db";

    public static Connection baglan() {
        Connection baglanti = null;
        try {
            Class.forName("org.sqlite.JDBC");
            baglanti = DriverManager.getConnection(URL);
            System.out.println("Harika! Veritabanina basariyla baglanildi.");
        } catch (ClassNotFoundException e) {
            System.out.println("Surucu bulunamadi. JAR dosyasini kontrol et: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Baglanti hatasi: " + e.getMessage());
        }
        return baglanti;
    }

    public static void main(String[] args) {
        baglan();
    }
}