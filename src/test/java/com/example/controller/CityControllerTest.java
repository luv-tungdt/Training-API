package com.example.controller;

import com.example.model.TblCity;
import com.example.model.TblPrefecture;
import com.example.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CityService cityService;
	
	
	@Test
	public void searchByPrefectureCodeTest() throws Exception {
		List<TblCity> tblCityList = new ArrayList<>();
		TblPrefecture tblPrefecture = new TblPrefecture("ｻｲﾀﾏｹﾝ", "埼玉県", "11");
		tblCityList.add(new TblCity("ｻｲﾀﾏｼﾆｼｸ", "さいたま市西区", tblPrefecture));

		when(cityService.searchCityByPrefectureCode(anyString())).thenReturn(tblCityList);

		mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "14")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void searchByPrefectureCodeTestThrowsNfe() throws Exception {
		List<TblCity> tblCityList = new ArrayList<>();

		when(cityService.searchCityByPrefectureCode(anyString())).thenReturn(tblCityList);

		mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "312")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void searchByPrefectureCodeThrowsBre() throws Exception {
		List<TblCity> tblCityList = new ArrayList<>();
		TblPrefecture tblPrefecture = new TblPrefecture("ｻｲﾀﾏｹﾝ", "埼玉県", "２３");
		tblCityList.add(new TblCity("ｻｲﾀﾏｼﾆｼｸ", "さいたま市西区", tblPrefecture));

		when(cityService.searchCityByPrefectureCode(anyString())).thenReturn(tblCityList);
		mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "２３")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
	}
	
}
