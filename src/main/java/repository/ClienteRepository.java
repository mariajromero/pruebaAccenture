package repository;

import com.example.demo.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> listaClientes;
    private static ClienteRepository instancia;
    private ClienteRepository(){
        listaClientes=new ArrayList<>();
        Cliente primerCliente=new Cliente("carrera 11#14 08",12345);
        listaClientes.add(primerCliente);
    }
    public static ClienteRepository getInstance(){
        if (instancia==null)
        {
            instancia=new ClienteRepository();

        }
        return instancia;
    }
    public Cliente agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
        return cliente;
    }
    public Cliente borrarCliente(int cedula){
        for (int i=0;i<listaClientes.size();i++){
            Cliente clienteCogido= listaClientes.get(i);

            if (clienteCogido.getCedula()==cedula){
                listaClientes.remove(i);
                return clienteCogido;
            }

        }
        return null;
    }
    public Cliente modificarcliente(Cliente cliente){
        for (int i=0;i<listaClientes.size();i++){
            Cliente clienteCogido= listaClientes.get(i);

            if (clienteCogido.getCedula()==cliente.getCedula()){
                clienteCogido.update(cliente);
                return clienteCogido;
            }

        }
        return null;

    }
    public Cliente getCliente(int cedula){
        for (Cliente clienteCogido:listaClientes) {
            if(clienteCogido.getCedula()==cedula){
                return clienteCogido;
            }

        }
        return null;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
