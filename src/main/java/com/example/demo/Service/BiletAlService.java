package com.example.demo.Service;

import com.example.demo.Dto.BiletAlDto;
import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiletAlService {

    BiletRepository biletRepository;
    KullaniciRepository kullaniciRepository;
    KullaniciBiletRepository kullaniciBiletRepository;
    SeansRepository seansRepository;
    KoltukRepository koltukRepository;
    SeansKoltukBiletRepository seansKoltukBiletRepository;
    SatinAlService satinAlService;

    @Autowired
    public BiletAlService(SatinAlService satinAlService,KoltukRepository koltukRepository,SeansRepository seansRepository,BiletRepository biletRepository, KullaniciRepository kullaniciRepository, KullaniciBiletRepository kullaniciBiletRepository, SeansKoltukBiletRepository seansKoltukBiletRepository) {
        this.satinAlService=satinAlService;
        this.biletRepository = biletRepository;
        this.kullaniciRepository = kullaniciRepository;
        this.kullaniciBiletRepository = kullaniciBiletRepository;
        this.seansKoltukBiletRepository = seansKoltukBiletRepository;
        this.seansRepository = seansRepository;
        this.koltukRepository = koltukRepository;
    }

    @Transactional
    public boolean biletAl(BiletAlDto biletAlDto){

        BiletEntity bilet = biletRepository.save(new BiletEntity(biletAlDto.isOdendiMi(),biletAlDto.getOdenenMiktar()));
        KullaniciEntity kullanici = kullaniciRepository.findByKullaniciID(biletAlDto.getKullaniciId());

        kullaniciBiletRepository.save(new KullaniciBiletEntity(kullanici,bilet));

        SeansEntity seans = seansRepository.findBySeansID(biletAlDto.getSeansId());
        KoltukEntity koltuk = koltukRepository.findByKoltukID(biletAlDto.getKoltukId());

        seansKoltukBiletRepository.save(new SeansKoltukBiletEntity(seans,koltuk,bilet,"Satın Alınmış"));

        satinAlService.satinAl();//transactionaldan dolayı sorun çıkabilir.

        return true;
    }
}
