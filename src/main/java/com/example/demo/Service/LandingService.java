package com.example.demo.Service;

import com.example.demo.Dto.Response.EtkinlikDetayDto;
import com.example.demo.Entity.EtkinlikEntity;
import com.example.demo.Entity.EtkinlikSalonSeansEntity;
import com.example.demo.Entity.EtkinlikTurEntity;
import com.example.demo.Entity.SehirEntity;
import com.example.demo.Repository.EtkinlikRepository;
import com.example.demo.Repository.EtkinlikSalonSeansRepository;
import com.example.demo.Repository.EtkinlikTurRepository;
import com.example.demo.Repository.SehirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandingService {
    private EtkinlikRepository etkinlikRepository;
    private EtkinlikTurRepository etkinlikTurRepository;
    private SehirRepository sehirRepository;
    private EtkinlikSalonSeansRepository etkinlikSalonSeansRepository;

    @Autowired
    public LandingService(EtkinlikRepository etkinlikRepository,EtkinlikSalonSeansRepository etkinlikSalonSeansRepository,SehirRepository sehirRepository,EtkinlikTurRepository etkinlikTurRepository)
    {
        this.etkinlikSalonSeansRepository=etkinlikSalonSeansRepository;
        this.sehirRepository=sehirRepository;
        this.etkinlikTurRepository=etkinlikTurRepository;
        this.etkinlikRepository=etkinlikRepository;
    }

    public List<EtkinlikEntity> getEtkinlikler(String etkinlikTurAdi,String sehirAdi)
    {
        if (sehirAdi==null&&etkinlikTurAdi==null){
            return etkinlikRepository.findAll();
        } else if (sehirAdi == null) {
            EtkinlikTurEntity etkinlikTur=etkinlikTurRepository.findByEtkinlikTurAdi(etkinlikTurAdi);
            return etkinlikRepository.findByEtkinlikTur(etkinlikTur);
        }else {
            EtkinlikTurEntity etkinlikTur=etkinlikTurRepository.findByEtkinlikTurAdi(etkinlikTurAdi);
            SehirEntity sehir=sehirRepository.findBySehirAdi(sehirAdi);
            return etkinlikRepository.findBySehirAndEtkinlikTur(sehir,etkinlikTur);
        }
    }

    public EtkinlikDetayDto getEtkinlik(Long id)
    {
        EtkinlikEntity etkinlik=etkinlikRepository.findByEtkinlikID(id);
        List<EtkinlikSalonSeansEntity> etkinlikSalonSeansEntities=etkinlikSalonSeansRepository.findEtkinlikSalonSeansEntitiesByEtkinlik(etkinlik);
        return new EtkinlikDetayDto(etkinlik.getEtkinlikID(), etkinlik.getEtkinlikAdi(), etkinlik.getBiletFiyati(),etkinlik.getYasSiniri(),etkinlik.getEtkinlikTur(),etkinlikSalonSeansEntities,etkinlik.getEtkinlikSuresi(), etkinlik.getEtkinlikAciklamasi(), etkinlik.getOrganizator());
    }
}
