CREATE TABLE Kitaplar (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          baslik VARCHAR(255) NOT NULL,
                          yazar VARCHAR(255) NOT NULL,
                          yayin_yili INT,
                          durum VARCHAR(50) DEFAULT 'Mevcut'
);

CREATE TABLE Uyeler (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        ad_soyad VARCHAR(255) NOT NULL,
                        telefon VARCHAR(20),
                        eposta VARCHAR(100)
);

CREATE TABLE OduncKayitlari (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                kitap_id INT,
                                uye_id INT,
                                odunc_tarihi DATE,
                                iade_tarihi DATE,
                                FOREIGN KEY (kitap_id) REFERENCES Kitaplar(id),
                                FOREIGN KEY (uye_id) REFERENCES Uyeler(id)
);

-- ÖRNEK VERİ KISMI
INSERT INTO Kitaplar (baslik, yazar, yayin_yili) VALUES ('1984', 'George Orwell', 1949);
INSERT INTO Kitaplar (baslik, yazar, yayin_yili) VALUES ('Dune', 'Frank Herbert', 1965);

INSERT INTO Uyeler (ad_soyad, telefon, eposta) VALUES ('Eren Yazici', '05426975671', 'eyaziciren@gmail.com');
INSERT INTO Uyeler (ad_soyad, telefon, eposta) VALUES ('Emre Yilmaz', '05551234567', 'emre@gmail.com');