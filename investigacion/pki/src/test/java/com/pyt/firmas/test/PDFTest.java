package com.pyt.firmas.test;


import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.pyt.firmas.bean.CertificadoUdemy;
import com.pyt.firmas.core.CertificateStore;
import com.pyt.firmas.core.PadesFirma;
import com.pyt.firmas.util.Constante;

/**
 * @author Cesar
 *
 */
public class PDFTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			CertificadoUdemy certificado= CertificateStore.getCertificateFromFile(Constante.CERTIFICADO, Constante.CLAVE);
			Path path = Paths.get(Constante.PDF);
			byte[] documento = Files.readAllBytes(path);
//			documento = PadesFirma.firmaPdfBasico(documento, certificado);
			documento = PadesFirma.firmarPdfAvanzado(documento, certificado);
			
			FileOutputStream out = new FileOutputStream(Constante.PDF_FIRMADO);
			out.write(documento);
			out.close();
			System.out.println("pdf firmado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
