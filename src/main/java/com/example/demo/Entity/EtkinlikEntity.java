package com.example.demo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "etkinlik")
public class EtkinlikEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etkinlikId;
//tamam
    @OneToMany(mappedBy = "etkinlik")
    private List<EtkinlikSalonSeansEntity> etkinlikSalonSeansEntityList;

    @ManyToOne
    OrganizatorEntity organizator;

    @ManyToOne
    EtkinlikTurEntity etkinlikTur;

    @ManyToOne
    SehirEntity sehir;

    @Column(name = "etkinlikAdi",nullable = false)
    private String etkinlikAdi;

    @Column(name = "kapakFotografi",nullable = false)
    private String kapakFotografi;

    @Column(name = "etkinlikAciklamasi",nullable = false)
    private String etkinlikAciklamasi;

    @Column(name = "yasSiniri",nullable = false)
    private int yasSiniri;

    @Column(name = "etkinlikSuresi",nullable = false)
    private Timestamp etkinlikSuresi;

    @Column(name = "olusturulmaZamani")
    @CreationTimestamp
    private Timestamp olusturulmaTarihi;

    @Column(name = "tarihiGectiMi")
    private boolean tarihiGectiMi=false;

    @Column(name = "biletFiyati",nullable = false)
    private float biletFiyati;

    public EtkinlikEntity(Long etkinlikID, OrganizatorEntity organizator, EtkinlikTurEntity etkinlikTur, SehirEntity sehir, String etkinlikAdi, String kapakFotografi, String etkinlikAciklamasi, int yasSiniri, Timestamp etkinlikSuresi, Timestamp olusturulmaTarihi, boolean tarihiGectiMi, float biletFiyati) {
        this.etkinlikId = etkinlikID;
        this.organizator = organizator;
        this.etkinlikTur = etkinlikTur;
        this.sehir = sehir;
        this.etkinlikAdi = etkinlikAdi;
        this.kapakFotografi = kapakFotografi;
        this.etkinlikAciklamasi = etkinlikAciklamasi;
        this.yasSiniri = yasSiniri;
        this.etkinlikSuresi = etkinlikSuresi;
        this.olusturulmaTarihi = olusturulmaTarihi;
        this.tarihiGectiMi = tarihiGectiMi;
        this.biletFiyati = biletFiyati;
    }

    public EtkinlikEntity(){}

    public Long getEtkinlikID() {
        return etkinlikId;
    }

    public void setEtkinlikID(Long etkinlikID) {
        this.etkinlikId = etkinlikID;
    }

    public OrganizatorEntity getOrganizator() {
        return organizator;
    }

    public void setOrganizator(OrganizatorEntity organizator) {
        this.organizator = organizator;
    }

    public EtkinlikTurEntity getEtkinlikTur() {
        return etkinlikTur;
    }

    public void setEtkinlikTur(EtkinlikTurEntity etkinlikTur) {
        this.etkinlikTur = etkinlikTur;
    }

    public SehirEntity getSehir() {
        return sehir;
    }

    public void setSehir(SehirEntity sehir) {
        this.sehir = sehir;
    }

    public String getEtkinlikAdi() {
        return etkinlikAdi;
    }

    public void setEtkinlikAdi(String etkinlikAdi) {
        this.etkinlikAdi = etkinlikAdi;
    }

    public String getKapakFotografi() {
        return kapakFotografi;
    }

    public void setKapakFotografi(String kapakFotografi) {
        this.kapakFotografi = kapakFotografi;
    }

    public String getEtkinlikAciklamasi() {
        return etkinlikAciklamasi;
    }

    public void setEtkinlikAciklamasi(String etkinlikAciklamasi) {
        this.etkinlikAciklamasi = etkinlikAciklamasi;
    }

    public int getYasSiniri() {
        return yasSiniri;
    }

    public void setYasSiniri(int yasSiniri) {
        this.yasSiniri = yasSiniri;
    }

    public Timestamp getEtkinlikSuresi() {
        return etkinlikSuresi;
    }

    public void setEtkinlikSuresi(Timestamp etkinlikSuresi) {
        this.etkinlikSuresi = etkinlikSuresi;
    }

    public Timestamp getOlusturulmaTarihi() {
        return olusturulmaTarihi;
    }

    public void setOlusturulmaTarihi(Timestamp olusturulmaTarihi) {
        this.olusturulmaTarihi = olusturulmaTarihi;
    }

    public boolean isTarihiGectiMi() {
        return tarihiGectiMi;
    }

    public void setTarihiGectiMi(boolean tarihiGectiMi) {
        this.tarihiGectiMi = tarihiGectiMi;
    }

    public float getBiletFiyati() {
        return biletFiyati;
    }

    public void setBiletFiyati(float biletFiyati) {
        this.biletFiyati = biletFiyati;
    }
}
