package com.example.demo.Service;

import com.example.demo.Repository.OrganizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizatorService {
    private OrganizatorRepository organizatorRepository;

    @Autowired
    public OrganizatorService(OrganizatorRepository organizatorRepository)
    {
        this.organizatorRepository=organizatorRepository;
    }

    public void updateOrganizatorInfo(){}
}
