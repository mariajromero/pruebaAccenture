package com.example.demo.controler;

import com.example.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ClienteService;

import java.util.List;

@RestController
public class ClienteControler {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/clientes")
    public List<Cliente> clientes(){
        return clienteService.getAllClientes();
    }
    @GetMapping("/cliente")
    public Cliente getCliente(@RequestParam (value="id")int id){
        return null;
    }
    @PostMapping("/cliente")
    public Cliente postCliente(@RequestBody Cliente cliente){
        return cliente;
    }
    @PutMapping("/cliente")
    public Cliente putCliente(@RequestBody Cliente cliente){ return cliente;}
    @DeleteMapping("/cliente/{id}")
    public Cliente deleteCliente (@PathVariable("id")int id){
        return null;
    }
}
