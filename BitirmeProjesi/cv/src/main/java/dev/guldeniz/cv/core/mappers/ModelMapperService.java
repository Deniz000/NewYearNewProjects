package dev.guldeniz.cv.core.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ModelMapperService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();

}
 