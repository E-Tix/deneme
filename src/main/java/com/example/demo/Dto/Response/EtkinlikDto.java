package com.example.demo.Dto.Response;

import com.example.demo.Entity.EtkinlikTurEntity;

import java.sql.Time;
import java.sql.Timestamp;

public class EtkinlikDto {
    private Long etkinlikId;
    private String etkinlikAdi;
    private EtkinlikTurEntity etkinlikTur;
    private String kapakFotografi;

    public EtkinlikDto(Long etkinlikId, String etkinlikAdi, EtkinlikTurEntity etkinlikTur, String kapakFotografi) {
        this.etkinlikId = etkinlikId;
        this.etkinlikAdi = etkinlikAdi;
        this.etkinlikTur = etkinlikTur;
        this.kapakFotografi = kapakFotografi;
    }

    public EtkinlikDto() {
    }

    public Long getEtkinlikId() {
        return etkinlikId;
    }

    public void setEtkinlikId(Long etkinlikId) {
        this.etkinlikId = etkinlikId;
    }

    public String getEtkinlikAdi() {
        return etkinlikAdi;
    }

    public void setEtkinlikAdi(String etkinlikAdi) {
        this.etkinlikAdi = etkinlikAdi;
    }

    public EtkinlikTurEntity getEtkinlikTur() {
        return etkinlikTur;
    }

    public void setEtkinlikTur(EtkinlikTurEntity etkinlikTur) {
        this.etkinlikTur = etkinlikTur;
    }

    public String getKapakFotografi() {
        return kapakFotografi;
    }

    public void setKapakFotografi(String kapakFotografi) {
        this.kapakFotografi = kapakFotografi;
    }
}
