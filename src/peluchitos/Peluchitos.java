/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

La empresa Peluchitos.com lo acaba de contratar para que desarrollen un programa para
llevar la contabilidad del negocio. La idea básicamente es desarrollar un programa que
desplegará un menú como el siguiente:
1. Agregar Producto
2. Buscar Producto
3. Eliminar producto
4. Mostrar Inventario
5. Realizar Venta
6. Mostrar Ganancias totales
7. Salir
Funcionamiento:
1. Agregar Producto: Se debe almacenar el nombre del producto, se almacena la
cantidad de productos y se almacena el valor individual del producto.
2. Buscar Producto: Se digita el nombre del producto y se busca, si lo encuentra debe
visualizar el nombre del producto, la cantidad y el valor si no lo encuentra mostrara
un mensaje anunciando que el producto no existe.
3. Eliminar Producto: Se digita el nombre del producto y se busca, si lo encuentra lo
elimina junto con su valor y su cantidad, si no lo encuentra mostrara un mensaje
anunciando que el producto no existe.
4. Mostrar Inventario: Permite visualizar todos los productos, con sus cantidades y
precios.
5. Realizar ventas: Se debe digitar el nombre del producto, si lo encuentra, se le
solicitara al usuario la cantidad que desea vender, este dato debe quedar almacenado
6. Mostrar Ganancias Totales: Se visualizará cada uno de los productos con la
cantidad de ventas de cada producto y el valor total de la venta, finalmente muestra
el valor total de lo que ha vendido.



 */
package peluchitos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author julian
 */
public class Peluchitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        ArrayList<Producto> Prod=new ArrayList<>();
        int valor_total=0,a=0,b=0,menu,puntero=-10,unid=0;
        String palabra;
        while(a==0){
            System.out.println("1.Agregar Producto");
            System.out.println("2.Buscar Producto");
            System.out.println("3.Eliminar Producto");
            System.out.println("4.Mostrar Inventario");
            System.out.println("5.Realizar venta");
            System.out.println("6.Mostrar Ganancias Totales");
            System.out.println("7.Salir");
            menu=leer.nextInt();
            switch(menu){
                case(1):
                    Producto p=new Producto();
                    p.agregar_producto();
                    Prod.add(p);
                break;
                case(2):
                    System.out.println("Ingrese el nombre del producto que desea buscar: ");
                    palabra=leer.next();
                    puntero=-10;
                    for(b=0;b<Prod.size();b++){
                        if(palabra.equals(Prod.get(b).get_nombre())){
                            puntero=b;
                            b=Prod.size();
                        }
                    }
                    if(puntero==-10){
                        System.out.println("El producto no existe");
                        System.out.println("");
                    }else{
                        Prod.get(puntero).visualizar_producto();
                        puntero=-10;
                    }
                break;
                case(3):
                    System.out.println("Ingrese el nombre del producto que desea Eliminar: ");
                    palabra=leer.next();
                    for(b=0;b<Prod.size();b++){
                        if(palabra.equals(Prod.get(b).get_nombre())){
                            puntero=b;
                            b=Prod.size();
                        }else{
                            puntero=-10;
                        }
                    }
                    if(puntero==-10){
                        System.out.println("El producto no existe");
                        System.out.println("");
                    }else{
                        Prod.remove(puntero);
                        puntero=-10;
                        System.out.println("El producto ha sido eliminado");
                        System.out.println("");
                    }
                break;
                case(4):
                    for(b=0;b<Prod.size();b++){
                        Prod.get(b).visualizar_producto();
                    }                    
                break;
                case(5):
                    System.out.println("Ingrese el nombre del producto a vender: ");
                    palabra=leer.next();
                    for(b=0;b<Prod.size();b++){
                        if(palabra.equals(Prod.get(b).get_nombre())){
                            puntero=b;
                            b=Prod.size();
                        }else{
                            puntero=-10;
                        }
                    }
                    if(puntero==-10){
                        System.out.println("El producto no existe");
                        System.out.println("");
                    }else{
                        System.out.println("Cuantas unidades desea vender:");
                        unid=leer.nextInt();                        
                        Prod.get(puntero).venta(unid);
                        puntero=-10;
                    }
                break;
                case(6):
                    for(b=0;b<Prod.size();b++){
                        valor_total=valor_total+Prod.get(b).mostrar_venta();
                    } 
                    System.out.println("El valor total de lo que se ha vendido es: "+valor_total);
                    System.out.println("");
                    valor_total=0;
                break;
                case(7):
                    a=1;
                    System.out.println("Hasta luego");
                    System.out.println("");
                break;
                default:
                    System.out.println("DATO INCORRECTO");
                    System.out.println("");
                break;
            }
        }
    }
    
}
