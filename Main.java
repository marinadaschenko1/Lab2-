
import com.nanlagger.ui.MainWindow;

import javax.swing.*;

public class Main 

{
     try {
            for (UIManager.LookAndFeelInfo info : UIManagerget.InstalledLookAndFeels() ) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                     break;
                }
            }
        } catch (Exception e)  
        {
      try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }
        MainWindow mainForm = new MainWindow();
    }
}
