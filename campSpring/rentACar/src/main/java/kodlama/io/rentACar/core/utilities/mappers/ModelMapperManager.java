package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service //Ioc 'ye yerleşsin
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

	private ModelMapper modelMapper;
	
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this.modelMapper;
		//gevşek mapleme yap: Veritabanında diyelim ki 
		//id name x y z bir sürü alan içerisinden 
		//ör sadece name x y varsa bunları maple
		//diğerleeeri kalsın = LOOSE
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)//belirsizlik olunca onu ignore et
		.setPropertyCondition(Conditions.isNotNull())
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		//ben request aldığımda her şey maplensin 
		//her şeyin bir karşılığı olsun yoksa kız.
		
		return this.modelMapper;
	}
}
