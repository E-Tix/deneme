package com.example.demo.Service;

import com.example.demo.Dto.OrgSignUpDto;
import com.example.demo.Dto.SignUpDto;
import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Entity.OrganizatorEntity;
import com.example.demo.Repository.KullaniciRepository;
import com.example.demo.Repository.OrganizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    KullaniciRepository kullaniciRepository;
    OrganizatorRepository organizatorRepository;
    JWTService jwtService;

    @Autowired
    SignUpService (KullaniciRepository kullaniciRepository,OrganizatorRepository organizatorRepository,JWTService jwtService)
    {
        this.kullaniciRepository=kullaniciRepository;
        this.organizatorRepository=organizatorRepository;
        this.jwtService=jwtService;
    }

    public String signUp(SignUpDto signUpDto){

        KullaniciEntity kullanici = kullaniciRepository.save(new KullaniciEntity(signUpDto.getKullaniciAdi(),signUpDto.getAdSoyad(),signUpDto.getSifre(),signUpDto.getEmail(),signUpDto.getTelNo()));
        return jwtService.generateToken(kullanici);

    }

    public String signUp(OrgSignUpDto orgSignUpDto)
    {
        OrganizatorEntity organizator=organizatorRepository.save(new OrganizatorEntity(orgSignUpDto.getAdSoyad(), orgSignUpDto.getVergiNo(), orgSignUpDto.getEmail(), orgSignUpDto.getSifre(), orgSignUpDto.getIban(), orgSignUpDto.getSirketAdresi(), orgSignUpDto.getTckNo(), orgSignUpDto.getTelefonNumarasi()));
        return jwtService.generateToken(organizator);
    }
}
