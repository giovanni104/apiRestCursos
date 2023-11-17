package com.pyt.firmas.test;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.pyt.firmas.bean.CertificadoUdemy;
import com.pyt.firmas.core.CertificateStore;
import com.pyt.firmas.core.XadesFirma;
import com.pyt.firmas.util.Constante;

 
public class XMLTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CertificadoUdemy certificado= CertificateStore.getCertificateFromFile(Constante.CERTIFICADO, Constante.CLAVE);
			Path path = Paths.get(Constante.XML);
			byte[] documento = Files.readAllBytes(path);
			documento = XadesFirma.firmaXmlBasico(documento, certificado);
			FileOutputStream out = new FileOutputStream(Constante.XML_FIRMADO);
			out.write(documento);
			out.close();
			System.out.println("xml firmado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
