
package controlador;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.ClienteDAO;

public class ProyectoBases2 {
    
    

    public static void main(String[] args) {
        List<Cliente> t = new ArrayList<>();
        t=ClienteDAO.consultar("");
        System.out.println(t);
    }
    
}
