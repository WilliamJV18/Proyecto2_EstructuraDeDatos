
package proyecto02_estructuradedatos;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class Cajas {
    // Tipo de Queue
    // BlockingQueue q = new LinkedBlockingDeque (5);
    
    // Se crea la cola caja
    private BlockingQueue caja;
    // Se pone el limite de las futuras cajas
    int limite = 5;
    
    // Se crea el constructor de la clase Cajas
    public Cajas(){
        // Se declara que la cola caja va a ser del tipo: LinkedBlockingDeque, 
        // la cual permite limitar el tamaño de la cola, entre otras cosas más..
        this.caja = new LinkedBlockingDeque(limite);
    }
    
    // Se crea el método de ingreso de clientes
    public void IngresarCliente (Object num_cliente){
        if(this.caja.size()< limite){
            this.caja.offer(num_cliente);
        }else{
            System.out.println("La caja está llena");
        }
    }
    
    // Se crea el método de retiro de clientes
    public Object RetirarCliente (){
        return this.caja.poll();
    }
    
    // Se crea el método frente para obtener el primer dato ingresado en la cola
    public void Frente(){
        this.caja.peek();
    }
    
    // Se crea el método tamaño para obtener la capacidad de cada caja
    public int Tamano(){
        return this.caja.size();
    }
    
}
