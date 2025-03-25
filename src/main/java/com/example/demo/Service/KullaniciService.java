package com.example.demo.Service;

import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Repository.BiletRepository;
import com.example.demo.Repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KullaniciService {

    @Autowired
    KullaniciRepository kullaniciRepo;

    @Autowired
    BiletRepository biletRepo;

    public boolean kullaniciEkle(KullaniciEntity kullanici)
    {
        kullaniciRepo.save(kullanici);
        return true;
    }
}
