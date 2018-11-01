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
public class AreaRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AreaRepository sut;
	
	
	/**
	 * Test find list TblArea by PostCode
	 */
	@Test
	public void searchAreaByPostCodeTest() {
		//setup

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
		
		TblPost tblPost = new TblPost();
		tblPost.setPostCode("postCode");
		tblPost.setUpdateShow(1);
		tblPost.setChangeReason(2);
		tblPost.setMultiArea(3);
		
		entityManager.persist(tblPost);
		entityManager.flush();
		
		TblOldPost tblOldPost = new TblOldPost();
		tblOldPost.setOldPostCode("OldPostCode");
		
		entityManager.persist(tblOldPost);
		entityManager.flush();
		
		TblArea tblArea = new TblArea();
		tblArea.setAreaKana("areaKana");
		tblArea.setArea("area");
		tblArea.setTblCity(tblCity);
		tblArea.setChomeArea(4);
		tblArea.setKoazaArea(5);
		tblArea.setMultiPostArea(6);
		tblArea.setTblOldPost(tblOldPost);
		tblArea.setTblPost(tblPost);
		
		entityManager.persist(tblArea);
		entityManager.flush();

		//exercise
		List<TblArea> tblAreaList = sut.searchAreaByPostCode(tblPost.getPostCode());

		//verify
		Assert.assertEquals(tblAreaList.get(0).getArea(), tblArea.getArea());
	}
	
}
