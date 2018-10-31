package com.example.dao;

import com.example.model.TblArea;
import com.example.model.TblCity;
import com.example.model.TblOldPost;
import com.example.model.TblPost;
import com.example.model.TblPrefecture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CityRepositoryImplTest {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private TestEntityManager entityManager;


	
	@Test
	public void searchCityByPrefectureCode() {
		TblPrefecture tblPrefecture = new TblPrefecture();
		tblPrefecture.setPrefectureKana("prefectureKana");
		tblPrefecture.setPrefecture("prefecture");
		tblPrefecture.setPrefectureCode("prefectureCode");


		entityManager.persist(tblPrefecture);
		entityManager.flush();

		TblCity tblCity = new TblCity();
		tblCity.setCode("1234");
		tblCity.setCityKana("cityKana");
		tblCity.setCity("city");
		tblCity.setTblPrefecture(tblPrefecture);

		entityManager.persist(tblCity);
		entityManager.flush();

		List<TblCity> tblCity1 = cityRepository.searchCityByPrefectureCode(tblPrefecture.getPrefectureCode());

        Assert.assertEquals(tblCity1.get(0).getTblPrefecture().getPrefectureCode(),tblPrefecture.getPrefectureCode());
		
	}
}
