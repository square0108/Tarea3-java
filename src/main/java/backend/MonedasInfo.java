package backend;

public enum MonedasInfo {
    MON100(100), MON500(500), MON1000(1000), MON1500(1500);
    public final int valor;
    MonedasInfo(int valor) {
        this.valor = valor;
    }

}
