package EmailVerwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JFrameEmailverwaltung extends Throwable {
    private JPanel panel1;
    private JButton suchenButton;
    private JTextField textFieldID;
    private JTextField textFieldNachname;
    private JTextField textFieldEmail;
    private JButton buttonFirst;
    private JButton buttonPrevios;
    private JButton neuButton;
    private JButton sichernButton;
    private JButton löschenButton;
    private JButton buttonNext;
    private JTextField textFieldVorname;
    private JButton LastButton;
    private EmailKontaktDao emailDao;

    public JFrameEmailverwaltung() throws SQLException, ClassNotFoundException {
        this.emailDao = new EmailKontaktDao();


        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailKontakt eKontakt = emailDao.select(Integer.parseInt(textFieldID.getText()));
                textFieldVorname.setText(String.valueOf(eKontakt.getVorname()));
                textFieldNachname.setText(String.valueOf(eKontakt.getNachname()));
                textFieldEmail.setText(String.valueOf(eKontakt.getEmail()));
            }

        });
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (buttonNext.isEnabled()){
                        EmailKontakt eKontakt = emailDao.next(emailDao.select(Integer.parseInt(textFieldID.getText())));
                        textFieldID.setText(String.valueOf(eKontakt.getId()));
                        textFieldVorname.setText(String.valueOf(eKontakt.getVorname()));
                        textFieldNachname.setText(String.valueOf(eKontakt.getNachname()));
                        textFieldEmail.setText(String.valueOf(eKontakt.getEmail()));

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        buttonPrevios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (buttonPrevios.isEnabled()){
                        EmailKontakt eKontakt = emailDao.previous(emailDao.select(Integer.parseInt(textFieldID.getText())));
                        textFieldID.setText(String.valueOf(eKontakt.getId()));
                        textFieldVorname.setText(String.valueOf(eKontakt.getVorname()));
                        textFieldNachname.setText(String.valueOf(eKontakt.getNachname()));
                        textFieldEmail.setText(String.valueOf(eKontakt.getEmail()));

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        löschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (löschenButton.isEnabled()){
                        EmailKontakt eKontakt = emailDao.delete(emailDao.select(Integer.parseInt(textFieldID.getText())));
                        textFieldID.setText(String.valueOf(eKontakt.getId()));
                        textFieldVorname.setText(String.valueOf(eKontakt.getVorname()));
                        textFieldNachname.setText(String.valueOf(eKontakt.getNachname()));
                        textFieldEmail.setText(String.valueOf(eKontakt.getEmail()));

                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        neuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EmailKontakt eKontakt = new EmailKontakt();
                    eKontakt.setId(Integer.parseInt(textFieldID.getText()));
                    eKontakt.setVorname(textFieldVorname.getText());
                    eKontakt.setNachname(textFieldNachname.getText());
                    eKontakt.setEmail(textFieldEmail.getText());
                    emailDao.insert(eKontakt);

                    // Clear the text fields after inserting the new record
                    textFieldID.setText("");
                    textFieldVorname.setText("");
                    textFieldNachname.setText("");
                    textFieldEmail.setText("");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        sichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }

    public JPanel getPanel1() {
        return panel1;
    }

}
