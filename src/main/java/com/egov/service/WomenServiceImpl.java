package com.egov.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egov.dto.WomenDto;
import com.egov.entity.Women;
import java.lang.reflect.Type;

import com.egov.repository.UserRepository;
import com.egov.repository.WomenRepository;
@Service
public class WomenServiceImpl implements IWomenService {

   //Dependency Injection 
   @Autowired
   private WomenRepository womenrepository; 
   
    //to map Dto to entity or vice versa...
  ModelMapper modelMapper=new ModelMapper();

@Override
public List<WomenDto> getAllWomensData() {
   
    List<Women> womenEntities = womenrepository.findAll();
   Type listType = new TypeToken<List<WomenDto>>(){}.getType();
   List<WomenDto> womendata = modelMapper.map(womenEntities, listType);
   
   return womendata;
}




@Override
public WomenDto addNewWomenData(WomenDto womenDto) {


   Women womenentity=modelMapper.map(womenDto, Women.class);  
    Women womensaveddata=womenrepository.save(womenentity);
    WomenDto womendata=modelMapper.map(womensaveddata,WomenDto.class);
 return womendata;
}




@Override
public WomenDto getWomenDataById(Integer id) {
   
   Optional<Women> womenentity=womenrepository.findById(id);

   WomenDto womendata=modelMapper.map(womenentity,WomenDto.class);
   return womendata;
}




@Override
public WomenDto updateWomenDataDetails(Integer id, WomenDto womenDto) {
   
   Optional<Women> women=womenrepository.findById(id);
   Women existingData=women.orElseThrow();
   Women  newData=modelMapper.map(womenDto,Women.class);
   existingData.setName(newData.getName());
   existingData.setAddress(newData.getAddress());
   existingData.setAge(newData.getAge());
   existingData.setAnnualIncome(newData.getAnnualIncome());
   existingData.setDOB(newData.getDOB());
   existingData.setMaritialStatus(newData.getMaritialStatus());
   existingData.setOccupation(newData.getOccupation());
   existingData.setPhoneNumber(newData.getPhoneNumber());
   existingData.setSchemeMaster(newData.getSchemeMaster());
   
     womenrepository.save(existingData);
      return womenDto;
}



@Override
public List<WomenDto> getWomenDataByName(String data) {
	return null;
}



}
