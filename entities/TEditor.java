package  entities;

public class TEditor {

    private static final String TP_SYMBOLS = "0123456789ABCDEF";

    private String dem = "0";

    private void changeZnak() {
        if(dem.charAt(0) == '-') {
            dem = dem.substring(1);
        } else {
            if(!dem.equals("0"))
                dem = "-" + dem;
        }
    }

    private void addPDem(Integer a) {
        if(dem.equals("0")) {
            dem = "";
        }
        dem += TP_SYMBOLS.charAt(a);
    }

    private void addNull() {
        if(dem.equals("0")) {
            return;
        } else {
            dem += "0";
        }
    }

    private void addDel() {
        if (dem.contains(",")) {
            return;
        } else {
            dem += ",";
        }
    }

    private void backSpace() {
        if (dem.length() <= 1) {
            dem = "0";
        } else {
            dem = dem.substring(0, dem.length() - 1);
        }
    }

    private void clear() {
        dem = "0";
    }

    public String read() {
        return dem;
    }

    public void write(String a) {
        dem = a;
    }

    public String edit(Integer a) {
        switch (a) {
            case 0:
                addNull();
                break;
            case Commands.DEL:
                addDel();
                break;
            case Commands.BS:
                backSpace();
                break;
            case Commands.CL:
                clear();
                break;
            case Commands.CZ:
                changeZnak();
                break;
            default:
                addPDem(a);
                break;
        }
        return dem;
    }

}
