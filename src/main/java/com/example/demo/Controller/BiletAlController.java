package com.example.demo.Controller;

import com.example.demo.Dto.Request.BiletAlDto;
import com.example.demo.Service.BiletAlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biletAl")
public class BiletAlController {
    private final BiletAlService biletAlService;

    @Autowired
    public BiletAlController(BiletAlService biletAlService)
    {
        this.biletAlService=biletAlService;
    }


    @PostMapping("/")
    public boolean biletAl(@RequestBody BiletAlDto biletAlDto)
    {
        return biletAlService.biletAl(biletAlDto);
    }
}
