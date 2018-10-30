package com.example.model.response;

import com.example.model.TblCity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchByPrefectureCodeResponse {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("prefecture")
	private String prefecture;
	
	@JsonProperty("city")
	
	private String city;
	
	@JsonProperty("prefecture_kana")
	
	private String prefectureKana;
	
	@JsonProperty("city_kana")
	
	private String cityKana;
	
	@JsonProperty("prefecture_code")
	
	private String prefectureCode;
	
	
	public SearchByPrefectureCodeResponse(TblCity tblCity) {
		this.code = tblCity.getCode();
		this.prefecture = tblCity.getTblPrefecture().getPrefecture();
		this.city = tblCity.getCity();
		this.prefectureKana = tblCity.getTblPrefecture().getPrefectureKana();
		this.cityKana = tblCity.getCityKana();
		this.prefectureCode = tblCity.getTblPrefecture().getPrefectureCode();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getPrefecture() {
		return prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPrefectureKana() {
		return prefectureKana;
	}
	
	public void setPrefectureKana(String prefectureKana) {
		this.prefectureKana = prefectureKana;
	}
	
	public String getCityKana() {
		return cityKana;
	}
	
	public void setCityKana(String cityKana) {
		this.cityKana = cityKana;
	}
	
	public String getPrefectureCode() {
		return prefectureCode;
	}
	
	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}
}
