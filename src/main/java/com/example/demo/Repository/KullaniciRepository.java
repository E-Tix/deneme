package com.example.demo.Repository;

import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Entity.SehirEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KullaniciRepository extends JpaRepository<KullaniciEntity,Long> {
    KullaniciEntity findByKullaniciID(Long kullaniciID);
    Optional<KullaniciEntity>findBySehir(SehirEntity sehir);
    KullaniciEntity findByKullaniciAdiAndSifre(String kullaniciAdi,String sifre);
    Optional<KullaniciEntity>findByEmail(String email);
    Optional<KullaniciEntity> findByKullaniciAdi(String kullaniciAdi);
    Long getUserIdByKullaniciAdi(String username);
}
