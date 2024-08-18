package com.egov.service;

import com.egov.dto.WomenSchemeDto;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import com.egov.entity.User;
import com.egov.entity.WomenScheme;
import com.egov.repository.SchemeRepository;
import com.egov.repository.UserRepository;
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


    private WomenRepository womenrepository;
    private final UserRepository userRepository;
    private final SchemeRepository schemeRepository;
    private final ModelMapper modelMapper;

    //Dependency injection
    @Autowired
    public WomenServiceImpl(WomenRepository womenrepository, UserRepository userRepository,
                            SchemeRepository schemeRepository, ModelMapper modelMapper) {
        this.womenrepository = womenrepository;
        this.userRepository = userRepository;
        this.schemeRepository = schemeRepository;
        this.modelMapper = modelMapper;
    }


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
    public WomenSchemeDto addNewWomenData(Integer userId, Integer schemeId, WomenSchemeDto womenDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        SchemeMaster schemeMaster = schemeRepository.findById(schemeId).orElseThrow(() -> new RuntimeException("scheme not found with id: " + schemeId));

        WomenScheme womenEntity = modelMapper.map(womenDto, WomenScheme.class);
        womenEntity.setUserId(user);
        womenEntity.setSchemeMaster(schemeMaster);
        WomenScheme womensaveddata = womenrepository.save(womenEntity);
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
    public String updateStatus(Integer applicationId, Status status, String comments) {

        try {
            WomenScheme womenScheme = womenrepository.findById(applicationId)
                    .orElseThrow(() -> new RuntimeException("Women not found with id: " + applicationId));

            womenScheme.setStatus(status);
            womenScheme.setComments(comments);

            womenrepository.save(womenScheme);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to change status: " + applicationId);
        }

        return "Successfully change the status to " + status;
    }


    @Override
    public List<WomenSchemeDto> getWomenDataByName(String data) {
        return null;

    }
}
