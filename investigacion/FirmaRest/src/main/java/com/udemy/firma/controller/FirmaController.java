/**
 * 
 */
package com.udemy.firma.controller;

import com.udemy.firma.bean.Documento;
import com.udemy.firma.bean.Firma;

/**
 * @author Cesar
 *
 */
public interface FirmaController {
	Object firmarDocumento(Documento documento);
	
	Object firmarDocumentoBdCertificate(Documento documento);
	
	Object saveCertificate(Firma firma);
	
	
	Object searchCertificate();
	
	
}
