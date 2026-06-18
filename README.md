# Kütüphane Yönetim Sistemi

Merhaba! Bu proje, bilgisayar mühendisliği 2. sınıf staj uygulamam kapsamında geliştirdiğim konsol tabanlı bir Kütüphane Yönetim Sistemi'dir. Java ve SQL kullanarak tam kapsamlı bir CRUD uygulaması geliştirdim.

## Sistemde Neler Var?
Sistem mantıksal olarak 3 ana bloğa ayrılmıştır:
- **Kitap İşlemleri:** Yeni kitap ekleme, tüm kitapları listeleme, kitap bilgilerini güncelleme ve sistemden kitap silme.
- **Üye İşlemleri:** Kütüphaneye yeni üye kaydetme, üyeleri listeleme, üye bilgilerini güncelleme ve üye silme.
- **Ödünç İşlemleri:** Üyelere kitap zimmetleme (ödünç verme), kimde hangi kitap var listeleme ve iade alma (ödünç kaydını silme).

## Neler Kullandım?
- **Dil:** Java
- **Veritabanı:** SQLite 
- **Bağlantı:** JDBC Kütüphanesi 
- **Geliştirme Ortamı:** IntelliJ IDEA

## Projeyi Bilgisayarınızda Çalıştırmak İçin
Hocam kodları test etmek isterseniz adımlar şu şekildedir:
1. Projeyi bilgisayarınıza klonlayın ve IntelliJ IDEA ile açın.
2. Sol taraftaki proje dizininden `lib` klasörünü açın. İçindeki `sqlite-jdbc` .jar dosyasına sağ tıklayıp **"Add as Library..."** seçeneğine tıklayın. (Veritabanının çalışması için bu adım şarttır).
3. `src` klasöründeki `KutuphaneIslemleri.java` dosyasını çalıştırın.
4. Alt tarafta açılan konsol ekranından menüdeki sayıları tuşlayarak tüm CRUD işlemlerini test edebilirsiniz.