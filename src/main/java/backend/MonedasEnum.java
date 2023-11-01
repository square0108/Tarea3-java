package backend;

public enum MonedasEnum {
    MON100(100), MON500(500), MON1000(1000), MON1500(1500);
    public final int valor;
    MonedasEnum(int valor) {
        this.valor = valor;
    }

}
