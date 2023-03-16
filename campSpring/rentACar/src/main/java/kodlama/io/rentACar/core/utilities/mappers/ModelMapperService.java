package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
//Straji oluşturmak için var 
	//veritabanından gelen her şeyi map etmek zorunda değilim

	ModelMapper forResponse();
	ModelMapper forRequest();
}
