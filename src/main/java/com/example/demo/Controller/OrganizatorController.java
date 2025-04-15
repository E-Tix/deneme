package com.example.demo.Controller;

import com.example.demo.Dto.Request.ChangePasswordDto;
import com.example.demo.Dto.Request.EtkinlikEkleDto;
import com.example.demo.Dto.KullaniciProfiliDto;
import com.example.demo.Dto.Request.OrganizatorProfiliDto;
import com.example.demo.Dto.Request.OrganizatorProfiliDuzenleDto;
import com.example.demo.Service.OrganizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orgProfile")
public class OrganizatorController {
    private OrganizatorService organizatorService;

    @Autowired
    public OrganizatorController(OrganizatorService organizatorService)
    {
        this.organizatorService=organizatorService;
    }

    @PostMapping("/ChangePassword")
    public boolean changePassword(@RequestBody ChangePasswordDto changePasswordDto)
    {

        //id spring security yardımıyla alınacak.
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        //Long userId = userDetails.getId(); // Kullanıcının ID’sini aldık

        Long id= 0L;
        return organizatorService.changePassword(changePasswordDto,id);
    }

    @GetMapping("/getOrganizatorProfile")
    public OrganizatorProfiliDto getOrganizatorProfili(){
        //id changePassword ile aynı şekilde alınmalı.
        Long id= Long.valueOf(1);
        return organizatorService.getOrganizatorProfili(id);
    }

    @PutMapping("/updateOrganizatorInfo")
    public boolean organizatorProfiliDuzenle(@RequestBody OrganizatorProfiliDuzenleDto organizatorProfiliDuzenleDto)
    {
        //id changePassword ile aynı şekilde alınmalı.
        Long id= Long.valueOf(1);
        return organizatorService.organizatorProfiliDuzenle(organizatorProfiliDuzenleDto,id);
    }
}
