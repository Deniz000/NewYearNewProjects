package Kodlama.io.Devs.findADev.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.findADev.business.abstracts.TechnologyService;
import Kodlama.io.Devs.findADev.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> geAll(){
		return technologyService.getAll();
	}	
	
	@GetMapping("/getbyid/{id}")
	public GetAllTechnologiesResponse createRequest(int id) {
		return technologyService.getById(id);
	}
	
	@PostMapping("add")
	public void add(CreateTechnologyRequest cRequest) throws Exception {
		this.technologyService.add(cRequest);
	} 
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteRequest) throws Exception{
		this.technologyService.delete(deleteRequest);
	}
}
