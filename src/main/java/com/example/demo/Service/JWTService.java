package com.example.demo.Service;

import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Entity.OrganizatorEntity;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken(KullaniciEntity kullanici)
    {
        return "token";
    }
    public String generateToken(OrganizatorEntity organizator){return "token";}
}
