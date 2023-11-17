package com.udemy.firma.repository;
import com.udemy.firma.bean.Firma;
public interface FirmaRepository {

	int save(Firma firma);	  

	Firma findById(Long id);

	int deleteById(Long id);
 
	}
