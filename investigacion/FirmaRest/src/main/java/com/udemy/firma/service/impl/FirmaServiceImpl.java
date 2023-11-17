/**
 * 
 */
package com.udemy.firma.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.firma.bean.Firma;
import com.udemy.firma.repository.FirmaRepository;
import com.udemy.firma.service.FirmaService;
import com.pyt.firmas.bean.CertificadoUdemy;
import com.pyt.firmas.core.CertificateStore;
import com.pyt.firmas.core.PadesFirma;
import com.pyt.firmas.util.Constante;

@Service
public class FirmaServiceImpl implements FirmaService {

	@Autowired
	private FirmaRepository repositoryService;

	@Override
	public byte[] firmarPdf(byte[] data) throws Exception {
		try {
			CertificadoUdemy certificado = CertificateStore.getCertificateFromFile(Constante.CERTIFICADO,
					Constante.CLAVE);
			data = PadesFirma.firmarPdfAvanzado(data, certificado);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> saveCertificate(Firma firma) throws Exception {

		int save = repositoryService.save(firma);
		Map<String, Object> response = new HashMap<>();
		response.put("estado", "OK");
		response.put("data", save);

		return response;
	}

	@Override
	public Object searchCertificate() throws Exception {

		Firma findById = repositoryService.findById((long) 0);

		Map<String, Object> response = new HashMap<>();
		response.put("estado", "OK");
		response.put("data", findById.getKeydata());
		return response;
	}

	@Override
	public byte[] firmarPdfBd(byte[] data) throws Exception {

		try {
			Firma findById = repositoryService.findById((long) 0);
			CertificadoUdemy certificado = CertificateStore.getCertificateFromBytes(findById.getKeydata(),
					findById.getPassword());
			data = PadesFirma.firmarPdfAvanzado(data, certificado);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
