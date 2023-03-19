package Kodlama.io.Devs.findADev.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

	private ModelMapper modelMApper;
	
	@Override
	public ModelMapper forResponse() {
		this.modelMApper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMApper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMApper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMApper;
	}

}
