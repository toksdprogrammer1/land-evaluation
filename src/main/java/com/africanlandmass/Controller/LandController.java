package com.africanlandmass.Controller;


import com.africanlandmass.Model.Land;
import com.africanlandmass.services.LandService;

import com.africanlandmass.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/land")
@CrossOrigin
public class LandController {

    @Autowired
    private LandService landService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewLand(@Valid @RequestBody Land land, BindingResult result){

        System.out.println(land.getUploadedFile().size());
        System.out.println(land.getUploadedFile().get(0).getFileName());
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Land landResponse = landService.saveLand(land);
        return new ResponseEntity<>(landResponse, HttpStatus.CREATED);
    }



}
