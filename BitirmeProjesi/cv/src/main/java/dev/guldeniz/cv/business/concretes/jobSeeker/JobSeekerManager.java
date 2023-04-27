package dev.guldeniz.cv.business.concretes.jobSeeker;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import dev.guldeniz.cv.business.abstracts.IdentityValidationService;
import dev.guldeniz.cv.business.abstracts.JobSeekerService;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.responses.GetAllJobSeekerResponse;
import dev.guldeniz.cv.business.rules.JobSeekerBusinessRules;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.JobSeekerRepository;
import dev.guldeniz.cv.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService{
	
	private IdentityValidationService identityValidationService;
	private EmailService emailService;
	private JobSeekerBusinessRules jobSeekerBusinessRules;
	private JobSeekerRepository jobSeekerRepository;
	private ModelMapperService modelMapperService;


	

	@Override
	public DataResult<List<GetAllJobSeekerResponse>> getAll() {
		
		List<JobSeeker> seekers = this.jobSeekerRepository.findAll();
		
		List<GetAllJobSeekerResponse> responses = seekers.stream()
				.map(jobSeeker -> this.modelMapperService.forResponse()
				.map(jobSeeker, GetAllJobSeekerResponse.class)).collect(Collectors.toList());
		

		return new SuccessDataResult<List<GetAllJobSeekerResponse>>(
				responses,"Data Listelendi");
	}
	
	
	@Override
	public Result add(CreateJobSeekeerRequest jobSeekerRequuest) throws Exception {
		if(identityValidationService.validateIdentity(jobSeekerRequuest)) {
			System.out.println("kaydedildi");
		}else {
			throw new Exception("Hata. Mernis'ten geçemedi. Kaydolmadı!");
		}
		
		//email daha önce kaydedilmiş miydi ? 
		this.jobSeekerBusinessRules.checkIfEmailExist(jobSeekerRequuest.getEMail());
		//tc daha önce kaydedilmiş miydi ? 
		this.jobSeekerBusinessRules.checkIfNationalIdentityExists(jobSeekerRequuest.getNationalIdentity());
		//emaiil geçerli formatta mı ? 
		this.emailService.isEmailValid(jobSeekerRequuest.getEMail());
		
		//şifreleri eşledikten sonra mapleme yaparken ikinci alınan şifreyi atlamak için
		//aksi taktirde alanlar uyuşmuyor ve hata dönüyor 
		PropertyMap<CreateJobSeekeerRequest, JobSeeker> jobSeekerMap = new PropertyMap<CreateJobSeekeerRequest, JobSeeker>(){

			@Override
			protected void configure() {
				map().setPasswordHash(source.getPassword());
			}	
		};
		this.modelMapperService.forRequest().addMappings(jobSeekerMap);
		
		JobSeeker jobSeeker = this.modelMapperService.forRequest().map(jobSeekerRequuest, JobSeeker.class);
		jobSeeker.setActive(true);
		jobSeeker.setVerified(true);
		this.jobSeekerRepository.save(jobSeeker);
		return new SuccessResult("Kayıt Başarılı!");
	}

}
