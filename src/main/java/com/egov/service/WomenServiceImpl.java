package com.egov.service;
import com.egov.entity.*;
import com.egov.dto.WomenDto;
import com.egov.entity.WomenScheme;
import com.egov.repository.WomenRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import com.egov.repository.UserRepository;
import com.egov.repository.WomenRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class WomenServiceImpl implements IWomenService {

   //Dependency Injection 
   @Autowired
   private WomenRepository womenRepository; 
   
    //to map Dto to entity or vice versa...
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<WomenDto> getAllWomensData() {
   
    List<WomenScheme> womenEntities = womenRepository.findAll();
    Type listType = new TypeToken<List<WomenDto>>(){}.getType();
    List<WomenDto> womendata = modelMapper.map(womenEntities, listType);
   
    return womendata;
   }

   @Override
public WomenDto updateWomenDataDetails(Integer id, WomenDto womenDto) {
   
	WomenScheme existingData = womenRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Women not found with id: " + id));

	    modelMapper.map(womenDto, existingData);

	    WomenScheme updatedData = womenRepository.save(existingData);
	    return modelMapper.map(updatedData, WomenDto.class);
    }


@Override
public WomenDto getWomenDataById(Integer id) {
   
  WomenScheme womenEntity=womenRepository.findById(id).orElseThrow(()-> new RuntimeException("WomenDto cannot be null"));

   return modelMapper.map(womenEntity,WomenDto.class);
}


@Override
public void deleteWomendataById(Integer id) {
	womenRepository.findById(id).orElseThrow(()-> new RuntimeException("Women not found with id: " + id)); 
		
      womenRepository.deleteById(id);
  }

@Override
public WomenDto addNewWomenData(WomenDto womenDto) {
        WomenScheme womenentity = modelMapper.map(womenDto, WomenScheme.class);
        WomenScheme womensaveddata = womenRepository.save(womenentity);
        WomenDto womendata = modelMapper.map(womensaveddata, WomenDto.class);
        return womendata;
    }
}		





