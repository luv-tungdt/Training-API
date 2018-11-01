package com.example.utils;

import com.example.model.TblArea;
import com.example.model.TblCity;
import com.example.model.response.SearchByPostCodeResponse;
import com.example.model.response.SearchByPrefectureCodeResponse;

import java.util.ArrayList;
import java.util.List;

public class Common {
	
	/**
	 * check the number of halfsize
	 *
	 * @param input string requires processing
	 * @return true if input is number of halfsize else flase
	 */
	public static boolean checkNumber(String input) {
		return replaceData(input).matches("^[0-9]+$");
	}
	
	/**
	 * Processing input string from view
	 *
	 * @param input string requires processing
	 * @return string after processing
	 */
	public static String replaceData(String input) {
		input = input.replaceAll("\\s+", "").replaceAll("-", "");
		return input;
	}
	
	/**
	 * get List Response From City
	 *
	 * @param cityList List TblUser
	 * @return List SearchByPrefectureCodeResponse
	 */
	
	public static List<SearchByPrefectureCodeResponse> findListResponseFromCity(List<TblCity> cityList) {
		List<SearchByPrefectureCodeResponse> searchByPrefectureCodeResponseList = new ArrayList<>();
		for (TblCity city : cityList) {
			searchByPrefectureCodeResponseList.add(new SearchByPrefectureCodeResponse(city));
		}
		return searchByPrefectureCodeResponseList;
	}
	
	/**
	 * get List Response From Area
	 *
	 * @param areaList List TblUser
	 * @returnjson List SearchByPrefectureCodeResponse
	 *
	 */
	public static List<SearchByPostCodeResponse> findListResponseFromArea(List<TblArea> areaList) {
		List<SearchByPostCodeResponse> searchByPostCodeResponseList = new ArrayList<>();
		for (TblArea area : areaList) {
			searchByPostCodeResponseList.add(new SearchByPostCodeResponse(area));
		}
		return searchByPostCodeResponseList;
	}
	
}
