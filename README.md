# Prueba Backend Maria Jose Romero


## Productos

Para hacer pruebas se dejaron tres productos quemados en la lista de persistencia.
~~~
{
"precio": 70000,
"id":1,
"nombre": "zapatos"
}
~~~
~~~
{
"precio": 100000,
"id":2,
"nombre": "bolso"
}
~~~
~~~
{
"precio": 30000,
"id":3,
"nombre": "medias"
}
~~~


## Pedidos

Endpoint localhost:8080/pedido

Para hacer pruebas se dejaron 2 pedidos (los que se ven abajo) quemados con diferentes fechas. Con este mismo formato menos el campo fecha se realiza el post del pedido. 

~~~
{
    "idProductosPedidos": [
        1
    ],
    "id": 2,
    "fecha": "2021-05-05T12:30:00"
}

~~~

~~~
{
    "idProductosPedidos": [
        1
    ],
    "id": 1,
    "fecha": "2021-05-06T08:30:00"
}
~~~

Luego de hacer un post o put que requieran una factura se retorna una con el siguiente formato:
~~~
{
    "valorIVA": 0.0,
    "precioFinal": 7000.0,
    "valorDomicilio": 0.0
}
~~~ 
### nota
En caso de que no se cumplan las condiciones de negocio no se maneja una excepcion ya que tuve tiempo limitado. En estos casos se retorna null.
