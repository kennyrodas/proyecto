package com.kenny.app.repository;
import java.util.List;

import com.kenny.app.domain.Distrito;
public interface DistritoDao {
public List<Distrito> getDistritoList();
public List<Distrito> getDistritoListByProvincia(int provincia_id);
}
