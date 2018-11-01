package com.example.model.Common;

import com.example.model.TblArea;
import com.example.model.TblCity;
import com.example.model.TblOldPost;
import com.example.model.TblPost;
import com.example.model.TblPrefecture;
import com.example.model.response.SearchByPostCodeResponse;

public class SearchByPostCodeResponseFixtures {
	
	public static String createTblAreaEntryJson() {
		String json = ""
				+ "{"
				+ "\"code\":\"1234\","
				+ "\"prefecture\":\"prefecture\","
				+ "\"city\":\"city\","
				+ "\"area\":\"area\","
				+ "\"old_post_code\":\"oldPostCode\","
				+ "\"post_code\":\"postCode\","
				+ "\"prefecture_kana\":\"prefectureKana\","
				+ "\"city_kana\":\"cityKana\","
				+ "\"area_kana\":\"areaKana\","
				+ "\"multi_area\":\"0\","
				+ "\"koaza_area\":\"0\","
				+ "\"chome_area\":\"0\","
				+ "\"multi_post_area\":\"0\","
				+ "\"update_show\":\"0\","
				+ "\"change_reason\":\"0\","
				+ "\"prefecture_code\":\"0\""
				+ "}";
		return json;
	}
	
	public static SearchByPostCodeResponse createTblArea() {
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

		return new SearchByPostCodeResponse(tblArea);
	}
	
}
