package com.kenny.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.domain.DocumentoIdentidad;
import com.kenny.app.repository.DocumentoIdentidadDao;

@Component
public class SimpleDocumentoIdentidadManager implements DocumentoIdentidadManager {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private DocumentoIdentidadDao documentoIdentidadDao;
    
    public void saveDocumentoIdentidad(DocumentoIdentidad documentoIdentidad) {
    	documentoIdentidadDao.saveDocumentoIdentidad(documentoIdentidad);
	}
    
    public List<DocumentoIdentidad> getDocumentoIdentidad() {
    	return documentoIdentidadDao.getDocumentoIdentidadList();
    }
    
    public DocumentoIdentidad getDocumentoIdentidadById(DocumentoIdentidad documentoIdentidad) {
		return documentoIdentidadDao.getDocumentoIdentidadById(documentoIdentidad);
	}
    
    public void setDocumentoIdentidadDao(DocumentoIdentidadDao documentoIdentidadDao) {
        this.documentoIdentidadDao = documentoIdentidadDao;
    }
}