package  entities;


public class T10p {

    private static final String TP_SYMBOLS = "0123456789ABCDEF";
    private int fp;
    private int fa;

    public T10p() {
        fp = 2;
        fa = 2;
    }

    public T10p(int p, int a) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
        this.fa = a;
    }



    public void setP(int p) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
    }


}
