/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.*;

/**
 *
 * @author Emendoza
 */
public class validarUsuario {
    
    static public int consultarUsuario(String nombre,String contrasena){
        int res;
        try{
            //Instancia la clase Conexion
            Conexion	db = new Conexion();
            //Obtiene la conexion a  la BD
            Connection	con = db.getConnection();
            
            if (con == null) {
            	res = 0;
            }
            else {
                // Sentencia para llamar un procedimiento almacenado a MySQL, con 2 variables IN y una OUT
                String call = "{call sp_iniciar_sesion(?,?,?)}";
                CallableStatement  	cs = con.prepareCall(call);
                //Envia 1er parametro variable IN
                cs.setString("user", nombre);
                //Envia 2do parametro variable IN
                cs.setString("con",contrasena);
                //Envia 3er parametro variable OUT
                cs.registerOutParameter(3, java.sql.Types.INTEGER);
                //Ejecuta el procedimiento
                cs.execute();
                //Obtiene la respuesta de la variable OUT
                res = cs.getInt("res");
                //Cierra el call statement
                cs.close();
                //Cierra la conexion
                con.close();
            }
        }catch(SQLException e) {
            res = 0;
        }
        return res;
    }
}
