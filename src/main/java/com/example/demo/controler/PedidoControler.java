package com.example.demo.controler;

import com.example.demo.model.Cliente;
import com.example.demo.model.Factura;
import com.example.demo.model.Pedido;
import com.example.demo.service.ClienteService;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoControler {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping("/pedidos")
    public List<Pedido> pedidos(){
        return pedidoService.getAllPedidos();
    }
    @GetMapping("/pedido")
    public Pedido getPedido(@RequestParam(value="id")int id){
        return pedidoService.getPedido(id);
    }
    @PostMapping("/pedido")
    public Factura postPedido(@RequestBody Pedido pedido){
        return pedidoService.postPedido(pedido);
    }
    @PutMapping("/pedido")
    public Factura putPedido(@RequestBody Pedido pedido){ return pedidoService.putPedido(pedido);}
    @DeleteMapping("/pedido/{id}")
    public Factura deletePedido (@PathVariable("id")int id){
        System.out.println("ENTRA ACá");
        return pedidoService.deletePedido(id);
    }
}
