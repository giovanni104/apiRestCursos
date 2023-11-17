/**
 * 
 */
package com.udemy.firma.service;

import com.udemy.firma.bean.Firma;

/**
 * @author Cesar
 *
 */
public interface FirmaService {
	byte[] firmarPdf(byte[] data) throws Exception;
	
	byte[] firmarPdfBd(byte[] data ) throws Exception;
	
	Object saveCertificate(Firma firma) throws Exception;
	Object searchCertificate() throws Exception;
}
