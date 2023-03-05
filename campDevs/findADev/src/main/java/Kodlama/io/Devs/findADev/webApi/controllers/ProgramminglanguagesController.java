package Kodlama.io.Devs.findADev.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.findADev.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgramminglanguagesController {
	private ProgrammingLanguageService pLanguageService;

	@Autowired
	public ProgramminglanguagesController(ProgrammingLanguageService pLanguageService) {
		super();
		this.pLanguageService = pLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return pLanguageService.getAll();
	}
	

}
