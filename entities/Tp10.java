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
    
       public float doTransfer(String aArg) {
        float result = 0;
        String[] number;
        String leftString;
        String rightString;

        number = aArg.split(",");

        try {
            leftString = number[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            leftString = aArg;
        }
        try {
            rightString = number[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            rightString = "";
        }

        if(leftString.charAt(0) == '-') {
            result += pIntTo10(leftString.substring(1));
            result += pFracTo10(rightString);
            result *= -1;
        } else {
            result += pIntTo10(leftString);
            result += pFracTo10(rightString);
        }

        return result;
    }
    
    public float doTransfer(String aArg) 
    {
        float result = 0;
        String[] number;
        String leftString;
        String rightString;

        number = aArg.split(",");

        try {
            leftString = number[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            leftString = aArg;
        }
        try {
            rightString = number[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            rightString = "";
        }

        if(leftString.charAt(0) == '-') {
            result += pIntTo10(leftString.substring(1));
            result += pFracTo10(rightString);
            result *= -1;
        } else {
            result += pIntTo10(leftString);
            result += pFracTo10(rightString);
        }

        return result;
    }


    public void setP(int p) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
    }
    
     public int getP() {
        return fp;
    }

    private int pCharToInt(char symbol) {
        int temp = TP_SYMBOLS.indexOf(symbol);
        if(temp >= this.fp) {
            throw new IllegalArgumentException("Неверный символ: " + symbol);
        }
        return temp;
    }

    private int pIntTo10(String aArg) {
        int result = 0;
        for(int i=0; i<aArg.length(); i++) {
            int temp = pCharToInt(aArg.charAt(i));
            result += temp * ((int) Math.pow(this.fp, aArg.length() - (i+1)));
        }

        return result;
    }
    
   private float pFracTo10(String aArg)
   
   {
        float result = 0;
        for (int i = 0; i < aArg.length(); i++) {
            int temp = pCharToInt(aArg.charAt(i));
            result += temp * ((float) Math.pow(this.fp, -(i + 1)));
        }

        return result;
    }

}
