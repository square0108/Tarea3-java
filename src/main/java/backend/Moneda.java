package backend;

/**
 * Clase abstracta Moneda.
 * @see Moneda100
 * @see Moneda500
 * @see Moneda1000
 * @see Moneda1500
 */
public abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){}

    /**
     * Retorna el valor de las subclases de Moneda, es abstract ya que los valores varian segun la subclase.
     * @return int valor monetario de la moneda, por ejemplo 100, 500, 1000...
     */
    public abstract int getValor();

    /**
     * Retorna una String con el valor de la referencia que tiene la moneda.
     * @return String referencia del objeto
     */
    public String getSerie(){
        return super.toString();
    }

    /**
     * Retorna una string con el valor en dinero de la moneda y su numero de serie.
     * @return String valor y serie
     */
    @Override
    public String toString(){
        return ("Valor: " + this.getValor() + ", Serie: " + getSerie());
    }

    /**
     * Implementacion de la interfaz Comparable, permite comparar los valores de distintas monedas segun su getValor().
     * @param o the object to be compared.
     * @return int resultado de la comparacion, si es que la moneda es de mayor, menor o igual valor que la otra.
     */
    public int compareTo(Moneda o){
        if (this.getValor() > o.getValor()) {
            return 1;
        }
        else if (this.getValor() < o.getValor()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
