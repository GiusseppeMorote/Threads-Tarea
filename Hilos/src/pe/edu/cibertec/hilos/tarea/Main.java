
package pe.edu.cibertec.hilos.tarea;


public class Main implements Runnable {

    private Cliente cliente;
    private Cajera cajera;
    private long initialTime;

    public Main(Cliente cliente, Cajera cajera, long initialTime) {
        this.cliente = cliente;
        this.cajera = cajera;
        this.initialTime = initialTime;
    }
    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        //Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        Runnable corredor1 = new Main(cliente1, cajera1, initialTime);
        Runnable corredor2 = new Main(cliente2, cajera2, initialTime);
        
        new Thread(corredor1).start();
        new Thread(corredor2).start();
        
    }

    @Override
    public void run() {
        this.cajera.procesarCompra(this.cliente, this.initialTime);
    }
}
