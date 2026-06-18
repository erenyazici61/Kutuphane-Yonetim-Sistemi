# Kütüphane Yönetim Sistemi

Selamlar! Bu proje, İş Yeri Uygulaması (IYU-228) dersi kapsamında geliştirdiğim konsol tabanlı bir Kütüphane Yönetim Sistemi. Uygulama sayesinde temel kütüphane işlerini, yani kitap eklemeyi, üye kaydını ve ödünç alma süreçlerini bir veritabanı üzerinden yönetebiliyoruz.

## Kullanılan Teknolojiler ve Projedeki Rolleri
- **Java:** Sistemin ana iskeletini, iş mantığını ve kullanıcının ekranda gördüğü konsol menüsünü kodlamak için kullandım.
- **SQLite:** Verilerin kalıcı olarak saklanması ve tablolar arası ilişkilerin kurulması için kullandım. Sunucu kurulumu gerektirmeden doğrudan dosya üzerinden çalıştığı için projeyi bayağı hızlandırdı.
- **GitHub:** Projenin versiyon kontrolünü sağlamak, yazdığım kodları aşama aşama yedeklemek ve geliştirme sürecimi göstermek için kullandım.

## Gerekli Kütüphaneler
Projenin Java ile SQLite veritabanı arasında iletişim kurabilmesi için JDBC sürücüsüne ihtiyacı var.
- `sqlite-jdbc-3.41.2.2.jar` dosyasının projeyi çalıştırmadan önce kütüphane olarak eklenmesi zorunlu.

## Projeyi Nasıl Yaptım?
Geliştirme sürecini üç ana aşamaya böldüm:
1. **Veritabanı Tasarımı:** İlk olarak Kitaplar, Uyeler ve Odunc isimli üç tabloyu tasarlayıp tablolar arasındaki bağlantıları kurguladım.
2. **Bağlantı ve Metotlar:** Java'da JDBC bağlantısını kurduktan sonra ekleme, silme, listeleme ve güncelleme gibi her bir işlem için ayrı metotlar yazarak kodları mantıksal bloklara ayırdım.
3. **Kullanıcı Arayüzü:** Scanner sınıfı ile sonsuz döngüde çalışan bir konsol menüsü hazırlayarak kullanıcı etkileşimini sağladım.

## Süreçte Zorlandığım Yerler
Beni en çok zorlayan kısım, SQL sorgularını Java içerisinde metin olarak birleştirirken yaşadığım yazım hataları oldu. Tırnak işaretleri ve değişken boşlukları bazen çok karıştı. Ayrıca güncelleme ve silme işlemlerini yaparken, ödünç tablosunda kaydı bulunan bir üyeyi veya kitabı silmeye çalışmanın yarattığı mantıksal hataları ve yabancı anahtar çakışmalarını çözmek epey vaktimi aldı.

## Neler Öğrendim?
Bu proje sayesinde okulda teorik olarak gördüğümüz SQL sorgularının gerçek bir yazılım dili olan Java ile arka planda nasıl çalıştırıldığını pratik ederek öğrendim. Try-catch bloklarıyla veritabanı hatalarını yakalamayı, metotları gruplandırarak temiz kod yazmayı ve Git komutlarıyla proje yönetmeyi tecrübe ettim.

## Projeyi Çalıştırma Talimatları
1. Projeyi bilgisayarınıza klonlayın ve IntelliJ IDEA veya tercih ettiğiniz başka bir editörle açın.
2. Sol taraftaki proje dizinden lib klasörünü açın. İçindeki `sqlite-jdbc-3.41.2.2.jar` dosyasına sağ tıklayıp Add as Library seçeneğine tıklayın.
3. Src klasöründeki `KutuphaneIslemleri.java` dosyasını çalıştırın.
4. Açılan konsol ekranından menüdeki sayıları tuşlayarak sistemi kullanabilirsiniz.

---

## Test Durumları
Sistemin doğru çalıştığından emin olmak için yaptığım test senaryoları şu şekilde:

* **Test 1 - Veri Ekleme ve Listeleme Doğrulaması:** Sistem üzerinden yeni bir kitap ve üye ekledim. Sonrasında listeleme menülerinden bu verilerin SQLite veritabanına otomatik artan ID değerleriyle düzgünce yansıdığını gördüm.
* **Test 2 - İlişkisel Veri Ödünç Verme Testi:** Kayıtlı bir kitabın ID'si ile kayıtlı bir üyenin ID'sini eşleştirerek ödünç verme işlemi yaptım ve ödünç tablosuna verinin başarıyla işlendiğini teyit ettim.
* **Test 3 - Güncelleme Doğrulaması:** Menü üzerinden yanlış girilen bir üye isminin, kendi ID'si üzerinden başarıyla yeni bir isimle güncellenebildiğini test ettim.
* **Test 4 - Silme ve İade Testi:** Ödünç alınan bir kitabın ödünç kaydını sil menüsü üzerinden başarıyla iade alındığını ve sonrasında kitabın sistemden tamamen silinebildiğini test ederek bütün döngüyü tamamladım.

## GitHub Deposu
Projenin GitHub bağlantısı:
https://github.com/erenyazici61/Kutuphane-Yonetim-Sistemi.git