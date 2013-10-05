package com.kenny.app.repository;

import java.util.List;

import com.kenny.app.domain.DocumentoIdentidad;

public interface DocumentoIdentidadDao {

    public List<DocumentoIdentidad> getDocumentoIdentidadList();
    
    public void saveDocumentoIdentidad(DocumentoIdentidad documentoIdentidad);
    
    public DocumentoIdentidad getDocumentoIdentidadById(DocumentoIdentidad documentoIdentidad);

}