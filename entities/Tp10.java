package  entities;


public class Tp10 {

    private static final String TP_SYMBOLS = "0123456789ABCDEF";
    private int fp;

    public Tp10() {
        fp = 2;
    }

    public Tp10(int p) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
    }


    public void setP(int p) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
    }


}
