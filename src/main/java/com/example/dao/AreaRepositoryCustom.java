package com.example.dao;

import com.example.model.TblArea;

import java.util.List;

public interface AreaRepositoryCustom {
	
	/**
	 * get Area information by postcode
	 *
	 * @param  postCode postcode;
	 * @return TblArea
	 */
	List<TblArea> searchAreaByPostCode(String postCode);
	
}
