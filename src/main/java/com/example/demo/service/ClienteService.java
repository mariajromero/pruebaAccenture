package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;
@Service
public class ClienteService {
    public Cliente getCliente(int cedula){
        return ClienteRepository.getInstance().getCliente(cedula);

    }
    public Cliente postCliente(Cliente cliente){
        return ClienteRepository.getInstance().agregarCliente(cliente);
    }
    public Cliente deleteCliente(int cedula){
        return ClienteRepository.getInstance().borrarCliente(cedula);
    }
    public Cliente putCliente(int cedula, Cliente cliente){
        return ClienteRepository.getInstance().modificarcliente(cliente);

    }
    public List<Cliente> getAllClientes()
    {
        return ClienteRepository.getInstance().getListaClientes();
    }
}
