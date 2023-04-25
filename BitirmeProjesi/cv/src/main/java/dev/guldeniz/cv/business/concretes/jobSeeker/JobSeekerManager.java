package dev.guldeniz.cv.business.concretes.jobSeeker;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.EmailService;
import dev.guldeniz.cv.business.abstracts.IdentityValidationService;
import dev.guldeniz.cv.business.abstracts.JobSeekerService;
import dev.guldeniz.cv.business.requests.CreateJobSeekeerRequest;
import dev.guldeniz.cv.business.responses.GetAllJobSeekerResponse;
import dev.guldeniz.cv.business.rules.JobSeekerBusinessRules;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
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
	public List<GetAllJobSeekerResponse> getAll() {
		
		List<JobSeeker> seekers = this.jobSeekerRepository.findAll();
		
		List<GetAllJobSeekerResponse> responses = seekers.stream()
				.map(jobSeeker -> this.modelMapperService.forResponse()
				.map(jobSeeker, GetAllJobSeekerResponse.class)).collect(Collectors.toList());
		

		return responses;
	}
	
	
	@Override
	public void add(CreateJobSeekeerRequest jobSeekerRequuest) throws Exception {
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
		
		JobSeeker jobSeeker = this.modelMapperService.forRequest().map(jobSeekerRequuest, JobSeeker.class);
		jobSeeker.setActive(true);
		jobSeeker.setVerified(true);
		this.jobSeekerRepository.save(jobSeeker);
		
	}

}
