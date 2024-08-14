package com.egov.service;

import com.egov.dto.WomenSchemeDto;

import java.util.List;

public interface IWomenService {

    List<WomenSchemeDto> getAllWomensData();

    WomenSchemeDto addNewWomenData(Integer userId,Integer schemeId, WomenSchemeDto womendto);

    WomenSchemeDto getWomenDataById(Integer id);

    WomenSchemeDto updateWomenDataDetails(Integer id, WomenSchemeDto womenDto);

    List<WomenSchemeDto> getWomenDataByName(String data);

    void deleteWomendataById(Integer id);
}
