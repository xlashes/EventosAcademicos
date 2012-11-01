/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Array.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * Clase que permite crear conexion con la BD
 */
public class Conexion {
    
    private String driver = "com.mysql.jdbc.Driver";
    private String url= "jdbc:mysql://72.13.93.200:3307/admibecas";
   //private String url= "jdbc:mysql://localhost:3306/eventosacademicos";
    private String user = "admibecas";
    private String password = "sequifo2009";
    
    public Connection getConnection() {
    Connection cn= null;

        try{
            Class.forName(driver).newInstance();//Obtenmos el driver de mysql
            cn= DriverManager.getConnection(url, user, password);//Conectamos a nuestra data

        } catch(SQLException e) {
            System.out.println(e.toString());
            cn= null;
        } catch(Exception e) {
            System.out.println(e.toString());
            cn= null;
        }
        
        return cn;
    }
}
