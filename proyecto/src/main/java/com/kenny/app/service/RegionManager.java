package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.Region;

public interface RegionManager extends Serializable {
	public List<Region> getRegiones();
}
