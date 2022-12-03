
package proyecto02_estructuradedatos;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class Proyecto02_EstructuraDeDatos {

    
    public static void main(String[] args) {
        
        
        // Se crean las variables y el objeto scanner
        Scanner sc = new Scanner(System.in);
        boolean salida = false;
        byte opcion = 0;
        
        // Se crean las colas y se les agregan algunos datos
        Cajas caja1 = new Cajas();
        caja1.IngresarCliente(01);
        caja1.IngresarCliente(02);
        caja1.IngresarCliente(03);
        Cajas caja2 = new Cajas();
        caja2.IngresarCliente(10);
        Cajas caja3 = new Cajas();
        caja3.IngresarCliente(15);
        caja3.IngresarCliente(16);
        Cajas caja4 = new Cajas();
        caja4.IngresarCliente(20);
        caja4.IngresarCliente(25);
        caja4.IngresarCliente(30);
        
        do { 
            // Se pone un try/catch para hacer constar cualquier error
            try{
                // Se crean las opciones para el menú;
                System.out.println("-----------------------------------------");
                System.out.println("                  MENÚ ");
                System.out.println("     ** Elija una de las opciones **");
                System.out.println(" ");
                System.out.println("1- Ingresar cliente a caja");
                System.out.println("2- Retirar cliente de caja");
                System.out.println("3- Mostrar capacidad actual de cada caja");
                System.out.println("4- Salir");
                System.out.println("-----------------------------------------");
                // Se lee el numero de la opción deseada
                System.out.println("Digite la opción: ");
                opcion = sc.nextByte();
                System.out.println("---------");
                
                // Se crea un arreglo para almacenar el tamaño de cada una de las cajas
                int capacidad [] = new int[4];
                capacidad[0]=caja1.Tamano();
                capacidad[1]=caja2.Tamano();
                capacidad[2]=caja3.Tamano();
                capacidad[3]=caja4.Tamano();
                
                // Se crean dos variables y se igualan al digito del arreglo en 0
                int menor, mayor;
                mayor = menor = capacidad[0];
                
                // Se crea un bucle for para buscar el numero mayor y menor del arreglo
                for (int i = 0; i < capacidad.length; i++) {
                    if (capacidad[i] > mayor){
                    mayor = capacidad[i];
                    }
                    if (capacidad[i] < menor) {
                    menor = capacidad[i];
                    }
                }
                
                switch (opcion) {
                    case 1:
                        // Se inserta un nuevo cliente a la cola
                        System.out.println("Digite el número del cliente: ");
                        int num_cliente = sc.nextInt();
                        
                        // Se verifica la menor cantidad de clientes entre las 4 cajas
                        if(caja1.Tamano()== menor){
                            caja1.IngresarCliente(num_cliente);
                        }else if(caja2.Tamano()== menor){
                            caja2.IngresarCliente(num_cliente);
                        }else if(caja3.Tamano()== menor){
                            caja3.IngresarCliente(num_cliente);
                        }else if(caja4.Tamano()== menor){
                            caja4.IngresarCliente(num_cliente);
                        }
                        break;
                    case 2:
                        // Se elimina el cliente que entró primero
                        // y de la cola mas grande
                        if(caja1.Tamano()== mayor){
                            System.out.println("Se retiró el cliente: "+caja1.RetirarCliente());
                        }else if(caja2.Tamano()== mayor){
                            System.out.println("Se retiró el cliente: "+caja2.RetirarCliente());
                        }else if(caja3.Tamano()== mayor){
                            System.out.println("Se retiró el cliente: "+caja3.RetirarCliente());
                        }else if(caja4.Tamano()== mayor){
                            System.out.println("Se retiró el cliente: "+caja4.RetirarCliente());
                        }
                        break;
                    case 3:
                        // Se muestra la capacidad actual de cada caja
                        for (int i = 0; i < 1; i++) {
                            System.out.println("Caja 1: "+capacidad[i]);
                            System.out.println("Caja 2: "+capacidad[i+1]);
                            System.out.println("Caja 3: "+capacidad[i+2]);
                            System.out.println("Caja 4: "+capacidad[i+3]);
                        }
                        break;
                    case 4:
                        // Opción para salir del programa
                        salida = true;
                        break;
                    default:
                        // Mensaje en caso de que no se escoja alguna de las opciones anteriores
                        JOptionPane.showMessageDialog(null, "Por favor digite alguna de las opciones anteriores");
                        break;
                }
               // Se captura cualquier posible excepción 
            } catch (NumberFormatException nfe){
                // Mensaje en caso de excepción de formato
                JOptionPane.showMessageDialog(null, "Por favor intentelo de nuevo. "+
                        "Error: "+nfe);
            } catch(Exception ex){
                // Mensaje en caso de excepción
                JOptionPane.showMessageDialog(null, "Por favor intentelo de nuevo. "+
                        "Error: "+ex);
            }
            System.out.println(" ");
            System.out.println("-----------------------------------------");
        } while(salida!=true);
        
    }
    
}
