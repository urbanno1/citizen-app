package com.monycell.edu.citizenapp.serviceImpl;

import com.monycell.edu.citizenapp.model.Indigene;
import com.monycell.edu.citizenapp.repository.IndigeneRepository;
import com.monycell.edu.citizenapp.service.IndigeneService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IndigeneServiceImp implements IndigeneService {
    private IndigeneRepository indigeneRepository;

    public IndigeneServiceImp(IndigeneRepository indigeneRepository) {
        this.indigeneRepository = indigeneRepository;
    }

    @Override
    public List<Indigene> indigeneList() throws Exception {
        try {
            return indigeneRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Indigene get(Long indigeneId) {
        return null;
    }

    @Override
    public Indigene addIndigene(Indigene indigene) {
        return indigeneRepository.save(indigene);
    }
}
