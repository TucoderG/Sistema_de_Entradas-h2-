# Sistema_de_Entradas-h2-
Este proyecto es una aplicacion echa a base de java.swing con interfaz de usuario, vendedor y administrador para la venta comercial de entradas a diversos eventos.

Contiene la coneccion a la base de datos h2 en la carpeta /src/base_datos 
con las acciones correspondientes al manejo de cada tabla de la BD(INSERT, DELETE, LIST, SELECT, UPDATE)

Entre la capa de la base de datos y la interfaz de usuario utilizo una capa Service la cual va a proporcionar informacion que solicite el usuario.
Lo hara comunicandose con la base de datos y la interfaz grafica de usuario.

Hay 3 tipos de entidades: 

 .Usuario: esta entidad podra crearse una cuenta, modificarla e ingresar a la misma para la eleccion y/o compra de entradas para el evento al que desee ir.
 .Vendedor: este podra ingresar por medio de una cuenta creada y delegada por el administrador del sistema, éste dispondra de una cantidad de entradas determinadas
    tambien por el administrador para vender y podra visualizar cuantos usuarios compraron cuantas entradas.
 .Administrador: esta ultima entidad va a ser la que maneje la gran parte del sistema, podra ver los usuarios, vendedores y eventos creados.
    Este ente podra eliminar alguna cuenta de usuario, de vendedor. Puede crear uno o varios eventos, y como ya se mencionó crear cuentas de vendedores
    para que vendan las entradas correspondientes.
 
