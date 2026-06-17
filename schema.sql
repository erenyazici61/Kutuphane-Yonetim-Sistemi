CREATE TABLE Kitaplar (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          baslik VARCHAR(255) NOT NULL,
                          yazar VARCHAR(255) NOT NULL,
                          yayin_yili INT,
                          durum VARCHAR(50) DEFAULT 'Mevcut'
);
CREATE TABLE Uyeler (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        ad_soyad VARCHAR(255) NOT NULL,
                        telefon VARCHAR(20),
                        eposta VARCHAR(100)
);
CREATE TABLE OduncKayitlari (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                kitap_id INT,
                                uye_id INT,
                                odunc_tarihi DATE,
                                iade_tarihi DATE,
                                FOREIGN KEY (kitap_id) REFERENCES Kitaplar(id),
                                FOREIGN KEY (uye_id) REFERENCES Uyeler(id)
);