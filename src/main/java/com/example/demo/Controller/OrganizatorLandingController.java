package com.example.demo.Controller;

import com.example.demo.Dto.Request.EtkinlikEkleDto;
import com.example.demo.Dto.Request.EtkinlikGuncelleDto;
import com.example.demo.Entity.EtkinlikTurEntity;
import com.example.demo.Service.OrganizatorLandingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizatorMainPage")
public class OrganizatorLandingController {
    private OrganizatorLandingService organizatorLandingService;

    public OrganizatorLandingController(OrganizatorLandingService organizatorLandingService)
    {
        this.organizatorLandingService=organizatorLandingService;
    }

    @PostMapping("/addEvent/save")
    public boolean etkinlikEkle(@RequestBody EtkinlikEkleDto etkinlikEkleDto){
        //orgid changePassworddaki gibi alınacak
        Long id= Long.valueOf(1);
        return organizatorLandingService.etkinlikEkle(etkinlikEkleDto,id);
    }

    @GetMapping("/addEvent")
    public List<EtkinlikTurEntity> getEtkinlikTursForAddEvent(){
        return organizatorLandingService.getEtkinlikTursAndSalonsForAddAndUpdateEvent();
    }

    @GetMapping("/updateEvent")
    public boolean etkinlikGuncelle(EtkinlikGuncelleDto etkinlikGuncelleDto){
        Long orgId= Long.valueOf(1);
        return organizatorLandingService.etkinlikGuncelle(orgId,etkinlikGuncelleDto);

    }

    @PutMapping("/updateEvent/save")
    public boolean etkinlikGuncelle(@RequestBody EtkinlikGuncelleDto etkinlikGuncelleDto){
        //orgid changePassworddaki gibi alınacak
        Long orgId= Long.valueOf(1);
        return organizatorLandingService.etkinlikGuncelle(orgId,eventId,etkinlikEkleDto);

    }

    @DeleteMapping("/deleteEvent/{eventId}")
    public boolean etkinlikSil(@PathVariable Long eventId)//pathten id alma dtodan al
    {
        //orgid changePassworddaki gibi alınacak

        organizatorLandingService.etkinlikSil();
    }

    @GetMapping("/getEtkinlik/{eventId}")
    public boolean getEtkinlik(@PathVariable Long eventId)
    {
        //orgid changePassworddaki gibi alınacak
        organizatorLandingService.getEtkinlik();
    }

    @GetMapping("/")
    public boolean getEtkinlikler()
    {
        //orgid changePassworddaki gibi alınacak
        organizatorLandingService.GetEtkinlikler();
    }
}
