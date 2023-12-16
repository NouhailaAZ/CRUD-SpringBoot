package com.fsts.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fsts.dev.entites.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	
}
