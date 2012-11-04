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
public class leerBorradorSolicitud {
    
    static public String[] obtenerDatosBorradorSolicitud
       (String usuario,String evento,String fechaCreacion){
        String[] res = new String[10];
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
                String call = "{call sp_insertar_reporte(?)}";
                CallableStatement  	cs = con.prepareCall(call);
                //Envia 1er parametro variable IN
                cs.setString("user", usuario);
                cs.setString("evento", evento);
                cs.setString("fecha",fechaCreacion);
                //Ejecuta el procedimiento
                cs.executeQuery();
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
