/**
 * 
 */
package com.pyt.firmas.core;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.pyt.firmas.bean.CertificadoUdemy;

/**
 * @author Cesar
 *
 */
public class CertificateStore {

	public static CertificadoUdemy getCertificateFromFile(String path, String key) {

		CertificadoUdemy certificado = new CertificadoUdemy();
		try {

			KeyStore jks = KeyStore.getInstance("PKCS12");
			InputStream in = new FileInputStream(path);
			jks.load(in, key.toCharArray());
			in.close();

			String aliasJks = jks.aliases().nextElement();
			PrivateKey pk = (PrivateKey) jks.getKey(aliasJks, key.toCharArray());
			Certificate[] chain = jks.getCertificateChain(aliasJks);
			X509Certificate oPublicCertificate = (X509Certificate) chain[0];

			certificado.setAlias(oPublicCertificate.getSubjectDN().getName());
			certificado.setPublicCertificate(oPublicCertificate);
			certificado.setPrivateKey(pk);
			certificado.setCertificateChain(chain);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return certificado;
	}
	
	
	public static CertificadoUdemy getCertificateFromBytes(byte[] data, String key) {

		CertificadoUdemy certificado = new CertificadoUdemy();
		try {

			KeyStore jks = KeyStore.getInstance("PKCS12");
			InputStream in = new ByteArrayInputStream(data);
			jks.load(in, key.toCharArray());
			in.close();

			String aliasJks = jks.aliases().nextElement();
			PrivateKey pk = (PrivateKey) jks.getKey(aliasJks, key.toCharArray());
			Certificate[] chain = jks.getCertificateChain(aliasJks);
			X509Certificate oPublicCertificate = (X509Certificate) chain[0];

			certificado.setAlias(oPublicCertificate.getSubjectDN().getName());
			certificado.setPublicCertificate(oPublicCertificate);
			certificado.setPrivateKey(pk);
			certificado.setCertificateChain(chain);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return certificado;
	}
	
	
	
	
	
	
	

	public static List<CertificadoUdemy> listCertificateFromStore() {

		List<CertificadoUdemy> listCertificadoUdemy = new ArrayList<>();
		try {
			KeyStore jks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
			jks.load(null, null);

			Enumeration<String> en = jks.aliases();
			while (en.hasMoreElements()) {
				CertificadoUdemy certificado = new CertificadoUdemy();
				String aliasKey = (String) en.nextElement();

				PrivateKey pk = (PrivateKey) jks.getKey(aliasKey, null);
				Certificate[] chain = jks.getCertificateChain(aliasKey);
				X509Certificate oPublicCertificate = (X509Certificate) chain[0];

				certificado.setAlias(oPublicCertificate.getSubjectDN().getName());
				certificado.setPublicCertificate(oPublicCertificate);
				certificado.setPrivateKey(pk);
				certificado.setCertificateChain(chain);

				listCertificadoUdemy.add(certificado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCertificadoUdemy;
	}

}
