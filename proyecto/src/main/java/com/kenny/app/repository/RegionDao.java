package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Region;
public interface RegionDao {
public List<Region> getRegionList();
public List<Region> getRegionListByPais(int pais_id);
}
