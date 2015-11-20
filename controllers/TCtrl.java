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
         
    }
      }
