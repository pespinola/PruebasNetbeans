/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class PersonaControlador {
    
    private Statement st;
    private ResultSet rs;
    private Connection cnn;
    boolean ok;

    Conexion conexion = new Conexion();
            
    public PersonaControlador() {
         try{
            conexion.getConexion(); // se intenta conectar a la base de datos
         }catch(Exception e){
          System.out.println("Error al conectar "+e.getMessage());
         }
    }
    
    public boolean insertar(Persona per){
     
        try{
            System.out.println("NOMBRE "+per.getNombre());
            System.out.println("EDAD "+per.getEdad());
            String query = "insert into persona values ('2', '"+per.getNombre()+"', '"+per.getEdad()+"')";
            System.out.println("QUERY "+query);
            st = cnn.createStatement();
            st.executeUpdate(query); //como es un insert se utiliza executeUpdate, si era un select executeQuery
            conexion.cerrarSesion();
            return true;
        }catch(SQLException ex){
            System.out.println("Error al insertar "+ex.getMessage());
            return false;  //no inserta
        }
      
    }
    
    public ArrayList<Persona> consultar(){
       
        ArrayList<Persona> persona = new ArrayList<Persona>();
        
       try{
            String query = "Select * from persona";
            st = cnn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                persona.add(new Persona(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        }catch(SQLException ex){
            System.out.println("Error al consultar "+ex.getMessage());
            
        }
       return persona;
    }
    
    
    
}
