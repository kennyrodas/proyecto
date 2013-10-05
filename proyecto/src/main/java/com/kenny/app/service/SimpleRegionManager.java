package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.Region;
import com.kenny.app.repository.RegionDao;
@Component
public class SimpleRegionManager implements RegionManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RegionDao regionDao;
	@Override
	public List<Region> getRegiones() {
		// TODO Auto-generated method stub
		return this.regionDao.getRegionList();
	}

}
