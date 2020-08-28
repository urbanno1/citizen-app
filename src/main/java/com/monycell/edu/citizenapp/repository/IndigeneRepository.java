package com.monycell.edu.citizenapp.repository;

import com.monycell.edu.citizenapp.model.Indigene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndigeneRepository extends JpaRepository<Indigene, Long> {
}
