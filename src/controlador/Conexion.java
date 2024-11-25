
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String user="root";
    private String pss="";
    private String url = "jdbc:sqlserver://localhost:1433;"+"database=Concesionario;"+"encrypt=true;"+"trustServerCertificate=true;"+"integratedSecurity=true;";

    public Conexion() {

    }

    public Connection getCnn() {
        try {
            return DriverManager.getConnection(url, user, pss);
        } catch (SQLException ex) {
            System.out.println("error "+ex);
        }
        return null;
    }
}
