package com.example.demo.Dto;

public class OrgSignUpDto {
    private String adSoyad;
    private String vergiNo;
    private String email;
    private String sifre;
    private String iban;
    private String sirketAdresi;
    private String tckNo;
    private String telefonNumarasi;

    public OrgSignUpDto(String adSoyad, String vergiNo, String email, String sifre, String iban, String sirketAdresi, String tckNo, String telefonNumarasi) {
        this.adSoyad = adSoyad;
        this.vergiNo = vergiNo;
        this.email = email;
        this.sifre = sifre;
        this.iban = iban;
        this.sirketAdresi = sirketAdresi;
        this.tckNo = tckNo;
        this.telefonNumarasi = telefonNumarasi;
    }

    public OrgSignUpDto(){}

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSirketAdresi() {
        return sirketAdresi;
    }

    public void setSirketAdresi(String sirketAdresi) {
        this.sirketAdresi = sirketAdresi;
    }

    public String getTckNo() {
        return tckNo;
    }

    public void setTckNo(String tckNo) {
        this.tckNo = tckNo;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }
}
