package Kodlama.io.Devs.findADev.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.findADev.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.findADev.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class ProgramminglanguagesController {
	private ProgrammingLanguageService pLanguageService;
	//createRequest burada api isteklerini class giysisine büründürdüğümüz nokta işte

	@Autowired
	public ProgramminglanguagesController(ProgrammingLanguageService pLanguageService) {
		super();
		this.pLanguageService = pLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return pLanguageService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetAllLanguagesResponse getById(CreateProgrammingLanguageRequest createRequest) {
		return this.pLanguageService.getById(createRequest.getId());
	}
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createRequest) throws Exception {
		this.pLanguageService.add(createRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteRequest) throws Exception {
		this.pLanguageService.delete(deleteRequest);
	}
	
	@PatchMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateRequest) throws Exception {
		this.pLanguageService.update(updateRequest);
	}
}