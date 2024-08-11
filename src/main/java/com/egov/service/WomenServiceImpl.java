package com.egov.service;

import com.egov.dto.WomenSchemeDto;
import com.egov.entity.WomenScheme;
import com.egov.repository.WomenRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WomenServiceImpl implements IWomenService {

    //Dependency Injection
    @Autowired
    private WomenRepository womenrepository;

    //to map Dto to entity or vice versa...
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<WomenSchemeDto> getAllWomensData() {

        List<WomenScheme> womenEntities = womenrepository.findAll();
        Type listType = new TypeToken<List<WomenSchemeDto>>() {
        }.getType();
        List<WomenSchemeDto> womendata = modelMapper.map(womenEntities, listType);

        return womendata;
    }

    @Override
    public WomenSchemeDto updateWomenDataDetails(Integer id, WomenSchemeDto womenDto) {

        WomenScheme existingData = womenrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Women not found with id: " + id));

        modelMapper.map(womenDto, existingData);

        WomenScheme updatedData = womenrepository.save(existingData);
        return modelMapper.map(updatedData, WomenSchemeDto.class);

    }

    @Override
    public WomenSchemeDto addNewWomenData(WomenSchemeDto womenDto) {
        WomenScheme womenentity = modelMapper.map(womenDto, WomenScheme.class);
        WomenScheme womensaveddata = womenrepository.save(womenentity);
        WomenSchemeDto womendata = modelMapper.map(womensaveddata, WomenSchemeDto.class);
        return womendata;
    }


    @Override
    public WomenSchemeDto getWomenDataById(Integer id) {

        WomenScheme womenEntity = womenrepository.findById(id).orElseThrow(() -> new RuntimeException("WomenDto cannot be null"));

        Optional<WomenScheme> womenentity = womenrepository.findById(id);

        WomenSchemeDto womendata = modelMapper.map(womenentity, WomenSchemeDto.class);

        return womendata;

    }


    @Override
    public void deleteWomendataById(Integer id) {
        womenrepository.findById(id).orElseThrow(() -> new RuntimeException("Women not found with id: " + id));

        womenrepository.deleteById(id);
    }


    @Override
    public List<WomenSchemeDto> getWomenDataByName(String data) {
        return null;

    }
}
