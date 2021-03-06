package com.example.dao;

import com.example.model.TblCity;

import java.util.List;

public interface CityRepository {
	
	/**
	 * get City information by prefectureCode
	 *
	 * @param   prefectureCode prefecture code
	 * @return TblCity
	 */
	List<TblCity> searchCityByPrefectureCode(String prefectureCode);
	
}
