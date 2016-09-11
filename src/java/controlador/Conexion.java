/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    
    private Connection con;
    
    public Conexion() {
        
    }
    
    public Connection getConexion(){
       try{
          Class.forName("org.postgresql.Driver");
          con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ejemplo", "postgres","admin");
          System.out.println("Exitosa conexion");
          return con;
       }catch(Exception e){
           System.out.println("Problemas al conectar "+e.getMessage());
       }
        return con;
    }
    
    public Connection cerrarSesion(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
            
            
    
}
