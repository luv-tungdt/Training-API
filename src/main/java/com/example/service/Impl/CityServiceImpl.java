package com.example.service.Impl;

import com.example.dao.CityRepository;
import com.example.model.TblCity;
import com.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepo;
    @Override
    public List<TblCity> searchCityByPrefectureCode(String prefectureCode) {
        return cityRepo.searchCityByPrefectureCode(prefectureCode);
    }
}
