package com.example.demo.Controller;

import com.example.demo.Dto.ChangePasswordDto;
import com.example.demo.Dto.KullaniciProfiliDto;
import com.example.demo.Entity.BiletEntity;
import com.example.demo.Service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Profile")
public class KullaniciController {

    private KullaniciService kullaniciService;

    @Autowired
    public KullaniciController(KullaniciService kullaniciService)
    {
        this.kullaniciService=kullaniciService;
    }

    @PostMapping("/ChangePassword")
    public boolean changePassword(ChangePasswordDto changePasswordDto)
    {

        //id spring security yardımıyla alınacak.
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        //Long userId = userDetails.getId(); // Kullanıcının ID’sini aldık

        Long id= 0L;
        return kullaniciService.changePassword(changePasswordDto,id);
    }

    @GetMapping("/getTickets")
    public List<BiletEntity> getBiletler(){

        //id changePassword ile aynı şekilde alınmalı.

        Long id= 0L;
        return kullaniciService.getBiletler(id);
    }

    @GetMapping("/getUserProfile")
    public KullaniciProfiliDto getKullaniciProfili(){
        //id changePassword ile aynı şekilde alınmalı.
        Long id= Long.valueOf(1);
        return kullaniciService.getKullaniciProfili(id);
    }

    @PutMapping("/updateUserInfo")
    public boolean kullaniciProfiliDuzenle(KullaniciProfiliDto kullaniciProfiliDto)
    {
        //id changePassword ile aynı şekilde alınmalı.
        Long id= Long.valueOf(1);
        return kullaniciService.kullaniciProfiliDuzenle(kullaniciProfiliDto,id);
    }
}
