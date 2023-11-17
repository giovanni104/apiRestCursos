/**
 * 
 */
package com.udemy.firma.controller.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firma.bean.Documento;
import com.udemy.firma.bean.Firma;
import com.udemy.firma.controller.FirmaController;
import com.udemy.firma.service.FirmaService;

/**
 * @author Cesar
 *
 */
@RestController
@RequestMapping("/pki")
public class FirmaControllerImpl implements FirmaController{

	@Autowired
	private FirmaService utilService;
	
	@Override
	@PostMapping("/firma")
	public Object firmarDocumento(@RequestBody Documento documento) {
		Map<String, Object> response=new HashMap<>();
		try {
			byte[] rsp = utilService.firmarPdf(documento.getData());
			response.put("estado", "OK");
			response.put("data", rsp);
		} catch (Exception e) {
			response.put("estado", "Error");
			response.put("mensaje", e.getMessage());
		 
		}
		return response;
	}

	@Override
	@PostMapping("/save")
	public Object saveCertificate(@RequestBody  Firma firma) {		
		
		Map<String, Object> response=new HashMap<>();
		try {
			response=(Map<String, Object>) utilService.saveCertificate(firma);
		} catch (Exception e) {
			response.put("estado", "Error");
			response.put("mensaje", e.getMessage());
		 
		}
		return response;
		
	 
	}

	@Override
	@PostMapping("/search")
	public Object searchCertificate() {
		Map<String, Object> response=new HashMap<>();
		try {
			response=(Map<String, Object>) utilService.searchCertificate();
		} catch (Exception e) {
			response.put("estado", "Error");
			response.put("mensaje", e.getMessage());
		 
		}
		return response;
		 
	}

	@Override
	@PostMapping("/firmaBD")
	public Object firmarDocumentoBdCertificate(@RequestBody  Documento documento) {
		Map<String, Object> response=new HashMap<>();
		try {
			byte[] rsp = utilService.firmarPdfBd(documento.getData());
			response.put("estado", "OK");
			response.put("data", rsp);
		} catch (Exception e) {
			response.put("estado", "Error");
			response.put("mensaje", e.getMessage());
		 
		}
		return response;
	}

}
