/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluchitos;

import java.util.Scanner;

/**
 *
 * @author julian
 */
public class Producto {
    private String nombre_producto;
    private int cantidad,precio_individual,unidades_vendidas,valor_venta;
    private Scanner leer;
    public void agregar_producto(){
        leer= new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto:");
        this.nombre_producto=leer.next();
        System.out.println("Ingrese la cantidad del producto:");
        this.cantidad=leer.nextInt();
        System.out.println("Ingrese el valor individual del producto:");
        this.precio_individual=leer.nextInt();
        this.unidades_vendidas=0;
        this.valor_venta=0;
        
    }
    public void visualizar_producto(){
        System.out.println("NOMBRE DEL PRODUCTO: "+this.nombre_producto);
        System.out.println("UNIDADES DISPONIBLES: "+this.cantidad);
        System.out.println("PRECIO DE LA UNIDAD: "+this.precio_individual);
        System.out.println("");
    }
    public int mostrar_venta(){
        System.out.println("NOMBRE DEL PRODUCTO: "+this.nombre_producto);
        System.out.println("UNIDADES VENDIDAS: "+this.unidades_vendidas);
        System.out.println("VALOR TOTAL DE LA VENTA DEL PRODUCTO: "+this.valor_venta);
        System.out.println("");
        return this.valor_venta;
    }
    public void venta(int a){
        if(a<=this.cantidad){
            cantidad=cantidad-a;
            unidades_vendidas=unidades_vendidas+a;
            valor_venta=valor_venta+(precio_individual*a);
            System.out.println("Gracias por su compra");
            System.out.println("");
        }
        else{
            System.out.println("No hay suficientes unidades");
            System.out.println("");
        }
    }
    public String get_nombre(){
        return nombre_producto;
    }
     
}
