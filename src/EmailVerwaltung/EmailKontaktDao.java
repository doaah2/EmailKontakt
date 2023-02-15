package EmailVerwaltung;

import java.sql.*;

public class EmailKontaktDao {

    public EmailKontaktDao() {
        try {
            //Klasse wird dynamisch erzeugt für SQLLeit
            Class.forName("org.sqlite.JDBC");
            //Verbindung wird inizialisiert
            String datei= "src/EmailVerwaltung/email.db";
            String url= "jdbc:sqlite:" + datei;
            Connection conn=  DriverManager.getConnection(url);

            //Daten auslesen
            //Wie erzeugen eine SQL Anweisung
            String sql = "SELECT Vorname from email";
            PreparedStatement statement = conn.prepareStatement(sql);

            //SQL Anweisung ausführen
            ResultSet resultSet= statement.executeQuery();
            // Datensatzzeiger auf den ersten Datensatz setzen.
            while (resultSet.next()) {

                // Daten auslesen.
                String inhalt = resultSet.getString("Vorname");
                System.out.println(inhalt);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
public EmailKontakt select(int id){
        return null;
}
    public EmailKontakt first(){
        return null;
    }
    public EmailKontakt last(){
        return null;
    }
    public EmailKontakt next(EmailKontakt emailKontakt){
        return null;
    }
    public EmailKontakt previous(EmailKontakt emailKontakt){
        return null;
    }
    public void delete(EmailKontakt emailKontakt){
    }
    public void insert(EmailKontakt emailKontakt){
    }
    public void update(EmailKontakt emailKontakt){
    }


}
