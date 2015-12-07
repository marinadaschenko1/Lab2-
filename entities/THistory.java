package  entities;

import java.util.ArrayList;

public class THistory {

    public ArrayList<TRow> history = new ArrayList<TRow>();

    public void addRow(String data, int p, String data2, int p2) {
        history.add(new TRow(data, p, data2, p2));
    }

    public String readRow(int id) {
        return history.get(id).toString();
    }

    public int size() {
        return history.size();
    }

    public void clear() {
        history.removeAll(history);
    }

    private class TRow {
        private String data;
        private int pData;
        private String result;
        private int pResult;

        public TRow(String data, int p, String data2, int p2) {
            this.data = data;
            this.pData = p;
            this.result = data2;
            this.pResult = p2;
        }

        public String getData() {
            return data;
        }

        public String getResult() {
            return result;
        }

        public int getpData() {
            return pData;
        }

        public int getpResult() {
            return pResult;
        }

        @Override
        public String toString() {
            return new String(data + "(" + pData + ")" + " -> " + result + "(" + pResult + ")");
        }
    }
}
