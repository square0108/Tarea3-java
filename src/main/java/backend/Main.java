package backend;

public class Main {
    public static void main(String[] args){
        try {
            // Se crea una maquina expendedora con 4 de cada producto
            Expendedor Maquina = new Expendedor(4);

            // Creación de monedas a utilizar
            Moneda500 CincoCienPeso = new Moneda500();
            Moneda100 CienPeso = new Moneda100();
            Moneda1500 QuinceCienPeso = new Moneda1500();

            // Casos de compra existosos, notar que la compra se hace en el constructor de Comprador
            Comprador Pepito = new Comprador(Maquina, Catalogo.COCA.id, CincoCienPeso);
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.SPRITE.id, CincoCienPeso);
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.SNICKERS.id, QuinceCienPeso);
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.FANTA.id, new Moneda500());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());
            Pepito = new Comprador(Maquina, Catalogo.SUPER8.id, new Moneda1000());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());

            // Caso con Excepción tipo: Pago Insuficiente, notemos que esta es atrapada.
            Pepito = new Comprador(Maquina, Catalogo.SPRITE.id, new Moneda100());
            System.out.println("Nueva compra: " + Pepito.getSabor() + ", Vuelto: " + Pepito.cuantoVuelto());

            System.out.println("\nNo hubieron excepciones... por ahora.");
        }
        catch (PagoIncorrectoException e) {
            System.err.println("Error. La moneda ingresada no es valida.");
        }
        catch (NoHayProductoException e) {
            System.err.println("Error. No hay stock o el producto ingresado no existe.");
        }
        catch (PagoInsuficienteException e) {
            System.err.println("Error. El monto ingresado es insuficiente para pagar este producto. ");
        }

        try {
            // Caso con Excepcion tipo: No Hay Producto (el producto deseado no existe.)
            Comprador Leopoldo = new Comprador(new Expendedor(3), 31, new Moneda1500());
            System.out.println("Nueva compra: " + Leopoldo.getSabor() + ", Vuelto: " + Leopoldo.cuantoVuelto());
        }
        catch (PagoIncorrectoException e) {
            System.err.println("Error. La moneda ingresada no es valida.");
        }
        catch (NoHayProductoException e) {
            System.err.println("Error. No hay stock o el producto ingresado no existe.");
        }
        catch (PagoInsuficienteException e) {
            System.err.println("Error. El monto ingresado es insuficiente para pagar este producto. ");
        }

        try {
            // Caso con Excepcion tipo: No Hay Producto (no queda stock.)
            Expendedor StockUno = new Expendedor(1);
            Comprador Osaa = new Comprador(StockUno, Catalogo.SNICKERS.id, new Moneda1500());
            System.out.println("Nueva compra: " + Osaa.getSabor() + ", Vuelto: " + Osaa.cuantoVuelto());
            Osaa = new Comprador(StockUno, Catalogo.SNICKERS.id, new Moneda1500());
            System.out.println("Nueva compra: " + Osaa.getSabor() + ", Vuelto: " + Osaa.cuantoVuelto());
        }
        catch (PagoIncorrectoException e) {
            System.err.println("Error. La moneda ingresada no es valida.");
        }
        catch (NoHayProductoException e) {
            System.err.println("Error. No hay stock o el producto ingresado no existe.");
        }
        catch (PagoInsuficienteException e) {
            System.err.println("Error. El monto ingresado es insuficiente para pagar este producto. ");
        }

        try {
            // Caso con Excepcion tipo: Pago Incorrecto (moneda null)
            Expendedor StockUno = new Expendedor(1);
            Comprador Ladron = new Comprador(StockUno, Catalogo.SNICKERS.id, null);
            System.out.println("Nueva compra: " + Ladron.getSabor() + ", Vuelto: " + Ladron.cuantoVuelto());
        }
        catch (PagoIncorrectoException e) {
            System.err.println("Error. La moneda ingresada no es valida.");
        }
        catch (NoHayProductoException e) {
            System.err.println("Error. No hay stock o el producto ingresado no existe.");
        }
        catch (PagoInsuficienteException e) {
            System.err.println("Error. El monto ingresado es insuficiente para pagar este producto. ");
        }
    }
}
