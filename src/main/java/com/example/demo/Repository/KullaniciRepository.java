package com.example.demo.Repository;

import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Entity.SeansEntity;
import com.example.demo.Entity.SehirEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KullaniciRepository extends JpaRepository<KullaniciEntity,Long> {
    Optional<KullaniciEntity>findByKullaniciID(Long kullaniciID);
    Optional<KullaniciEntity>findBySehir(SehirEntity sehir);
    Optional<KullaniciEntity>findByKullaniciAdi(String kullaniciAdi);
    Optional<KullaniciEntity>findBySifre(String sifre);
    Optional<KullaniciEntity>findByEmail(String email);


}
