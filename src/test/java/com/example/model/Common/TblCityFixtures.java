package com.example.model.Common;

import com.example.model.TblCity;
import com.example.model.TblPrefecture;

public class TblCityFixtures {
	
	public static TblCity createTblCity() {
		TblPrefecture tblPrefecture = new TblPrefecture();
		tblPrefecture.setPrefectureKana("prefectureKana");
		tblPrefecture.setPrefecture("prefecture");
		tblPrefecture.setPrefectureCode("prefectureCode");
		
		TblCity tblCity = new TblCity();
		tblCity.setCode("1234");
		tblCity.setCityKana("cityKana");
		tblCity.setCity("city");
		tblCity.setTblPrefecture(tblPrefecture);
		
		return tblCity;
		
	}
}
