package com.example.controller;

import com.example.model.Common.TblAreaFixtures;
import com.example.model.Common.TblCityFixtures;
import com.example.model.TblArea;
import com.example.model.TblCity;
import com.example.service.Impl.AreaService;
import com.example.service.Impl.CityService;
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
@WebMvcTest(AreaController.class)
public class AreaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AreaService areaService;
	
	@MockBean
	private CityService cityService;
	
	
	@Test
	public void searchByPostCodeTest() throws Exception {
		//setup
		List<TblArea> tblAreaList = new ArrayList<>();
		TblArea tblArea = TblAreaFixtures.createTblArea();
		tblAreaList.add(tblArea);
		
		when(areaService.searchAreaByPostCode(anyString())).thenReturn(tblAreaList);
		
		//exercise
		mvc.perform(get("/post_offices/post/{postcode}", "12")
			.contentType(MediaType.APPLICATION_JSON))
			//verify
			.andExpect(status().isOk());
	}
	
	@Test
	public void searchByPostCodeTestThrowsNFE() throws Exception {
		//setup
		List<TblArea> tblAreaList = new ArrayList<>();
		when(areaService.searchAreaByPostCode(anyString())).thenReturn(tblAreaList);
		//exercise
		mvc.perform(get("/post_offices/post/{postcode}", "312")
			.contentType(MediaType.APPLICATION_JSON))
			//verify
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void searchByPostCodeThrowsBRE() throws Exception {
		//setup
		List<TblArea> tblAreaList = new ArrayList<>();
		TblArea tblArea = TblAreaFixtures.createTblArea();
		tblAreaList.add(tblArea);
		
		when(areaService.searchAreaByPostCode(anyString())).thenReturn(tblAreaList);
		
		//exercise
		mvc.perform(get("/post_offices/post/{prefectureCode}", "２３")
			.contentType(MediaType.APPLICATION_JSON))
			//verify
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void searchByPrefectureCodeTest() throws Exception {
		//setup
		List<TblCity> tblCityList = new ArrayList<>();
		TblCity tblCity = TblCityFixtures.createTblCity();
		tblCityList.add(tblCity);
		
		when(cityService.searchCityByPrefectureCode(anyString())).thenReturn(tblCityList);
		//exercise
		mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "14")
			.contentType(MediaType.APPLICATION_JSON))
			//verify
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void searchByPrefectureCodeTestThrowsNFE() throws Exception {
		//setup
		List<TblCity> tblCityList = new ArrayList<>();
		
		when(cityService.searchCityByPrefectureCode(anyString())).thenReturn(tblCityList);
		//exercise
		mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "312")
			.contentType(MediaType.APPLICATION_JSON))
			//verify
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void searchByPrefectureCodeThrowsBRE() throws Exception {
		//setup
		List<TblCity> tblCityList = new ArrayList<>();
		TblCity tblCity = TblCityFixtures.createTblCity();
		tblCityList.add(tblCity);
		
		when(cityService.searchCityByPrefectureCode(anyString())).thenReturn(tblCityList);
		//exercise
		mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "２３")
			.contentType(MediaType.APPLICATION_JSON))
			//verify
			.andExpect(status().isBadRequest());
	}
	
}
