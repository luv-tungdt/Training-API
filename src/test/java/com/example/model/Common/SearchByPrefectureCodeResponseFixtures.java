package com.example.model.Common;

import com.example.model.TblCity;
import com.example.model.TblPrefecture;
import com.example.model.response.SearchByPrefectureCodeResponse;

public class SearchByPrefectureCodeResponseFixtures {
	
	public static String createTblCityEntryJson() {
		String json = ""
				+ "{"
				+ "\"code\":\"1234\","
				+ "\"prefecture\":\"prefecture\","
				+ "\"city\":\"city\","
				+ "\"prefecture_kana\":\"prefectureKana\","
				+ "\"city_kana\":\"cityKana\","
				+ "\"prefecture_code\":\"prefectureCode\""
				+ "}";
		
		return json;
	}
	
	public static SearchByPrefectureCodeResponse createTblCity() {
		TblPrefecture tblPrefecture = new TblPrefecture();
		tblPrefecture.setPrefectureKana("prefectureKana");
		tblPrefecture.setPrefecture("prefecture");
		tblPrefecture.setPrefectureCode("prefectureCode");
		
		TblCity tblCity = new TblCity();
		tblCity.setCode("1234");
		tblCity.setCityKana("cityKana");
		tblCity.setCity("city");
		tblCity.setTblPrefecture(tblPrefecture);
		
		return new SearchByPrefectureCodeResponse(tblCity);
	}
}
