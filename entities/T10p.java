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
    
    public String doTransfer(float aArg) 
    {
         String sen = "";
        if(aArg < 0) {
            sen = "-" + int10ToP((int) -aArg);
            sen += ",";
            sen += frac10ToP(-aArg);
        } else {
            sen = int10ToP((int) aArg);
            sen += ",";
            sen += frac10ToP(aArg);
        }
        return sen.charAt(sen.length()-1) == ',' ? sen.substring(0, sen.length()-1) : sen;
    }
    
   public void setP(int p) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
    }
    
     public int getP() 
     {
         return fp;
     }

private char intToPChar(int d) {
        char temp = TP_SYMBOLS.charAt(d);
        if(d < 0 || d >= 10) {
            throw new IllegalArgumentException("Неверное значение: " + d);
        }
        return temp;
    }
     private String int10ToP(int aArg) 
     {
         String sen = "";
        int left = aArg;
        while (left >= fp) {
            sen += TP_SYMBOLS.charAt(left % fp);
            left = left/fp;
        }
         sen += TP_SYMBOLS.charAt(left);
         sen = (new StringBuilder(sen)).reverse().toString();
         return sen;
     }
}
