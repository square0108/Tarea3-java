package backend;
import java.util.ArrayList;

/**
 * Clase que simula el comportamiento de un deposito.
 * @param <T> Puede ser utilizada para cualquier tipo de objeto, pero esta pensada para almacenar:
 *           Monedas y Productos.
 */
public class Deposito<T> {
    private final ArrayList<T> array;
    public Deposito() {
        this.array = new ArrayList<>();
    }

    /**
     * Añade un objeto en la última posición del depósito.
     * @param object objeto a añadir al depósito.
     */
    public void add(T object) {
        this.array.add(object);
    }

    /**
     * Quita el primer objeto dentro del depósito.
     * @return referencia al objeto. Si esta vacio, devuelve null.
     */
    public T get() {
        if (!array.isEmpty()){
            return this.array.remove(0);
        } else {
            return null;
        }
    }

    /**
     * Entrega la cantidad de objetos dentro del deposito
     * @return cantidad de objetos: int
     */
    public int size(){
        return array.size();
    }

    /**
     * Entrega la referencia de un objeto dentro del deposito, no lo saca de este.
     * @param i indice del objeto.
     * @return referencia al objeto.
     */
    public T getItem(int i){
        return array.get(i);
    }
}
