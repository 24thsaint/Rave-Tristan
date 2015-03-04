
import com.albertos.displays.login.LoginInterface;
import java.awt.LayoutManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/*
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 *  |      CENTRAL PHILIPPINE UNIVERSITY                   |
 *  |      Bachelor of Science in Software Engineering     |
 *  |      Jaro, Iloilo City, Philippines                  |
 *  |                                                      |
 *  |          This program is written by Rave, ©2015.     |
 *  |          You are free to use and distribute this.    |
 *  |          Reach me at: admin@blackout.biz.tm          |
 *  |                                                      |
 *  |               ~~~"CODE the FUTURE"~~~                |
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 */
/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class PizzaTest {

    public static void main(String[] args) {
        for (LookAndFeelInfo a : UIManager.getInstalledLookAndFeels()) {
            if (a.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(a.getClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PizzaTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(PizzaTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(PizzaTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PizzaTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        System.out.println("Entry point: Login Interface");
        System.out.println("Launching Entry Point...");

        LoginInterface loginInterface = new LoginInterface();
        loginInterface.setVisible(true);
        
        System.out.println("Entry Point Launched.");
    }
}
