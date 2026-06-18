# Kütüphane Yönetim Sistemi

Merhaba! Bu proje, bilgisayar mühendisliği 2. sınıf staj uygulamam kapsamında geliştirdiğim temel bir Kütüphane Yönetim Sistemi'dir. Java ve SQL kullanarak yazdım. Amacım, konsol üzerinden çalışan basit bir veritabanı uygulaması geliştirmekti.

## Sistemde Neler Var?
Menü üzerinden şu işlemleri yapabiliyoruz:
- **Kitaplar:** Yeni kitap ekleme ve sistemdeki tüm kitapları listeleme.
- **Üyeler:** Kütüphaneye yeni üye kaydetme ve tüm üyeleri görme.
- **Ödünç Verme:** Sisteme eklediğimiz kitapları, yine sistemdeki üyelere ID numaraları üzerinden ödünç verme. 

## Neler Kullandım?
- **Dil:** Java
- **Veritabanı:** SQL 
- **Bağlantı:** JDBC Kütüphanesi
- **IDE:** IntelliJ IDEA

## Projeyi Bilgisayarınızda Çalıştırmak İçin
 Kodları denemek isterseniz adımlar şu şekilde:
1. Projeyi bilgisayarınızda klonlayın ve IntelliJ IDEA ile açın.
2. Sol taraftan `lib` klasörünü açın. İçindeki `sqlite-jdbc` .jar dosyasına sağ tıklayıp **"Add as Library..."** seçeneğine tıklayın. (Veritabanının çalışması için bu adım şart).
3. `src` klasöründeki `KutuphaneIslemleri.java` dosyasını Run tuşuna basarak çalıştırın.
4. Alt tarafta açılan konsol ekranından sayıları tuşlayarak menüyü kullanabilirsiniz.