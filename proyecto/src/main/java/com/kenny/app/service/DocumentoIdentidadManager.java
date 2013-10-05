package com.kenny.app.service;

import java.io.Serializable;
import java.util.List;

import com.kenny.app.domain.DocumentoIdentidad;

public interface DocumentoIdentidadManager extends Serializable {
	
	public void saveDocumentoIdentidad(DocumentoIdentidad documentoIdentidad);
    
    public List<DocumentoIdentidad> getDocumentoIdentidad();
    
    public DocumentoIdentidad getDocumentoIdentidadById(DocumentoIdentidad documentoIdentidad);

}
