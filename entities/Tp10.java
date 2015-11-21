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
            rightString = aArg;
        }

        if(leftString.charAt(0) == '-') {
            result += pIntTo10(leftString.substring(1));
            result += pFracTo10(rightString);
            result *= -1;
        } else {
            result += pIntTo10(leftString);
            result += pFracTo10(rightString);
        }

        return  ;
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

        return  ;
    }


    public void setP(int p) {
        if (p < 2 && p > TP_SYMBOLS.length())
            throw new IllegalArgumentException("Основание системы счисления должно быть от 2 до " + TP_SYMBOLS.length());
        this.fp = p;
    }


}
