package com.banca.digital.repositorios;

import com.banca.digital.entidades.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria,String> {


}
