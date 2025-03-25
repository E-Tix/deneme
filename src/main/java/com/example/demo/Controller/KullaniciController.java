package com.example.demo.Controller;

import com.example.demo.Entity.KullaniciEntity;
import com.example.demo.Service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class KullaniciController {
    @Autowired
    KullaniciService kullaniciService;

    @PostMapping
    public boolean add(@RequestBody KullaniciEntity kullanici)
    {
        return kullaniciService.kullaniciEkle(kullanici);

    }
}
