package com.egov.service;

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

@Service
public class WomenServiceImpl implements IWomenService {

    //Dependency Injection
    @Autowired
    private WomenRepository womenrepository;

    //to map Dto to entity or vice versa...
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<WomenDto> getAllWomensData() {

        List<WomenScheme> womenEntities = womenrepository.findAll();
        Type listType = new TypeToken<List<WomenDto>>() {
        }.getType();
        List<WomenDto> womendata = modelMapper.map(womenEntities, listType);

        return womendata;
    }

    @Override
    public WomenDto addNewWomenData(WomenDto womenDto) {
        WomenScheme womenentity = modelMapper.map(womenDto, WomenScheme.class);
        WomenScheme womensaveddata = womenrepository.save(womenentity);
        WomenDto womendata = modelMapper.map(womensaveddata, WomenDto.class);
        return womendata;
    }


    @Override
    public WomenDto getWomenDataById(Integer id) {

        Optional<WomenScheme> womenentity = womenrepository.findById(id);

        WomenDto womendata = modelMapper.map(womenentity, WomenDto.class);
        return womendata;
    }


    @Override
    public WomenDto updateWomenDataDetails(Integer id, WomenDto womenDto) {

        Optional<WomenScheme> women = womenrepository.findById(id);
        WomenScheme existingData = women.orElseThrow();
        WomenScheme newData = modelMapper.map(womenDto, WomenScheme.class);
        existingData.setAddress(newData.getAddress());
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
