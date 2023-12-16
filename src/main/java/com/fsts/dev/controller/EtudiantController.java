package com.fsts.dev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsts.dev.entites.Etudiant;
import com.fsts.dev.repository.EtudiantRepository;

@RestController
//@RequestMapping("etudiant")
public class EtudiantController {
	
	@Autowired
	EtudiantRepository etudiantrepository ;
	
	
	@GetMapping("hello")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("addition/{x}/{y}")
	public int addition(@PathVariable int x , @PathVariable int y)
	{
		return x+y;
	}
	
	@PostMapping("createEtudiant")
	public Etudiant save(@RequestBody Etudiant etudiant)
	{
		return etudiantrepository.save(etudiant);
	}
	
	@GetMapping("allEtudiant")
	public List<Etudiant> listEtudiant()
	{
		return etudiantrepository.findAll();
	}
	
	@PutMapping("updateEtudiant")
	public Etudiant update(@RequestBody Etudiant etudiant)
	{
		Optional<Etudiant> optional =  etudiantrepository.findById(etudiant.getId());
		if(optional.isEmpty())
			return null;
		return etudiantrepository.save(etudiant);
	}
	
	@DeleteMapping("deleteEtudiant/{id}")
	public void delete(@PathVariable int id)
	{
		etudiantrepository.deleteById(id);
	}
}
