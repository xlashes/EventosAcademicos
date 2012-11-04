/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * Clase que permite crear conexion con la BD
 */
public class Conexion {
    
    private String driver = "com.mysql.jdbc.Driver";
    //private String url= "jdbc:mysql://72.13.93.200:3307/admibecas";
    private String url= "jdbc:mysql://localhost:3306/admibecas";
    //private String user = "admibecas";
    private String user = "root";
    //private String password = "sequifo2009";
    private String password = "Mysql";
    
    public Connection getConnection() {
        Connection cn;
        try{
            Class.forName(driver).newInstance();//Obtiene el driver de mysql
            cn= DriverManager.getConnection(url, user, password);//Conecta a la BD de la URL

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
