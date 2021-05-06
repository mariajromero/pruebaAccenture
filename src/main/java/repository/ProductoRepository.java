package repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    private List<Producto> listaProductos;
    private static ProductoRepository instancia;

    private ProductoRepository(){
        listaProductos=new ArrayList<>();
        Producto producto1= new Producto(70000,1, "zapatos");
        Producto producto2=new Producto(100000,2,"bolso");
        Producto producto3=new Producto(30000,3,"medias");
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);

    }
    public static ProductoRepository getInstance(){
        if (instancia==null)
        {
            instancia=new ProductoRepository();

        }
        return instancia;
    }
    public Producto getProducto(int id){
        for (Producto productoCogido:listaProductos) {
            if(productoCogido.getId()==id){
                return productoCogido;
            }

        }
        return null;
    }
}
