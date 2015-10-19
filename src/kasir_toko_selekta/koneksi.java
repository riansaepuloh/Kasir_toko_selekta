/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir_toko_selekta;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author koncoi
 */
public class koneksi {
    public Properties mypanel,myLanguage;
    private String strNamePanel;
    public koneksi(){
        
    }
    public String SettingPanel(String nmPanel){
        try {
            mypanel = new Properties();
            mypanel.load(new FileInputStream("lib/database.ini"));
            strNamePanel = mypanel.getProperty(nmPanel);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return strNamePanel;
    }
}
