package com.example.demo.Dto;

public class LoginDto {
    private String kullaniciAdi;
    private String sifre;

    public  LoginDto(String kullaniciAdi, String sifre)
    {
        this.kullaniciAdi=kullaniciAdi;
        this.sifre=sifre;
    }

    public LoginDto(){}

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
