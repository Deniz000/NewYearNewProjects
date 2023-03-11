package Kodlama.io.Devs.findADev.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.findADev.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{
	//Yine jpa aradaki select vs komutlarını yazmadan veri kaydetmemizi sağlıyor 
	

}
