package com.example.demo.Dto;

import com.example.demo.Entity.SehirEntity;

public class KullaniciProfiliDto {
    private String adSoyad;
    private String email;
    private SehirEntity sehir;
    private String telNo;

    public KullaniciProfiliDto(String adSoyad, String email, SehirEntity sehir, String telNo) {
        this.adSoyad = adSoyad;
        this.email = email;
        this.sehir = sehir;
        this.telNo = telNo;
    }

    public KullaniciProfiliDto(){}

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SehirEntity getSehir() {
        return sehir;
    }

    public void setSehir(SehirEntity sehir) {
        this.sehir = sehir;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
