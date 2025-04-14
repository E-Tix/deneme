package com.example.demo.Controller;

import com.example.demo.Entity.EtkinlikEntity;
import com.example.demo.Service.LandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/landing")
public class LandingController {
    private LandingService landingService;

    @Autowired
    public LandingController(LandingService landingService)
    {
        this.landingService=landingService;
    }

    @GetMapping("/")
    public List<EtkinlikEntity> getEtkinlik(
            @RequestParam(required = false) String etkinlikTurAdi,
            @RequestParam(required = false) String sehirAdi
    ){
        return landingService.getEtkinlik(etkinlikTurAdi,sehirAdi).subList(0,4);//ilk 5 etkinliği döndürür
    }

}
