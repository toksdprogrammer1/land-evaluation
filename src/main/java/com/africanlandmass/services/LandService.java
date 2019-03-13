package com.africanlandmass.services;

import com.africanlandmass.Model.Land;
import com.africanlandmass.Model.UploadFile;
import com.africanlandmass.Repository.LandRepository;
import com.africanlandmass.Repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandService {

    @Autowired
    private LandRepository landRepository;

    @Autowired
    private UploadFileRepository uploadFileRepository;


    public Land saveLand(Land land){

        int i =0;
        for (UploadFile file: land.getUploadedFile()){
            land.getUploadedFile().get(i).setId(uploadFileRepository.save(file).getId());
            i++;
        }
            return landRepository.save(land);
    }



}
