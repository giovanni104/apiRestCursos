package com.banca.digital.servicios;

import com.banca.digital.entidades.CuentaActual;
import com.banca.digital.entidades.CuentaAhorro;
import com.banca.digital.entidades.CuentaBancaria;
import com.banca.digital.repositorios.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BancoService {

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;

    public void consultar(){
        CuentaBancaria cuentaBancariaBBDD = cuentaBancariaRepository.findById("2b8954b2-0ba4-488f-a0c5-2c4e7b2e3234").orElse(null);

        if(cuentaBancariaBBDD != null){
            System.out.println("*********************************");
            System.out.println("ID : " + cuentaBancariaBBDD.getId());
            System.out.println("Balance de la cuenta : " + cuentaBancariaBBDD.getBalance());
            System.out.println("Estado : " + cuentaBancariaBBDD.getEstadoCuenta());
            System.out.println("Fecha de creación : " + cuentaBancariaBBDD.getFechaCreacion());
            System.out.println("Cliente : " + cuentaBancariaBBDD.getCliente().getNombre());
            System.out.println("Nombre de la clase : " + cuentaBancariaBBDD.getClass().getSimpleName());

            if(cuentaBancariaBBDD instanceof CuentaActual){
                System.out.println("Sobregiro : " + ((CuentaActual) cuentaBancariaBBDD).getSobregiro());
            }

            else if(cuentaBancariaBBDD instanceof CuentaAhorro){
                System.out.println("Tasa de interes : " + ((CuentaAhorro) cuentaBancariaBBDD).getTasaDeInteres());
            }

            cuentaBancariaBBDD.getOperacionesCuenta().forEach(operacionCuenta ->  {
                System.out.println("------------------------------------------");
                System.out.println("Tipo de operacion : " + operacionCuenta.getTipoOperacion());
                System.out.println("Fecha de operacion : " + operacionCuenta.getFechaOperacion());
                System.out.println("Monto : " + operacionCuenta.getMonto());
            });
        }
    }
}
