package postoapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/postodb", "postgres", "root");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
