package dev.guldeniz.cv.business.concretes.jobSeeker;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.CandidateService;
import dev.guldeniz.cv.business.dtos.requests.CreateCandidateRequest;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.CandidateRepositroy;
import dev.guldeniz.cv.entities.concretes.jobSeeker.Candidate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CandidateManager implements CandidateService{

	private CandidateRepositroy candidateRepository;
	private ModelMapperService modelMapperService;
	@Override
	public Result add(CreateCandidateRequest candaidateRequest) {
		Candidate candidate = this.modelMapperService.forRequest().map(candaidateRequest, Candidate.class);
		this.candidateRepository.save(candidate);
		return new SuccessResult("Okayy");
	}

}
