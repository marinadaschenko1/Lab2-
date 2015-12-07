package controllers;

import  entities.*;

public class TCtrl {

    private static TCtrl instance = null;

    private TEditor editor = new TEditor();
    private THistory history = new THistory();
    private T10p fc1 = new T10p();
    private Tp10 fc2 = new Tp10();

    public static TCtrl getInstance() {
        if(instance == null) {
            instance = new TCtrl();
        }
        return instance;
    }

    public String doCommand(int command) {
     if(command == Commands.GET_HISTORY) {
        String result = "";
        for (int i = 0; i < history.size(); i++) {
            result += i + ".) " + history.readRow(i) + "\n";
        }
        return result;
    }
    if(command == Commands.CLEAR_HISTORY)
    {
         history.clear();
         return "";
         
    }
    if(command == Commands.CONVERT) {

        fc1.setA(editor.read().substring(editor.read().indexOf(',')+1 == 0 ? editor.read().length() : editor.read().indexOf(',')+1).length());
        String result = fc1.doTransfer(fc2.doTransfer(editor.read()));
        history.addRow(editor.read(), fc2.getP(), result, fc1.getP());
        return result;
    }
    return editor.edit(command);
}

    public void setInP(int p) {
        fc2.setP(p);
    }

    public void setOutP(int p) {
        fc1.setP(p);
    }
     
      }
