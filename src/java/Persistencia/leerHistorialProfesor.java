/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Emendoza
 */
public class leerHistorialProfesor {
    
    /**
     * 
     * @param usuario 
     * @return Lista de filas del historial de solicitudes para ese usuario 
     */
    static public ArrayList<String[]> obtenerhistorialProfesor(String usuario){
        ArrayList<String[]> res = new ArrayList<String[]>();
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
                String call = "{call sp_mostrar_historial_solicitud_profesor(?)}";
                CallableStatement  	cs = con.prepareCall(call);
                //Envia 1er parametro variable IN
                cs.setString("user", usuario);
                //Ejecuta el procedimiento
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    String[] fila = new String[4];
                    //Obtiene el nombre del evento
                    fila[0] = (String)rs.getString(1);
                    //La fecha de inicio del evento
                    fila[1] = (String)rs.getString(2);
                    //Fecha de envio solicitud
                    fila[2] = (String)rs.getString(3);
                    //Estado de solicitud
                    fila[3] = (String)rs.getString(4);
                    res.add(fila);
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
