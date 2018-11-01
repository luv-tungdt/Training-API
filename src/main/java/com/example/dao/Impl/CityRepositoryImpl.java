package com.example.dao.Impl;

import com.example.dao.CityRepositoryCustom;
import com.example.model.TblCity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.List;

public class CityRepositoryImpl implements CityRepositoryCustom {
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<TblCity> searchCityByPrefectureCode(String prefectureCode) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
		sql.append("FROM tbl_city AS tc ");
		sql.append("INNER JOIN tbl_prefecture tpf ");
		sql.append("ON tpf.prefecture_id = tc.prefecture_id ");
		sql.append("WHERE tpf.prefecture_code = :prefectureCode ");
		Query query = (Query) entityManager.createNativeQuery(sql.toString(), TblCity.class);
		query.setParameter("prefectureCode", prefectureCode);
		return (List<TblCity>) query.getResultList();
	}
	
}
