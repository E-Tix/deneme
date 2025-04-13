package com.example.demo.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.OrgLoginDto;
import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Entity.OrganizatorEntity;
import com.example.demo.Repository.KullaniciRepository;
import com.example.demo.Repository.OrganizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    KullaniciRepository kullaniciRepository;
    OrganizatorRepository organizatorRepository;
    JWTService jwtService;

    @Autowired
    public LoginService(KullaniciRepository kullaniciRepository,OrganizatorRepository organizatorRepository,JWTService jwtService){
        this.kullaniciRepository = kullaniciRepository;
        this.organizatorRepository = organizatorRepository;
        this.jwtService = jwtService;
    }

    public String login(LoginDto loginDto){

        KullaniciEntity kullanici=kullaniciRepository.findByKullaniciAdiAndSifre(loginDto.getKullaniciAdi(),loginDto.getSifre());

        if (kullanici != null){
            return jwtService.generateToken(kullanici);
        }else {
            return "user girişi başarısız";
        }

    }

    public String login(OrgLoginDto orgLoginDto)
    {
        OrganizatorEntity organizator = organizatorRepository.findByEmailAndSifre(orgLoginDto.getEmail(),orgLoginDto.getSifre());
        if (organizator != null)
        {
            return jwtService.generateToken(organizator);
        }else {
            return "org girişi başarısız.";
        }
    }
}
