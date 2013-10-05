package com.kenny.app.service;

import java.io.Serializable;
import com.kenny.app.domain.Supuesto;

public interface SupuestoManager  extends Serializable{
	public Supuesto save(Supuesto supuesto);
}
