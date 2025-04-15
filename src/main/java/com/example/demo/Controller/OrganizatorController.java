package com.example.demo.Controller;

import com.example.demo.Dto.Request.ChangePasswordDto;
import com.example.demo.Dto.Request.OrganizatorProfiliDto;
import com.example.demo.Dto.Request.OrganizatorProfiliDuzenleDto;
import com.example.demo.Service.OrganizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orgProfile")
public class OrganizatorController {

    private final OrganizatorService organizatorService;

    @Autowired
    public OrganizatorController(OrganizatorService organizatorService) {
        this.organizatorService = organizatorService;
    }

    @PostMapping("/ChangePassword")
    public boolean changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        Long id = getCurrentOrganizatorId();
        return organizatorService.changePassword(changePasswordDto, id);
    }

    @GetMapping("/getOrganizatorProfile")
    public OrganizatorProfiliDto getOrganizatorProfili() {
        Long id = getCurrentOrganizatorId();
        return organizatorService.getOrganizatorProfili(id);
    }

    @PutMapping("/updateOrganizatorInfo")
    public boolean organizatorProfiliDuzenle(@RequestBody OrganizatorProfiliDuzenleDto organizatorProfiliDuzenleDto) {
        Long id = getCurrentOrganizatorId();
        return organizatorService.organizatorProfiliDuzenle(organizatorProfiliDuzenleDto, id);
    }

    // JWT ya da Session'dan organizatör ID'sini çeker
    private Long getCurrentOrganizatorId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            throw new RuntimeException("Kullanıcı doğrulanmamış");
        }

        String username = auth.getName(); // JWT'deki username
        return organizatorService.findOrganizatorIDByUsername(username); // Serviste bu metod tanımlı olmalı
    }
}
