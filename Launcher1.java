

import com.nanlagger.entities.T10p;
import com.nanlagger.entities.Tp10;


public class Launcher1 {

    public static void main(String[] args) {
        Tp10 tp10 = new Tp10(16);
        float result = tp10.doTransfer("A1,F");
        System.out.println(result);

        T10p t10p = new T10p(16,5);
        String resultStr = t10p.doTransfer(result);
        System.out.println(resultStr);
    }
}
