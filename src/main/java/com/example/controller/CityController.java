package com.example.controller;

import com.example.utils.Common;
import com.example.utils.Constant;
import com.example.utils.ResponseError;
import com.example.utils.RestData;
import com.example.model.TblCity;
import com.example.model.response.SearchByPrefectureCodeResponse;
import com.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {
	
	@Autowired
	CityService cityService;
	
	
	/**
	 * Handles data from view
	 *
	 * @param prefectureCode prefecture code
	 * @return json string
	 */
	
	@RequestMapping(value = "/post_offices/prefectures/{prefectureCode}", method = RequestMethod.GET)
	public ResponseEntity searchByPrefectureCode(@PathVariable("prefectureCode") String prefectureCode) {
		if (Common.checkNumber(prefectureCode) == false) {
			return new ResponseEntity<>(ResponseError.error_1(), HttpStatus.NOT_FOUND);
		}
		List<TblCity> cityList = cityService.searchCityByPrefectureCode(Common.replaceData(prefectureCode));
		if (cityList.size() == Constant.MIN_SIZE) {
			return new ResponseEntity<>(ResponseError.error_2(), HttpStatus.NOT_FOUND);
		} else if (cityList.size() > Constant.MIN_SIZE) {
			return new ResponseEntity<>(new RestData(getListResponseFromCity(cityList)), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseError.error_3(), HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * get List Response From City
	 *
	 * @param cityList List TblUser
	 * @return List SearchByPrefectureCodeResponse
	 */
	
	private List<SearchByPrefectureCodeResponse> getListResponseFromCity(List<TblCity> cityList) {
		List<SearchByPrefectureCodeResponse> searchByPrefectureCodeResponseList = new ArrayList<>();
		for (TblCity city : cityList) {
			searchByPrefectureCodeResponseList.add(new SearchByPrefectureCodeResponse(city));
		}
		return searchByPrefectureCodeResponseList;
	}
	
}
