package dev.guldeniz.cv.business.concretes.jobSeeker;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.business.abstracts.jobSeeker.CandidateService;
import dev.guldeniz.cv.business.dtos.requests.CreateCandidateRequest;
import dev.guldeniz.cv.business.dtos.responses.CandidateResponse;
import dev.guldeniz.cv.core.mappers.ModelMapperService;
import dev.guldeniz.cv.core.results.DataResult;
import dev.guldeniz.cv.core.results.Result;
import dev.guldeniz.cv.core.results.SuccessDataResult;
import dev.guldeniz.cv.core.results.SuccessResult;
import dev.guldeniz.cv.dataAccess.abstracts.CandidateRepositroy;
import dev.guldeniz.cv.entities.concretes.jobSeeker.Candidate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateManager implements CandidateService{

	private CandidateRepositroy candidateRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateCandidateRequest candaidateRequest) {
		Candidate candidate = this.modelMapperService.forRequest().map(candaidateRequest, Candidate.class);
		this.candidateRepository.save(candidate);
		return new SuccessResult("Okayy");
	}

	@Override
	public DataResult<List<CandidateResponse>> getAll() {
		List<Candidate> candidates = this.candidateRepository.findAll();
		List<CandidateResponse> responses = candidates.stream()
				.map(c -> this.modelMapperService.forResponse()
						.map(c, CandidateResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<CandidateResponse>>(responses, "Listelendi");
	}
}
