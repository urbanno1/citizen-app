package com.monycell.edu.citizenapp.service;

import com.monycell.edu.citizenapp.model.Indigene;

import java.util.List;

public interface IndigeneService {
    public List<Indigene> indigeneList() throws Exception;
    public Indigene get(Long indigeneId);
    public Indigene addIndigene(Indigene indigene);
}
