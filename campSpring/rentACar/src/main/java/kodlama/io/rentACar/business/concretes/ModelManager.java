package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository modelRepository;
	private ModelMapperService modelMapper;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelsResponse> response = models.stream()
				.map(model -> this.modelMapper.forResponse().map(models, GetAllModelsResponse.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateModelRequest createRequest) {
		Model model = this.modelMapper.forRequest().map(createRequest, Model.class);
		this.modelRepository.save(model);
	}

}
