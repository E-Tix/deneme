package com.example.demo.Service;

import com.example.demo.Dto.Request.EtkinlikEkleDto;
import com.example.demo.Dto.Response.EtkinlikForOrgDto;
import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizatorLandingService {
    private OrganizatorRepository organizatorRepository;
    private EtkinlikRepository etkinlikRepository;
    private SeansRepository seansRepository;
    private SalonRepository salonRepository;
    private EtkinlikSalonSeansRepository etkinlikSalonSeansRepository;

    public OrganizatorLandingService(EtkinlikSalonSeansRepository etkinlikSalonSeansRepository,OrganizatorRepository organizatorRepository, EtkinlikRepository etkinlikRepository, SeansRepository seansRepository, SalonRepository salonRepository) {
        this.etkinlikSalonSeansRepository=etkinlikSalonSeansRepository;
        this.organizatorRepository = organizatorRepository;
        this.etkinlikRepository = etkinlikRepository;
        this.seansRepository = seansRepository;
        this.salonRepository = salonRepository;
    }

    public boolean etkinlikEkle(EtkinlikEkleDto etkinlikEkleDto,Long id){

        OrganizatorEntity organizator=organizatorRepository.findByOrganizatorID(id);

        if (organizator==null){
            return false;
        }

        EtkinlikEntity etkinlik=new EtkinlikEntity(organizator,etkinlikEkleDto.getEtkinlikTur(),etkinlikEkleDto.getSehir(), etkinlikEkleDto.getEtkinlikAdi(), etkinlikEkleDto.getEtkinlikAciklamasi(), etkinlikEkleDto.getKapakFotografi(), etkinlikEkleDto.getYasSiniri(), etkinlikEkleDto.getEtkinlikSuresi(),etkinlikEkleDto.getBiletFiyati());
        etkinlik=etkinlikRepository.save(etkinlik);
        SalonEntity salon=etkinlikEkleDto.getSalon();
        SeansEntity seans;

        while (!etkinlikEkleDto.getSeansEkleDtoList().isEmpty())
        {
            seans=seansRepository.save(new SeansEntity(etkinlikEkleDto.getSeansEkleDtoList().getLast().getTarih()));
            etkinlikSalonSeansRepository.save(new EtkinlikSalonSeansEntity(etkinlik,salon,seans));
            etkinlikEkleDto.getSeansEkleDtoList().removeLast();
        }

        return true;
    }

    public boolean etkinlikGuncelle(Long orgId,Long etkinlikId,EtkinlikEkleDto etkinlikEkleDto){
        OrganizatorEntity organizator=organizatorRepository.findByOrganizatorID(orgId);
        EtkinlikEntity etkinlik=etkinlikRepository.findByEtkinlikID(etkinlikId);

        if (!etkinlik.getOrganizator().equals(organizator))
        {
            return false;
        }

        List<EtkinlikSalonSeansEntity> etkinlikSalonSeansEntityList=etkinlikSalonSeansRepository.findEtkinlikSalonSeansEntitiesByEtkinlik(etkinlik);
        List<SeansEntity> seansEntityList;

        while ()
        {
            seansEntityList=etkinlikSalonSeansEntityList.getLast().getSeans();
        }

        etkinlik.setBiletFiyati(etkinlikEkleDto.getBiletFiyati());
        etkinlik.setEtkinlikAdi(etkinlikEkleDto.getEtkinlikAdi());
        etkinlik.setEtkinlikTur(etkinlikEkleDto.getEtkinlikTur());
        etkinlik.setSehir(etkinlikEkleDto.getSehir());
        etkinlik.setEtkinlikAciklamasi(etkinlikEkleDto.getEtkinlikAciklamasi());
        etkinlik.setKapakFotografi(etkinlikEkleDto.getKapakFotografi());
        etkinlik.setEtkinlikSuresi(etkinlikEkleDto.getEtkinlikSuresi());
    }

    public boolean etkinlikSil(){

    }

    public boolean getEtkinlik(){

    }

    public List<EtkinlikForOrgDto> GetEtkinlikler(Long orgId){
        OrganizatorEntity organizator=organizatorRepository.findByOrganizatorID(orgId);
        List<EtkinlikEntity> etkinlikEntities = etkinlikRepository.findByOrganizator(organizator);
        List<EtkinlikForOrgDto> etkinlikForOrgDtoList;
        while (!etkinlikEntities.isEmpty()){

        }
    }
}
