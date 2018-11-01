package com.example.controller;

import com.example.model.TblCity;
import com.example.service.Impl.AreaService;
import com.example.service.Impl.CityService;
import com.example.utils.Common;
import com.example.utils.ResponseError;
import com.example.utils.RestData;
import com.example.model.TblArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	CityService cityService;
	
	
	/**
	 * Handles data from request
	 *
	 * @param postcode prefecture code
	 * @return List Area 
	 *
	 */
	@RequestMapping(value = "/post_offices/post/{postcode}", method = RequestMethod.GET)
	public ResponseEntity searchByPostCode(@PathVariable("postcode") String postcode) {
		if (Common.checkNumber(Common.replaceData(postcode)) == false) {
			return new ResponseEntity<>(ResponseError.error_400(), HttpStatus.BAD_REQUEST);
		}
		List<TblArea> areaList = areaService.searchAreaByPostCode(Common.replaceData(postcode));
		if (areaList.size() == 0) {
			return new ResponseEntity<>(ResponseError.error_404(), HttpStatus.NOT_FOUND);
		} else if (areaList.size() > 0) {
			return new ResponseEntity<>(new RestData(Common.findListResponseFromArea(areaList)), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseError.error_500(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/**
	 * Handles data from request
	 *
	 * @param prefectureCode prefecture code
	 * @return List city
	 */
	
	@RequestMapping(value = "/post_offices/prefectures/{prefectureCode}", method = RequestMethod.GET)
	public ResponseEntity searchByPrefectureCode(@PathVariable("prefectureCode") String prefectureCode) {
		if (Common.checkNumber(prefectureCode) == false) {
			return new ResponseEntity<>(ResponseError.error_400(), HttpStatus.BAD_REQUEST);
		}
		List<TblCity> cityList = cityService.searchCityByPrefectureCode(Common.replaceData(prefectureCode));
		if (cityList.size() == 0) {
			return new ResponseEntity<>(ResponseError.error_404(), HttpStatus.NOT_FOUND);
		} else if (cityList.size() > 0) {
			return new ResponseEntity<>(new RestData(Common.findListResponseFromCity(cityList)), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseError.error_500(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
