package Kodlama.io.Devs.findADev.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.findADev.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.findADev.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.requests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.findADev.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.findADev.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.findADev.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.findADev.entities.concretes.ProgrammingLanguage;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository pLanguageRepository;
	private ModelMapperService modelMapper;


	@Override
	public List<GetAllLanguagesResponse> getAll() {		
		List<ProgrammingLanguage> pLanguages = pLanguageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse =  pLanguages.stream()
				.map(language -> this.modelMapper.forResponse().map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
		return languagesResponse;
	}

	@Override
	public GetAllLanguagesResponse getById(int id) {
		ProgrammingLanguage languageRequest = this.pLanguageRepository.findById(id).orElseThrow();
		GetAllLanguagesResponse getId = this.modelMapper.forResponse().map(languageRequest, GetAllLanguagesResponse.class);
		return getId;
	}

	@Override
	public void add(@RequestBody CreateProgrammingLanguageRequest createRequest) throws Exception {
		ProgrammingLanguage language = this.modelMapper.forRequest().map(createRequest, ProgrammingLanguage.class);
		this.pLanguageRepository.save(language);
	}
	
	 
	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteRequest) throws Exception {
		ProgrammingLanguage language = this.modelMapper.forRequest().map(deleteRequest, ProgrammingLanguage.class);
		this.pLanguageRepository.delete(language);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateRequest) throws Exception {
		ProgrammingLanguage language = this.modelMapper.forRequest().map(updateRequest, ProgrammingLanguage.class);
		this.pLanguageRepository.save(language);		
	}
}