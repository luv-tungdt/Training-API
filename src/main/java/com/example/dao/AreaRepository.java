package com.example.dao;

import com.example.model.TblArea;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AreaRepository {
	
	/**
	 * get Area information by postcode
	 *
	 * @param  postCode postcode;
	 * @return TblArea
	 */
	List<TblArea> searchAreaByPostCode(String postCode);
	
}
