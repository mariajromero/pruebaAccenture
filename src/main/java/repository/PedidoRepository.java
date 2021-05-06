package repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Pedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> listaPedidos;

    private static PedidoRepository instancia;
    private PedidoRepository(){
        listaPedidos=new ArrayList<>();
        String fecha1="2021-05-06 08:30";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date1 = LocalDateTime.parse(fecha1, formatter1);
        String fecha2="2021-05-05 12:30";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date2 = LocalDateTime.parse(fecha2, formatter2);
        ArrayList<Integer> idsProductos= new ArrayList<>();
        idsProductos.add(1);


        Pedido pedido1=new Pedido(idsProductos,1,date1);
        Pedido pedido2=new Pedido(idsProductos,2,date2);
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);

    }
    public static PedidoRepository getInstance(){
        if (instancia==null)
        {
            instancia=new PedidoRepository();

        }
        return instancia;
    }
    public Pedido agregarPedido(Pedido pedido){
        listaPedidos.add(pedido);
        return pedido;
    }
    public Pedido borrarPedido(int id){
        for (int i=0;i<listaPedidos.size();i++){
            Pedido pedidoCogido= listaPedidos.get(i);

            if (pedidoCogido.getId()==id){
                listaPedidos.remove(i);
                return pedidoCogido;
            }

        }
        return null;
    }
    public Pedido modificarPedido(Pedido pedido){
        for (int i=0;i<listaPedidos.size();i++){
            Pedido pedidoCogido= listaPedidos.get(i);

            if (pedidoCogido.getId()==pedido.getId()){
                pedidoCogido.update(pedido);
                return pedidoCogido;
            }

        }
        return null;

    }
    public Pedido getPedido(int id){
        for (Pedido pedidoCogido:listaPedidos) {
            if(pedidoCogido.getId()==id){
                return pedidoCogido;
            }

        }
        return null;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

}
