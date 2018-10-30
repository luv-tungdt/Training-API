package com.example.controller;

import com.example.utils.Common;
import com.example.utils.Constant;
import com.example.utils.ResponseError;
import com.example.utils.RestData;
import com.example.model.TblArea;
import com.example.model.response.SearchByPostCodeResponse;
import com.example.service.AreaService;
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
public class AreaController {
	
	@Autowired
	AreaService areaService;
	
	
	/**
	 * Handles data from view
	 *
	 * @param postcode prefecture code
	 * @return json string
	 *
	 */
	@RequestMapping(value = "/post_offices/post/{postcode}", method = RequestMethod.GET)
	public ResponseEntity searchByPostCode(@PathVariable("postcode") String postcode) {
		if (Common.checkNumber(Common.replaceData(postcode)) == false) {
			return new ResponseEntity<>(ResponseError.error_1(), HttpStatus.NOT_FOUND);
		}
		List<TblArea> areaList = areaService.searchAreaByPostCode(Common.replaceData(postcode));
		if (areaList.size() == Constant.MIN_SIZE) {
			return new ResponseEntity<>(ResponseError.error_2(), HttpStatus.NOT_FOUND);
		} else if (areaList.size() > Constant.MIN_SIZE) {
			return new ResponseEntity<>(new RestData(getListResponseFromArea(areaList)), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseError.error_3(), HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * get List Response From Area
	 *
	 * @param areaList List TblUser
	 * @returnjson List SearchByPrefectureCodeResponse 
	 *
	 */
	private List<SearchByPostCodeResponse> getListResponseFromArea(List<TblArea> areaList) {
		List<SearchByPostCodeResponse> searchByPostCodeResponseList = new ArrayList<>();
		for (TblArea area : areaList) {
			searchByPostCodeResponseList.add(new SearchByPostCodeResponse(area));
		}
		return searchByPostCodeResponseList;
	}
	
}
