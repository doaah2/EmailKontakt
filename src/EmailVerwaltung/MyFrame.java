package EmailVerwaltung;

import javax.swing.*;
import java.sql.SQLException;

public class MyFrame extends JFrame {
    MyFrame(){
        setVisible(true);
        JFrameEmailverwaltung mb = null;
        try {
            mb = new JFrameEmailverwaltung();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        setContentPane(mb.getPanel1());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

}
