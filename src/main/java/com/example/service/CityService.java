package com.example.service;

import com.example.model.TblCity;

import java.util.List;

public interface CityService {
	
	/**
	 * get City information by prefectureCode
	 *
	 * @param   prefectureCode prefecture code
	 * @return TblCity
	 */
	List<TblCity> searchCityByPrefectureCode(String prefectureCode);
	
}
