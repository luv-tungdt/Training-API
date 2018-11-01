package com.example.service.Impl;

import com.example.dao.CityRepository;
import com.example.model.TblCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepo;
	
	
	public List<TblCity> searchCityByPrefectureCode(String prefectureCode) {
		return cityRepo.searchCityByPrefectureCode(prefectureCode);
	}
}
