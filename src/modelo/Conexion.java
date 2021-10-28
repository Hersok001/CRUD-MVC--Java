package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    // Inicialmente establecemos la conexión con la base de datos con la url, usuario y pass.
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/reto_5";
    String user = "root";
    String pass = "123456789-Hersok";
    
    //Metodo que establece la conexión.
    public Connection Getconection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error en la conexion" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
        }

        return con;
    }

}
