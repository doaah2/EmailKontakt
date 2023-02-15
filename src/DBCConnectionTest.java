import java.sql.*;

public class DBCConnectionTest {
    public static void main(String[] args) {
        try {
            //Klasse wird dynamisch erzeugt für SQLLeit
            Class.forName("org.sqlite.JDBC");
            //Verbindung wird inizialisiert
            String datei= "World.db3";
            String url= "jdbc:sqlite:" + datei;
            Connection conn=  DriverManager.getConnection(url);

            //Daten auslesen
            //Wie erzeugen eine SQL Anweisung
             String sql = "SELECT * from City where CountryCode ='DEU'";
            PreparedStatement statement = conn.prepareStatement(sql);

            //SQL Anweisung ausführen
            ResultSet resultSet= statement.executeQuery();
            // Datensatzzeiger auf den ersten Datensatz setzen.
            while (resultSet.next()) {

                // Daten auslesen.
                String inhalt = resultSet.getString("Name");
                System.out.println(inhalt);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
