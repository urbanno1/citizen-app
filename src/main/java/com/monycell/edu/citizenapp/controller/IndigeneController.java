package com.monycell.edu.citizenapp.controller;

import com.monycell.edu.citizenapp.exception.Adress1NotProvidedException;
import com.monycell.edu.citizenapp.model.Indigene;
import com.monycell.edu.citizenapp.service.IndigeneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndigeneController {
    private IndigeneService indigeneService;

    public IndigeneController(IndigeneService indigeneService) {
        this.indigeneService = indigeneService;
    }

    @GetMapping("/all")
    public ResponseEntity getIndigeneList() {
        try {
            return new ResponseEntity(indigeneService.indigeneList(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Indigene> addIndigene(@RequestBody Indigene indigene) throws Adress1NotProvidedException {
        if(indigene.getAddress().getAddress1().isEmpty() || indigene.getAddress().getAddress1() == null) {
            throw new Adress1NotProvidedException("Home Address can't be empty");
        }
        return new ResponseEntity(indigeneService.addIndigene(indigene), HttpStatus.CREATED);
    }



}
