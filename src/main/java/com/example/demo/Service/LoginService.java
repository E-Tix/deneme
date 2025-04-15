package com.example.demo.Service;

import com.example.demo.Dto.Request.LoginDto;
import com.example.demo.Dto.Request.OrgLoginDto;
import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Entity.OrganizatorEntity;
import com.example.demo.Repository.KullaniciRepository;
import com.example.demo.Repository.OrganizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class LoginService {
    private KullaniciRepository kullaniciRepository;
    private OrganizatorRepository organizatorRepository;
    private JWTService jwtService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(KullaniciRepository kullaniciRepository, OrganizatorRepository organizatorRepository, JWTService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.kullaniciRepository = kullaniciRepository;
        this.organizatorRepository = organizatorRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginDto loginDto) {
        KullaniciEntity kullanici = kullaniciRepository.findByKullaniciAdi(loginDto.getKullaniciAdi());

        if (kullanici != null && passwordEncoder.matches(loginDto.getSifre(), kullanici.getSifre())) {
            return jwtService.generateToken(kullanici);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Kullanıcı girişi başarısız");
        }
    }

    public String login(OrgLoginDto orgLoginDto) {
        OrganizatorEntity organizator = organizatorRepository.findByEmail(orgLoginDto.getEmail());

        if (organizator != null && passwordEncoder.matches(orgLoginDto.getSifre(), organizator.getSifre())) {
            return jwtService.generateToken(organizator);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Organizatör girişi başarısız");
        }
    }
}
