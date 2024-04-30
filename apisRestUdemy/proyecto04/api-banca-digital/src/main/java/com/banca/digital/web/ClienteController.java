package com.banca.digital.web;

import com.banca.digital.dtos.ClienteDTO;
import com.banca.digital.excepciones.ClienteNotFoundException;
import com.banca.digital.servicios.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private CuentaBancariaService cuentaBancariaService;

    @GetMapping("/clientes")
    public List<ClienteDTO> listarClientes(){
        return cuentaBancariaService.listClientes();
    }

    @GetMapping("/clientes/{id}")
    public ClienteDTO listarDatosDelCliente(@PathVariable(name = "id") Long clienteId) throws ClienteNotFoundException {
        return cuentaBancariaService.getCliente(clienteId);
    }

    @PostMapping("/clientes")
    public ClienteDTO guardarCliente(@RequestBody ClienteDTO clienteDTO){
        return cuentaBancariaService.saveCliente(clienteDTO);
    }

    @PutMapping("/clientes/{clienteId}")
    public ClienteDTO actualizarCliente(@PathVariable Long clienteId,@RequestBody ClienteDTO clienteDTO){
        clienteDTO.setId(clienteId);
        return cuentaBancariaService.updateCliente(clienteDTO);
    }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Long id){
        cuentaBancariaService.deleteCliente(id);
    }

    @GetMapping("/clientes/search")
    public List<ClienteDTO> buscarClientes(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return cuentaBancariaService.searchClientes("%"+keyword+"%");
    }
}
