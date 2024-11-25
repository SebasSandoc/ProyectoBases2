
package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
   
    public static List<Cliente> consultar(String op) {

        List<Cliente> lista = new ArrayList<>();
        PreparedStatement psnt;
        ResultSet rs;
        Conexion cx = new Conexion();
        Connection con = cx.getCnn();
        try {
            psnt = con.prepareStatement("SELECT * FROM Cliente");
            //psnt = con.prepareStatement(SQL_READ_ALL);
            rs = psnt.executeQuery();
            while (rs.next()) {
                Cliente user = new Cliente(
                        rs.getInt("clienteID"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("genero"),
                        rs.getString("direccion"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDate("fechaNacimiento")
                );
                lista.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("error al consultar la tabla usuario: " + ex.getMessage());
        } finally {
            System.out.println("busqueda finalizada");
        }
        return lista;
    }
}
