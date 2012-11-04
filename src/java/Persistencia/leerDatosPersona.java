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
public class leerDatosPersona {
    
    static public String[] obtenerDatosPersona(String usuario){
        String[] res = new String[3];
        try{
            //Instancia la clase Conexion
            Conexion	db = new Conexion();
            //Obtiene la conexion a  la BD
            Connection	con = db.getConnection();
            
            if (con == null) {
            	res = null;
            }
            else {
                // Sentencia para llamar un procedimiento almacenado a MySQL, con 2 variables IN y una OUT
                String call = "{call sp_cargar_datos_usuario(?)}";
                CallableStatement  	cs = con.prepareCall(call);
                //Envia 1er parametro variable IN
                cs.setString("user", usuario);
                //Ejecuta el procedimiento
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    //Obtiene el nombre de la persona
                    res[0] = (String)rs.getString(1);
                    //Obtiene los aellidos de la persona
                    res[1] = (String)rs.getString(2);
                    //Obtiene el titulo academico de la persona
                    res[2] = (String)rs.getString(3);
                }
                //Cierra el resultado
                rs.close();
                //Cierra el call statement
                cs.close();
                //Cierra la conexion
                con.close();
            }
        }catch(SQLException e) {
            res = null;
        }
        return res;
    }
}
