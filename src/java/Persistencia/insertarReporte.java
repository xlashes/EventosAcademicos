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
public class insertarReporte {
    
    static public int almacenarReporte
       (String usuario,String objetivos,String logrosObt,String dificultades,
        String conclusiones,String otros){
        int res = 0;
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
                String call = "{call sp_insertar_reporte(?)}";
                CallableStatement  	cs = con.prepareCall(call);
                //Envia 1er parametro variable IN
                cs.setString("user", usuario);
                //Ejecuta el procedimiento
                cs.executeQuery();
                //Cierra el call statement
                cs.close();
                //Cierra la conexion
                con.close();
                res = 1;
            }
        }catch(SQLException e) {
            res = 0;
        }
        return res;
    }
}
