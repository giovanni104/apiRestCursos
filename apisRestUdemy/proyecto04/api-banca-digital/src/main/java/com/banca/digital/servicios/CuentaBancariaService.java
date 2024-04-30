package com.banca.digital.servicios;

import com.banca.digital.dtos.*;
import com.banca.digital.entidades.Cliente;
import com.banca.digital.entidades.CuentaActual;
import com.banca.digital.entidades.CuentaAhorro;
import com.banca.digital.entidades.CuentaBancaria;
import com.banca.digital.excepciones.BalanceInsuficienteException;
import com.banca.digital.excepciones.ClienteNotFoundException;
import com.banca.digital.excepciones.CuentaBancariaNotFoundException;

import java.util.List;

public interface CuentaBancariaService {

    ClienteDTO saveCliente(ClienteDTO clienteDTO);

    ClienteDTO getCliente(Long clienteId) throws ClienteNotFoundException;

    ClienteDTO updateCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> searchClientes(String keyword);

    void deleteCliente(Long clienteId);

    CuentaActualDTO saveCuentaBancariaActual(double balanceInicial, double sobregiro, Long clienteId) throws ClienteNotFoundException;

    CuentaAhorroDTO saveCuentaBancariaAhorro(double balanceInicial, double tasaInteres, Long clienteId) throws ClienteNotFoundException;

    List<ClienteDTO> listClientes();

    CuentaBancariaDTO getCuentaBancaria(String cuentaId) throws CuentaBancariaNotFoundException;

    void debit(String cuentaId,double monto,String descripcion) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    void credit(String cuentaId,double monto,String descripcion) throws CuentaBancariaNotFoundException;

    void transfer(String cuentaIdPropietario,String cuentaIdDestinatario,double monto) throws CuentaBancariaNotFoundException,BalanceInsuficienteException;

    List<CuentaBancariaDTO> listCuentasBancarias();

    List<OperacionCuentaDTO> listHistorialDeLaCuenta(String cuentaId);

    HistorialCuentaDTO getHistorialCuenta(String cuentaId,int page,int size) throws CuentaBancariaNotFoundException;
}
