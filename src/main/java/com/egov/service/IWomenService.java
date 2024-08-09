package com.egov.service;

import java.util.List;

import com.egov.dto.WomenDto;

public interface IWomenService {

   List<WomenDto> getAllWomensData();
   WomenDto addNewWomenData(WomenDto womendto);
   WomenDto getWomenDataById(Integer id);
   WomenDto updateWomenDataDetails(Integer id, WomenDto womenDto);
   List<WomenDto> getWomenDataByName(String data);

}
