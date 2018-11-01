package com.example.model.Common;

import com.example.model.TblArea;
import com.example.model.TblCity;
import com.example.model.TblOldPost;
import com.example.model.TblPost;
import com.example.model.TblPrefecture;

public class TblAreaFixtures {
	
	public static TblArea createTblArea() {
		TblPrefecture tblPrefecture = new TblPrefecture();
		tblPrefecture.setPrefectureKana("prefectureKana");
		tblPrefecture.setPrefecture("prefecture");
		tblPrefecture.setPrefectureCode("22");
		
		TblCity tblCity = new TblCity();
		tblCity.setCode("1234");
		tblCity.setCityKana("cityKana");
		tblCity.setCity("city");
		tblCity.setTblPrefecture(tblPrefecture);
		
		TblPost tblPost = new TblPost();
		tblPost.setPostCode("postCode");
		tblPost.setUpdateShow(0);
		tblPost.setChangeReason(0);
		tblPost.setMultiArea(0);
		
		TblOldPost tblOldPost = new TblOldPost();
		tblOldPost.setOldPostCode("oldPostCode");
		
		TblArea tblArea = new TblArea();
		tblArea.setAreaKana("areaKana");
		tblArea.setArea("area");
		tblArea.setTblCity(tblCity);
		tblArea.setChomeArea(0);
		tblArea.setKoazaArea(0);
		tblArea.setMultiPostArea(0);
		tblArea.setTblOldPost(tblOldPost);
		tblArea.setTblPost(tblPost);
		
		return tblArea;
		
	}
}
